package cbi.generator;

import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CBIResourceInfo {
    Boolean hasTable = true;
    Boolean hasDAO = true;
    Boolean hasDTO = true;
    Boolean isBase = false;
    String baseName;
    ArrayList<CBIColumnInfo> columns = new ArrayList<>();
    ArrayList<CodegenModel> generated = new ArrayList<>();
    ArrayList<CodegenModel> schema = new ArrayList<>();
    public ArrayList<CBIRelationInfo> relations = new ArrayList<>();
    static ArrayList<CBIResourceInfo> getResourcesFromModels(Map<String, ModelsMap> allModels){
        ArrayList<CBIResourceInfo> resources = new ArrayList<>();
        for(String modelName: allModels.keySet()){
            List<ModelMap> modelList = allModels.get(modelName).getModels();
            for(ModelMap modelMap : modelList) {
                CodegenModel model = modelMap.getModel();
                if(isBaseModel(model)){
                    CBIResourceInfo added = fromBaseModel(model);
                    resources.add(added);
                    for(ModelMap modelMap2 : modelList){
                        CodegenModel model2 = modelMap2.getModel();
                        if(model != model2 && isRelated(model, model2)){
                            added.schema.add(model2);
                        }
                    }
                }
            }
        }
        for(CBIResourceInfo resource: resources) {
            resource.updateColumns();
        }
        return resources;
    }
    @Override
    public int hashCode(){
        return baseName.hashCode();
    }
    @Override
    public boolean equals(final Object other){
        if(other == null)
            return false;
        if(other instanceof CBIResourceInfo){
            CBIResourceInfo otherCast = (CBIResourceInfo) other;
            return this.baseName.equals(otherCast.baseName);
        }
        return false;
    }
    public List<CBIRelationInfo> getRelations() {
        return relations;
    }
    static Boolean compareProperty(CodegenProperty property1, CodegenProperty property2) {
        return property1.name.equals(property2.name) && property1.dataType.equals(property2.dataType);
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
        for(CodegenModel modelGenerated : generated) {
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
        }
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
                if(!result.matchedNone && (!result.matchedAll || skipIfMatchAll)) {
                    added.add(result.model);
                }
            }
        }
        return added;
    }
    void combineModelTypes() {
        this.generated = combineModels(this.schema, this.schema, false);
        ArrayList<CodegenModel> added;
        do {
            added = combineModels(this.generated, this.schema, true);
            this.generated.addAll(added);
        } while(!added.isEmpty());
    }
    void updateModelRefs() {
        for(CodegenModel model: schema) {
            model.vendorExtensions.put("x-cbi-resource-info", this);
        }
    }
    void updateColumns() {
        columns.clear();
        for(CodegenModel model : schema) {
            for(CodegenProperty property : model.allVars) {
                CBIColumnInfo.CBIRelationDefinition relationDefinition = CBIColumnInfo.CBIRelationDefinition.fromModelAndProperty(new CBIColumnInfo.ModelAndProperty(model, property));
                if(relationDefinition != null) {
                    property.vendorExtensions.put("x-relation-definition-cloned", relationDefinition);
                }
                CBIColumnInfo.getOrAdd(columns, model, property);
            }
        }
    }
    static Boolean isBaseModel(CodegenModel model) {
        if(model.interfaceModels == null || model.interfaceModels.isEmpty())
            return true;
        for(CodegenModel parentModel: model.interfaceModels){
            if(parentModel.discriminator == null)
                return false;
        }
        return true;
    }
    static Boolean isRelated(CodegenModel base, CodegenModel other) {
        if(base.interfaceModels == null)
            return false;
        if(base.interfaceModels.contains(other))
            return true;
        for(CodegenModel sub : base.interfaceModels) {
            if(!isBaseModel(sub) && isRelated(sub, other))
                return true;
        }
        return false;
    }
    static CBIResourceInfo fromBaseModel(CodegenModel base) {
        CBIResourceInfo info = new CBIResourceInfo();
        info.baseName = base.name;
        info.schema.add(base);
        return info;
    }
}
