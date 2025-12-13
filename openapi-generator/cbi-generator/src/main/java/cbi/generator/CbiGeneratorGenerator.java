package cbi.generator;

import cbi.generator.relation.CBIRelationInfo;
import cbi.generator.relation.CBIRelationInfoNormal;
import cbi.generator.resource.CBIResourceInfo;
import cbi.generator.resource.CBIResourceInfoShared;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CbiGeneratorGenerator extends DefaultCodegen implements CodegenConfig {

  // source folder where to write the files
  protected String sourceFolder = "src/main/kotlin";
  protected String apiVersion = "1.0.0";

  /**
   * Configures the type of generator.
   *
   * @return  the CodegenType for this generator
   * @see     org.openapitools.codegen.CodegenType
   */
  public CodegenType getTag() {
    return CodegenType.OTHER;
  }

  /**
   * Configures a friendly name for the generator.  This will be used by the generator
   * to select the library with the -g flag.
   *
   * @return the friendly name for the generator
   */
  public String getName() {
    return "cbi-generator";
  }

  /**
   * Provides an opportunity to inspect and modify operation data before the code is generated.
   */
  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> allModels) {
    // to try debugging your code generator:
    // set a break point on the next line.
    // then debug the JUnit test called LaunchGeneratorInDebugger
    Map<String, Schema> schemas = this.openAPI.getComponents().getSchemas();

    for(ModelsMap modelMaps : allModels.values()) {
      for(ModelMap modelMap : modelMaps.getModels()) {
        CodegenModel model = modelMap.getModel();
        RequiredFixer.applyRequiredToCodegenModel(model, schemas);
        //model.vendorExtensions.put("x-test", "hi-its-test");
        //modelMap.setModel(model);
      }
    }
    //Build relationship model
    ArrayList<CBIResourceInfoShared> resources = CBIResourceInfo.getResourcesFromModels(allModels);
    ArrayList<CBIRelationInfo> relations = CBIRelationInfo.findAllRelations(resources);
    for(CBIRelationInfo relation: relations) {
      if(relation instanceof CBIRelationInfoNormal && relation.subRelations != null && !relation.subRelations.isEmpty()) {
        //relation.meta.hasBackward = false;
        //relation.meta.hasForward = false;
        Map<CBIResourceInfoShared, ArrayList<CBIRelationInfoNormal>> relationsByA = new HashMap<>();
        Map<CBIResourceInfoShared, ArrayList<CBIRelationInfoNormal>> relationsByB = new HashMap<>();

        relationsByA.put(relation.resourceA, new ArrayList<>(List.of((CBIRelationInfoNormal) relation)));
        relationsByB.put(((CBIRelationInfoNormal) relation).resourceB, new ArrayList<>(List.of((CBIRelationInfoNormal) relation)));
        for (CBIRelationInfo subRelation : relation.subRelations) {
          if (subRelation instanceof CBIRelationInfoNormal) {
            if(!relationsByA.containsKey(subRelation.resourceA))
              relationsByA.put(subRelation.resourceA, new ArrayList<>());
            relationsByA.get(subRelation.resourceA).add((CBIRelationInfoNormal) subRelation);
            if(!relationsByB.containsKey(((CBIRelationInfoNormal) subRelation).resourceB))
              relationsByB.put(((CBIRelationInfoNormal) subRelation).resourceB, new ArrayList<>());
            relationsByB.getOrDefault(((CBIRelationInfoNormal) subRelation).resourceB, new ArrayList<>()).add((CBIRelationInfoNormal) subRelation);
          }
        }



        relationsByA.forEach((resource, byA) -> {
          if(byA.size() >= 2) {
            CBIRelationInfoNormal relationMatch = null;
            for(CBIRelationInfoNormal relationByA: byA) {
              boolean isABase = relationByA.resourceA.isBase();
              boolean isBBase = relationByA.resourceB.isBase();
              boolean isADAO = relationByA.resourceA.isDAO();
              boolean isBDAO = relationByA.resourceB.isDAO();
              String suffixA = relationByA.resourceA.getResourceSuffix();
              String suffixB = relationByA.resourceB.getResourceSuffix();
              boolean suffixMatch = suffixA != null && suffixA.equals(suffixB);
              if(isADAO){
                if(isBDAO){
                  relationMatch = relationByA;
                  break;
                }
              }else if(isBBase){
                relationMatch = relationByA;
                if(isABase) {
                  break;
                }
              }else if(suffixMatch){
                relationMatch = relationByA;
                break;
              }
            }
            final CBIRelationInfoNormal relationMatchF = relationMatch;
            byA.forEach(relationByA -> {
              boolean isMatch = relationByA.equals(relationMatchF);
              if (isMatch) {
                relationByA.meta.hasForward = true;
              } else {
                relationByA.forwardOverride = true;
                relationByA.meta.hasForward = false;
              }
            });
          }
        });
        relationsByB.forEach((resource, byB) -> {
          if(byB.size() >= 2) {
            CBIRelationInfoNormal relationMatch = null;
            for(CBIRelationInfoNormal relationByB: byB) {
              boolean isABase = relationByB.resourceA.isBase();
              boolean isBBase = relationByB.resourceB.isBase();
              boolean isADAO = relationByB.resourceA.isDAO();
              boolean isBDAO = relationByB.resourceB.isDAO();
              String suffixA = relationByB.resourceA.getResourceSuffix();
              String suffixB = relationByB.resourceB.getResourceSuffix();
              boolean suffixMatch = suffixA != null && suffixA.equals(suffixB);
              if(isBDAO){
                if(isADAO){
                  relationMatch = relationByB;
                  break;
                }
              }else if(isABase){
                relationMatch = relationByB;
                if(isBBase) {
                  break;
                }
              }else if(suffixMatch){
                relationMatch = relationByB;
                break;
              }
            }
            final CBIRelationInfoNormal relationMatchF = relationMatch;
            byB.forEach(relationByB -> {
              boolean isMatch = relationByB.equals(relationMatchF);
              if (isMatch) {
                relationByB.meta.hasBackward = true;
              } else {
                relationByB.backwardOverride = true;
                relationByB.meta.hasBackward = false;
              }
            });
          }
        });
      }
    }
    for(CBIRelationInfo relation: relations) {
      if(relation.isBase())
        relation.mergeAndUpdateMetas();
    }
    for(CBIRelationInfo relation: relations) {
      if(relation instanceof CBIRelationInfoNormal) {
        relation.syncColumnsToModel();
      }
    }

    ArrayList<ModelMap> generatedAll = new ArrayList<>();

    for(CBIResourceInfoShared resource: resources) {
      resource.updateModelRefs();
      resource.updateColumns();
      /*if(resource instanceof CBIResourceInfo){
        ArrayList<CodegenModel> generated = ((CBIResourceInfo) resource).mergeSubResources();
        for(CodegenModel modelGenerated: generated) {
          ModelMap modelMap = new ModelMap();
          modelMap.setModel(modelGenerated);
          generatedAll.add(modelMap);
        }
      }*/
    }
    ArrayList<CBIResourceInfoShared.TypeUnionResult> results = new ArrayList<>();
    for(Map.Entry<String, ModelsMap> entry: allModels.entrySet()) {
      ModelsMap maps = entry.getValue();
      for(ModelMap map: maps.getModels()){
        CodegenModel model = map.getModel();
        if(model.interfaceModels != null && !model.interfaceModels.isEmpty()){
          ArrayList<CBIResourceInfoShared.TypeUnionResult> resultsParent = new ArrayList<>();
          for (Iterator<CodegenModel> it = model.interfaceModels.iterator(); it.hasNext(); ) {
            CodegenModel parentModel = it.next();
            CBIResourceInfoShared.TypeUnionResult result = CBIResourceInfoShared.typeUnion(model, parentModel);
            resultsParent.add(result);
            System.out.print("Base Model: " + model.name + "Parent Model: " + parentModel.name + ": ");
            if(!result.matchedAll) {
              it.remove();
              if(!result.matchedNone){
                result.shouldAdd = true;
                System.out.println("MATCHED SOME, ADDING SUB INTERFACE");
              }else {
                System.err.println("WARNING DELETING INTERFACE");
              }
            }else{
              System.out.println("MATCHED ALL, KEEPING INTERFACE");
            }
          }
          results.addAll(resultsParent);
          resultsParent.forEach(a -> {
            if(a.shouldAdd){
              if(a.modelParent.interfaceModels == null)
                a.modelParent.interfaceModels = new ArrayList<>();
              a.modelParent.interfaceModels.add(a.modelBoth);
              a.modelBase.interfaceModels.add(a.modelBoth);
            }
          });
        }
      }
    }
    for(CBIResourceInfoShared.TypeUnionResult result: results) {
      if(!result.matchedAll && !result.matchedNone) {
        ModelsMap modelsMapAdded = new ModelsMap();
        modelsMapAdded.setImports(List.of());
        ModelMap modelMapAdded = new ModelMap();
        modelMapAdded.put(result.modelBoth.name, result.modelBoth);
        modelMapAdded.setModel(result.modelBoth);
        modelsMapAdded.setModels(List.of(modelMapAdded));
        modelsMapAdded.put(result.modelBoth.classname, modelMapAdded);
        allModels.put(result.modelBoth.classFilename, modelsMapAdded);
      }
    }

    for(Map.Entry<String, ModelsMap> entry: allModels.entrySet()) {
      ModelsMap maps = entry.getValue();
      for (ModelMap map : maps.getModels()) {
        CodegenModel model = map.getModel();
        CBIResourceInfoShared.updateModelInterfaces(model);
        if(model.name.equals("LineItemDTO")) {
          System.out.println("WHATG");
        }
      }
    }



    /*OperationMap ops = results.getOperations();
    List<CodegenOperation> opList = ops.getOperation();
    // iterate over the operation and perhaps modify something
    for(CodegenOperation co : opList){
      // example:
      // co.httpMethod = co.httpMethod.toLowerCase();
    }*/
    return super.postProcessAllModels(allModels);
  }

  ArrayList<OpenAPI> additionalFiles = null;

  @Override
  public void processOpts() {
    super.processOpts();

    loadAdditionalFiles();

    mergeOperations();

    mergeModels();

    supportingFiles.add(new SupportingFile(
            "paths.kt.mustache", // template name
            sourceFolder, // folder inside output
            "Paths.kt" // generated file name
    ));

  }

  private void loadAdditionalFiles() {
    if (additionalFiles == null) {
      additionalFiles = new ArrayList<>();
      try {
        String inputSpecPath = (String) additionalProperties.get("inputSpec");
        if (inputSpecPath == null)
          inputSpecPath = this.inputSpec;
        Path specPath = Paths.get(inputSpecPath);
        Path specDir = specPath.toAbsolutePath().getParent();
        // Resolve relative folder from the spec file location
        Path folder = specDir.normalize();
        if (!Files.exists(folder)) {
          System.err.println("Extra path folder not found: " + folder);
          return;
        }
        List<Path> files = Files.walk(folder)
                .filter(p -> (p.toString().endsWith(".yaml")
                        || p.toString().endsWith(".yml")
                        || p.toString().endsWith(".json")) &&
                        !p.equals(specPath))
                .collect(Collectors.toList());

        System.out.println("Merging " + files.size() + " external path files...");

        System.out.println(specPath);

        for(Path p: files) {
          System.out.println(p);
        }

        if (openAPI.getPaths() == null) {
          openAPI.setPaths(new io.swagger.v3.oas.models.Paths());
        }

        ParseOptions options = new ParseOptions();
        options.setResolve(true);          // resolves $refs
        options.setResolveFully(false);     // resolves all refs completely
        options.setFlatten(true);          // flattens the model
        options.setValidateExternalRefs(true);
        options.setValidateInternalRefs(true);
        options.setResolveResponses(true);
        options.setResolveRequestBody(true);

        for (Path p : files) {
          File f = p.toFile();
          SwaggerParseResult parseResult = new OpenAPIV3Parser().readLocation(
                  f.getAbsolutePath(), null, options
          );

          if (parseResult == null) {
            throw new RuntimeException("PARSE RESULT IS NULL");
          }

          if (parseResult.getMessages() != null && !parseResult.getMessages().isEmpty()) {
            for(String message: parseResult.getMessages()) {
              System.out.println("MESSAGE: " + message);
            }
            List<String> missingRefMessages = parseResult.getMessages().stream()
                    .filter(m -> m.contains("is not of type `schema`") || m.contains("Could not find ") || m.contains("is missing")).collect(Collectors.toList());

            if (!missingRefMessages.isEmpty()) {
              throw new RuntimeException("Missing component reference in " + f.getName() + ": "
                      + String.join(", ", missingRefMessages));
            }

            // Optional: log other warnings
            //parseResult.getMessages().forEach(System.err::println);
          }

          OpenAPI extra = parseResult.getOpenAPI();
          if (extra == null || extra.getPaths() == null) {
            System.err.println("Skipping path file (no paths found): " + f);
          }

          additionalFiles.add(extra);
        }

      } catch (Exception e) {
        throw new RuntimeException("Failed to merge external paths", e);
      }
    }
  }

  private void mergeOperations() {
    if(this.openAPI.getPaths() == null)
      this.openAPI.setPaths(new io.swagger.v3.oas.models.Paths());
    this.additionalFiles.forEach(additional -> {
      additional.getPaths().forEach((pathName, path) -> {
        this.openAPI.getPaths().put(pathName, path);
      });
    });
  }

  private void mergeModels() {
    if(this.openAPI.getComponents() == null)
      this.openAPI.setComponents(new Components());
    if(this.openAPI.getComponents().getSchemas() == null)
      this.openAPI.getComponents().setSchemas(new TreeMap<>());
    this.additionalFiles.forEach(additional -> {
      additional.getComponents().getSchemas().forEach((schemaName, schema) -> {
        if(!this.openAPI.getComponents().getSchemas().containsKey(schemaName))
          if(!schemaName.endsWith("_1")) {
            RefNormalizer.normalizeRefs(schema);
            this.openAPI.getComponents().getSchemas().put(schemaName, schema);
          }
      });
    });
  }

  /**
   * Returns human-friendly help for the generator.  Provide the consumer with help
   * tips, parameters here
   *
   * @return A string value for the help message
   */
  public String getHelp() {
    return "Generates a cbi-generator client library.";
  }

  public CbiGeneratorGenerator() {
    super();

    typeMapping.put("integer", "kotlin.Int");      // integer → Int
    typeMapping.put("long", "kotlin.Long");        // long → Long
    typeMapping.put("number", "kotlin.Double");    // number → Double
    typeMapping.put("string", "kotlin.String");    // string → String
    typeMapping.put("boolean", "kotlin.Boolean");  // boolean → Boolean
    typeMapping.put("DateTime", "kotlinx.datetime.LocalDateTime"); // date-time → Instant
    typeMapping.put("Date", "kotlinx.datetime.LocalDate");
    typeMapping.put("date", "kotlinx.datetime.LocalDate");
    typeMapping.put("datetime", "kotlinx.datetime.LocalDateTime");
    importMapping.put("DateTime", "kotlinx.datetime.LocalDateTime"); // date-time → Instant
    importMapping.put("Date", "kotlinx.datetime.LocalDate");
    importMapping.put("date", "kotlinx.datetime.LocalDate");
    importMapping.put("datetime", "kotlinx.datetime.LocalDateTime");
    // set the output folder here
    outputFolder = "generated-code/cbi-generator";

    /**
     * Models.  You can write model files using the modelTemplateFiles map.
     * if you want to create one template for file, you can do so here.
     * for multiple files for model, just put another entry in the `modelTemplateFiles` with
     * a different extension
     */
    modelTemplateFiles.put(
            "model.mustache", // the template to use
            ".kt");       // the extension for each file to write

    /**
     * Api classes.  You can write classes for each Api file with the apiTemplateFiles map.
     * as with models, add multiple entries with different extensions for multiple files per
     * class
     */
    apiTemplateFiles.put(
            "api.mustache",   // the template to use
            ".kt");       // the extension for each file to write

    /**
     * Template Location.  This is the location which templates will be read from.  The generator
     * will use the resource stream to attempt to read the templates.
     */
    templateDir = "cbi-generator";

    /**
     * Api Package.  Optional, if needed, this can be used in templates
     */
    apiPackage = "org.communityboating.api";

    /**
     * Model Package.  Optional, if needed, this can be used in templates
     */
    modelPackage = "org.communityboating.model";

    /**
     * Reserved words.  Override this with reserved words specific to your language
     */
    reservedWords = new HashSet<String>(
            Arrays.asList(
                    "sample1",  // replace with static values
                    "sample2")
    );

    /**
     * Additional Properties.  These values can be passed to the templates and
     * are available in models, apis, and supporting files
     */
    additionalProperties.put("apiVersion", apiVersion);

    apiNameSuffix = "";

    /**
     * Supporting Files.  You can write single files for the generator with the
     * entire object tree available.  If the input file has a suffix of `.mustache
     * it will be processed by the template engine.  Otherwise, it will be copied
     */
    /*supportingFiles.add(new SupportingFile("myFile.mustache",   // the input template or file
            "",                                                       // the destination folder, relative `outputFolder`
            "myFile.sample")                                          // the output file
    );*/

    /**
     * Language Specific Primitives.  These types will not trigger imports by
     * the client generator
     */
    languageSpecificPrimitives = new HashSet<String>(
            Arrays.asList(
                    "integer",      // replace these with your types
                    "long",
                    "string")
    );
  }

  /**
   * Escapes a reserved word as defined in the `reservedWords` array. Handle escaping
   * those terms here.  This logic is only called if a variable matches the reserved words
   *
   * @return the escaped term
   */
  @Override
  public String escapeReservedWord(String name) {
    return "_" + name;  // add an underscore to the name
  }

  /**
   * Location to write model files.  You can use the modelPackage() as defined when the class is
   * instantiated
   */
  public String modelFileFolder() {
    return outputFolder + "/" + sourceFolder + "/" + modelPackage().replace('.', File.separatorChar);
  }

  /**
   * Location to write api files.  You can use the apiPackage() as defined when the class is
   * instantiated
   */
  @Override
  public String apiFileFolder() {
    return outputFolder + "/" + sourceFolder + "/" + apiPackage().replace('.', File.separatorChar);
  }

  /**
   * override with any special text escaping logic to handle unsafe
   * characters so as to avoid code injection
   *
   * @param input String to be cleaned up
   * @return string with unsafe characters removed or escaped
   */
  @Override
  public String escapeUnsafeCharacters(String input) {
    //TODO: check that this logic is safe to escape unsafe characters to avoid code injection
    return input;
  }

  /**
   * Escape single and/or double quote to avoid code injection
   *
   * @param input String to be cleaned up
   * @return string with quotation mark removed or escaped
   */
  public String escapeQuotationMark(String input) {
    //TODO: check that this logic is safe to escape quotation mark to avoid code injection
    return input.replace("\"", "\\\"");
  }
}
