package cbi.generator;

import cbi.generator.relation.CBIRelationInfo;
import cbi.generator.relation.CBIRelationInfoNormal;
import cbi.generator.resource.CBIResourceInfo;
import cbi.generator.resource.CBIResourceInfoShared;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.*;

import java.util.*;
import java.io.File;

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

    //Build relationship model

    ArrayList<CBIResourceInfoShared> resources = CBIResourceInfo.getResourcesFromModels(allModels);
    CBIRelationInfo.findAllRelations(resources);
    for(CBIResourceInfoShared resource: resources) {
      CBIResourceInfoShared.HighestRelations highestRelations = resource.getHighestRelations();
      for(CBIRelationInfo relation: resource.relations) {
        if(relation instanceof CBIRelationInfoNormal) {
          relation.meta.hasForward = false;
          relation.meta.hasBackward = false;
          if(highestRelations.A.contains(relation)){
            //if(relation.resourceA.equals(resource))
              relation.meta.hasForward = true;
            //if(((CBIRelationInfoNormal) relation).resourceB.equals(resource))
            //  relation.meta.hasBackward = true;
          }
          if(highestRelations.B.contains(relation)){
            relation.meta.hasBackward = true;
          }
          ((CBIRelationInfoNormal) relation).addMissingColumns();
        }
      }
      //resource.combineModelTypes();
      //resource.updateColumns();
    }

    ArrayList<ModelMap> generatedAll = new ArrayList<>();

    for(CBIResourceInfoShared resource: resources) {
      resource.updateModelRefs();
      resource.updateColumns();
      if(resource instanceof CBIResourceInfo){
        ArrayList<CodegenModel> generated = ((CBIResourceInfo) resource).mergeSubResources();
        for(CodegenModel modelGenerated: generated) {
          ModelMap modelMap = new ModelMap();
          modelMap.setModel(modelGenerated);
          generatedAll.add(modelMap);
        }
      }
      CBIResourceInfoShared.updateModelInterfaces(resource.model);

    }

    ModelsMap map = new ModelsMap();
    map.setModels(generatedAll);

    allModels.put("GENERATED", map);

    for(ModelsMap modelMaps : allModels.values()) {
      for(ModelMap modelMap : modelMaps.getModels()) {
        //CodegenModel model = modelMap.getModel();
        //model.vendorExtensions.put("x-test", "hi-its-test");
        //modelMap.setModel(model);
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

    typeMapping.put("integer", "Int");      // integer → Int
    typeMapping.put("long", "Long");        // long → Long
    typeMapping.put("number", "Double");    // number → Double
    typeMapping.put("string", "String");    // string → String
    typeMapping.put("boolean", "Boolean");  // boolean → Boolean
    typeMapping.put("DateTime", "kotlinx.datetime.LocalDateTime"); // date-time → Instant
    typeMapping.put("Date", "kotlinx.datetime.LocalDate");
    importMapping.put("DateTime", "kotlinx.datetime.LocalDateTime"); // date-time → Instant
    importMapping.put("Date", "kotlinx.datetime.LocalDate");

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
    apiPackage = "org.openapitools.api";

    /**
     * Model Package.  Optional, if needed, this can be used in templates
     */
    modelPackage = "org.openapitools.model";

    /**
     * Reserved words.  Override this with reserved words specific to your language
     */
    reservedWords = new HashSet<String> (
            Arrays.asList(
                    "sample1",  // replace with static values
                    "sample2")
    );

    /**
     * Additional Properties.  These values can be passed to the templates and
     * are available in models, apis, and supporting files
     */
    additionalProperties.put("apiVersion", apiVersion);

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
