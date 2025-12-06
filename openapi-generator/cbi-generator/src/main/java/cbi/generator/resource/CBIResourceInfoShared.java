package cbi.generator.resource;

import cbi.generator.CBIColumnInfo;
import cbi.generator.ModelAndProperty;
import cbi.generator.meta.CBIModelMeta;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.relation.CBIRelationInfo;
import cbi.generator.relation.CBIRelationInfoNormal;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static cbi.generator.meta.CBIModelMeta.getInheritedFrom;

public abstract class CBIResourceInfoShared {
    public String baseName;
    public ArrayList<CBIColumnInfo> columns = new ArrayList<>();
    //ArrayList<CodegenModel> generated = new ArrayList<>();
    //ArrayList<CodegenModel> schema = new ArrayList<>();
    public CodegenModel model;
    public ArrayList<CBIRelationInfo> relations = new ArrayList<>();

    public static Boolean compareProperty(CodegenProperty property1, CodegenProperty property2) {
        boolean isEqual = property1.name.equals(property2.name) && property1.isArray == property2.isArray;
        if(isEqual){
            CBIColumnInfo column1 = CBIColumnInfo.fromProperty(property1);
            CBIColumnInfo column2 = CBIColumnInfo.fromProperty(property2);
        }
        return isEqual;
    }
    public static class TypeUnionResult {
        public CodegenModel model;
        public Boolean matchedAll;
        public Boolean matchedNone;
        public Boolean fromExisting;
    }
    static TypeUnionResult typeUnion(CodegenModel model1, CodegenModel model2) {
        TypeUnionResult result = new TypeUnionResult();
        result.model = new CodegenModel();
        result.model.allVars = new ArrayList<>();
        result.model.name = model1.name + "And" + model2.name;
        result.matchedNone = true;
        result.fromExisting = false;
        //result.matchExact = true;
        for(CodegenProperty property1 : model1.allVars) {
            for(CodegenProperty property2: model2.allVars) {
                if(compareProperty(property1, property2)){
                    result.model.allVars.add(property1.clone());
                    result.matchedNone = false;
                    break;
                }
            }
        }
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
        result.matchedAll = (model1.allVars.size() == model2.allVars.size()) && (model1.allVars.size() == result.model.allVars.size());
        return result;
    }
    static ArrayList<CodegenModel> combineModels(ArrayList<CodegenModel> models1, ArrayList<CodegenModel> models2, Boolean skipIfMatchAll) {
        ArrayList<CodegenModel> added = new ArrayList<>();
        for(CodegenModel model1 : models1) {
            for(CodegenModel model2 : models2) {
                if(model1 == model2)
                    break;
                TypeUnionResult result = typeUnion(model1, model2);
                if (!result.matchedNone) {
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
    public static class HighestRelations {
        public ArrayList<CBIRelationInfoNormal> A = new ArrayList<>();
        public ArrayList<CBIRelationInfoNormal> B = new ArrayList<>();
    }
    public HighestRelations getHighestRelations() {
        HighestRelations highest = new HighestRelations();
        for(CBIRelationInfo relation: relations) {
            if(relation instanceof CBIRelationInfoNormal) {
                CBIRelationInfo base = relation.getBaseRelation();
                CBIRelationInfoNormal highestCurrentA = null;
                CBIRelationInfoNormal highestCurrentB = null;

                for(CBIRelationInfoNormal h: highest.A) {
                    if(h.getBaseRelation() == base){
                        highestCurrentA = h;
                        break;
                    }
                }

                if (highestCurrentA != null) {
                    if (((CBIRelationInfoNormal) relation).isHigherA(highestCurrentA)){
                        highest.A.remove(highestCurrentA);
                        highest.A.add((CBIRelationInfoNormal) relation);
                    }
                } else {
                    highest.A.add((CBIRelationInfoNormal) relation);
                }

                for(CBIRelationInfoNormal h: highest.B) {
                    if(h.getBaseRelation() == base){
                        highestCurrentB = h;
                        break;
                    }
                }

                if (highestCurrentB != null) {
                    if (((CBIRelationInfoNormal) relation).isHigherB(highestCurrentB)){
                        highest.B.remove(highestCurrentB);
                        highest.B.add((CBIRelationInfoNormal) relation);
                    }
                } else {
                    highest.B.add((CBIRelationInfoNormal) relation);
                }

            }
        }
        return highest;
    }
    public CBIResourceInfo getBaseResource() {
        if(this instanceof CBIResourceInfo) {
            return (CBIResourceInfo) this;
        }
        if(this instanceof CBIResourceInfoChild){
            return ((CBIResourceInfoChild)this).base;
        }
        return null;
    }
    public String TestName(){
        return "YOLO DERP";
    }
    public CBIResourceInfoShared findParentResource() {
        CBIResourceInfo baseResource = getBaseResource();
        if(model.interfaceModels == null)
            return null;
        for(CBIResourceInfoShared subResource: baseResource.subResources) {
            if(model.interfaceModels.contains(subResource.model))
                return subResource;
        }
        if(model.interfaceModels.contains(baseResource.model))
            return baseResource;
        return null;
    }
    public ArrayList<CBIResourceInfoChild> findChildResources() {
        ArrayList<CBIResourceInfoChild> childResources = new ArrayList<>();
        for(CBIResourceInfoChild subResource: getBaseResource().subResources) {
            if(subResource.model.interfaceModels != null && subResource.model.interfaceModels.contains(model))
                childResources.add(subResource);
        }
        return childResources;
    }
    public boolean hasParent(CBIResourceInfoShared resource) {
        CBIResourceInfoShared parentResource = this.findParentResource();
        if(parentResource == null)
            return false;
        if(parentResource == resource){
            return true;
        }
        return parentResource.hasParent(resource);
    }
    public static CBIResourceInfoShared fromModel(CodegenModel model) {
        Object resourceInfo = model.vendorExtensions.get("x-cbi-resource-info");
        if(resourceInfo instanceof CBIResourceInfoShared)
            return (CBIResourceInfoShared) resourceInfo;
        return null;
    }
    public static void updateModelInterfaces(CodegenModel model) {
        model.interfaces = new ArrayList<>();
        if(model.interfaceModels != null) {
            for (CodegenModel parent : model.interfaceModels) {
                model.interfaces.add(parent.name);
            }
        }
    }
    public void updateModelRefs() {
        model.vendorExtensions.put("x-cbi-resource-info", this);
    }
    public static void updateColumns(CodegenModel model) {
        for (Iterator<CodegenProperty> it = model.allVars.iterator(); it.hasNext(); ) {
            CodegenProperty property = it.next();
            CBIRelationMeta relationMeta = CBIRelationMeta.fromModelAndProperty(new ModelAndProperty(model, property));
            if(relationMeta != null) {
                //property.vendorExtensions.put("x-relation-meta-cloned", relationMeta);
            }

            if(CBIModelMeta.hasVar(model, property.name) < 0)
                it.remove();
            //info.inheritedFrom = getInheritedFrom(property, model);
            //property.isInherited = info.inheritedFrom != null;
        }
    }
    public void updateColumns() {
        for (Iterator<CodegenProperty> it = model.allVars.iterator(); it.hasNext(); ) {
            CodegenProperty property = it.next();
            CBIRelationMeta relationMeta = CBIRelationMeta.fromModelAndProperty(new ModelAndProperty(model, property));
            if(relationMeta != null) {
                property.vendorExtensions.put("x-relation-meta-cloned", relationMeta);
            }
            CBIColumnInfo info = CBIColumnInfo.getOrAdd(columns, this, property);
            if(CBIModelMeta.hasVar(model, info.columnName) < 0)
                it.remove();
            info.inheritedFrom = getInheritedFrom(property, model);
            property.isInherited = info.inheritedFrom != null;
        }
    }
}
