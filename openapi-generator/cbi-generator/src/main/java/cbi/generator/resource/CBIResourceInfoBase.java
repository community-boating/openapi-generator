package cbi.generator.resource;

import cbi.generator.CBIColumnInfo;
import cbi.generator.ModelAndProperty;
import cbi.generator.meta.CBIColumnMeta;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.relation.CBIRelationInfo;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.Iterator;

import static cbi.generator.meta.CBIModelMeta.getInheritedFrom;

public abstract class CBIResourceInfoBase {
    public String baseName;
    public ArrayList<CBIColumnInfo> columns = new ArrayList<>();
    //ArrayList<CodegenModel> generated = new ArrayList<>();
    //ArrayList<CodegenModel> schema = new ArrayList<>();
    public CodegenModel model;
    public ArrayList<CBIRelationInfo> relations = new ArrayList<>();
    //We had to figure out how to add relations to allOf child, other merging stuff relating to relationships and column definition.
    public static Boolean compareProperty(CodegenProperty property1, CodegenProperty property2) {
        boolean isEqual = property1.name.equals(property2.name) && property1.isArray == property2.isArray;
        if(isEqual){
            CBIColumnInfo column1 = CBIColumnInfo.fromProperty(property1);
            CBIColumnInfo column2 = CBIColumnInfo.fromProperty(property2);
        }
        return isEqual;
    }
    static class TypeUnionResult {
        CodegenModel model;
        Boolean matchedAll;
        Boolean matchedNone;
        Boolean fromExisting;
    }
    TypeUnionResult typeUnion(CodegenModel model1, CodegenModel model2) {
        TypeUnionResult result = new TypeUnionResult();
        result.model = new CodegenModel();
        result.model.allVars = new ArrayList<>();
        result.model.name = "TODO_UNION";
        result.matchedNone = true;
        result.fromExisting = false;
        boolean hasAll = true;
        for(CodegenProperty property1 : model1.allVars) {
            boolean hasVar = false;
            for(CodegenProperty property2: model2.allVars) {
                if(compareProperty(property1, property2)){
                    result.model.allVars.add(property1.clone());
                    result.matchedNone = false;
                    hasVar = true;
                }
            }
            if(!hasVar)
                hasAll = false;
        }
        result.matchedAll = hasAll;
        /*for(CodegenModel modelGenerated : generated) {
            hasAll = true;
            for(CodegenProperty property1 : modelGenerated.allVars) {
                boolean hasVar = false;
                for(CodegenProperty property2: result.model.allVars) {
                    if(compareProperty(property1, property2)){
                        hasVar = true;
                        break;
                    }
                }
                if(!hasVar)
                    hasAll = false;
            }
            if(hasAll){
                result.fromExisting = true;
                result.model = modelGenerated;
                break;
            }
        }*/
        if(model1.allVars.size() != model2.allVars.size() || model1.allVars.size() != result.model.allVars.size())
            result.matchedAll = false;
        return result;
    }
    ArrayList<CodegenModel> combineModels(ArrayList<CodegenModel> models1, ArrayList<CodegenModel> models2, Boolean skipIfMatchAll) {
        ArrayList<CodegenModel> added = new ArrayList<>();
        for(CodegenModel model1 : models1) {
            for(CodegenModel model2 : models2) {
                if(model1 == model2)
                    break;
                TypeUnionResult result = typeUnion(model1, model2);
                if (!result.matchedNone && (!result.matchedAll || skipIfMatchAll)) {
                    added.add(result.model);
                }
                if(result.model != null && !result.matchedNone){
                    if(model1.interfaceModels == null)
                        model1.interfaceModels = new ArrayList<>();
                    if(model2.interfaceModels == null)
                        model2.interfaceModels = new ArrayList<>();
                    model1.interfaceModels.add(result.model);
                    model2.interfaceModels.add(result.model);
                }
            }
        }
        return added;
    }
    void combineModelTypes() {
        /*this.generated = combineModels(this.schema, this.schema, false);
        ArrayList<CodegenModel> added;
        do {
            added = combineModels(this.generated, this.schema, true);
            this.generated.addAll(added);
        } while(!added.isEmpty());*/
    }
    public void updateModelRefs() {
        model.vendorExtensions.put("x-cbi-resource-info", this);
    }
    public void updateColumns() {
        //columns.clear();
        for (Iterator<CodegenProperty> it = model.allVars.iterator(); it.hasNext(); ) {
            CodegenProperty property = it.next();
            CBIRelationMeta relationMeta = CBIRelationMeta.fromModelAndProperty(new ModelAndProperty(model, property));
            if(relationMeta != null) {
                property.vendorExtensions.put("x-relation-meta-cloned", relationMeta);
            }
            CBIColumnInfo info = CBIColumnInfo.getOrAdd(columns, this, property);
            info.inheritedFrom = getInheritedFrom(property, model);
            property.isInherited = info.inheritedFrom != null;
        }
    }
}
