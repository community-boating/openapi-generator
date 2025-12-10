package cbi.generator.resource;

import cbi.generator.relation.CBIRelationInfo;
import cbi.generator.meta.CBIModelMeta;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CBIResourceInfo extends CBIResourceInfoShared {
    public ArrayList<CBIResourceInfoChild> subResources = new ArrayList<>();
    public static ArrayList<CBIResourceInfoShared> getResourcesFromModels(Map<String, ModelsMap> allModels){
        ArrayList<CBIResourceInfo> resources = new ArrayList<>();
        ArrayList<CBIResourceInfoChild> subResources = new ArrayList<>();
        ArrayList<CodegenModel> nonBaseModels = new ArrayList<>();
        ArrayList<CodegenModel> nonResourceModels = new ArrayList<>();
        for(String modelName: allModels.keySet()){
            if(!modelName.equals("DummyImport")) {
                List<ModelMap> modelList = allModels.get(modelName).getModels();
                for (ModelMap modelMap : modelList) {
                    CodegenModel model = modelMap.getModel();
                    if (CBIModelMeta.isBaseModel(model)) {
                        CBIResourceInfo added = fromBaseModel(model);
                        resources.add(added);
                    } else if (CBIModelMeta.isResourceModel(model)) {
                        nonBaseModels.add(model);
                    } else {
                        nonResourceModels.add(model);
                    }
                }
            }
        }
        for(CodegenModel model: nonBaseModels) {
            for(CBIResourceInfo resource : resources){
                CodegenModel model2 = resource.model;
                if (model != model2 && hasParentRecurse(model2, model)) {
                    CBIResourceInfoChild child = new CBIResourceInfoChild(resource, model);
                    resource.subResources.add(child);
                    subResources.add(child);
                }
            }
        }
        for(CodegenModel model: nonResourceModels) {
            CBIResourceInfoShared.updateColumns(model);
        }
        ArrayList<CBIResourceInfoShared> allResources = new ArrayList<>(resources.size() + subResources.size());
        allResources.addAll(resources);
        allResources.addAll(subResources);
        for(CBIResourceInfoShared resource: allResources) {
            resource.updateColumns();
        }
        return allResources;
    }

    public ArrayList<CodegenModel> getAllModels() {
        ArrayList<CodegenModel> models = new ArrayList<>();
        models.add(this.model);
        for(CBIResourceInfoChild sub: this.subResources) {
            models.add(sub.model);
        }
        return models;
    }

    public ArrayList<CodegenModel> mergeSubResources() {
        ArrayList<CodegenModel> allModels = this.getAllModels();
        ArrayList<CodegenModel> generated = combineModels(allModels, allModels, false);
        return generated;
    }

    public static CBIResourceInfoShared findByName(ArrayList<CBIResourceInfoShared> resources, String name) {
        for(CBIResourceInfoShared resource: resources) {
            if(resource.baseName.equals(name)){
                return resource;
            }
            if(resource instanceof CBIResourceInfo) {
                for (CBIResourceInfoChild subResource : ((CBIResourceInfo) resource).subResources) {
                    if (subResource.baseName.equals(name)) {
                        return subResource;
                    }
                }
            }
        }
        return null;
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

    static boolean hasParentRecurse(CodegenModel parent, CodegenModel child) {
        if(hasParent(parent, child))
            return true;
        if(child.interfaceModels != null) {
            for (CodegenModel childParent : child.interfaceModels) {
                if (!CBIModelMeta.isBaseModel(childParent) && hasParentRecurse(parent, childParent))
                    return true;
            }
        }
        return false;
    }
    static boolean hasParent(CodegenModel parent, CodegenModel child) {
        if(child.interfaceModels == null)
            return false;
        return child.interfaceModels.contains(parent);
    }
    static CBIResourceInfo fromBaseModel(CodegenModel base) {
        CBIResourceInfo info = new CBIResourceInfo();
        info.baseName = base.name;
        info.model = base;
        return info;
    }
}
