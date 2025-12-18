package cbi.generator.resource;

import cbi.generator.CBIColumnInfo;
import cbi.generator.ModelAndProperty;
import cbi.generator.Util;
import cbi.generator.meta.CBIModelMeta;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.relation.CBIRelationInfo;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.Iterator;

import static cbi.generator.meta.CBIModelMeta.getInheritedFrom;

public abstract class CBIResourceInfoShared {
    public String name;
    public ArrayList<CBIColumnInfo> columns = new ArrayList<>();
    //ArrayList<CodegenModel> generated = new ArrayList<>();
    //ArrayList<CodegenModel> schema = new ArrayList<>();
    public CodegenModel model;
    public ArrayList<String> modelGroups;
    public ArrayList<CBIRelationInfo> relations = new ArrayList<>();

    public String getNameTable() {
        return this.getBaseName() + "Table";
    }

    public CBIColumnInfo getPrimary() {
        for(CBIColumnInfo column: columns) {
            if(column.meta.isPrimary){
                return column;
            }
        }
        return null;
    }

    public CBIModelMeta getModelMeta() {
        return CBIModelMeta.getOrAdd(this.model);
    }

    public String getNameSQL() {
        CBIModelMeta meta = getModelMeta();
        if(meta.nameSQL != null)
            return meta.nameSQL;
        return toSnakeCase(this.model.schemaName);
    }

    public static String toSnakeCase(String input) {
        return input
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .replaceAll("([A-Z])([A-Z][a-z])", "$1_$2")
                .toLowerCase();
    }

    public String getTableObjectParent() {
        String primaryType = getPrimary().property.complexType;
        if(primaryType == null)
            primaryType = getPrimary().property.dataType;
        return "IdTable<" + primaryType + ">(\"" + this.getNameSQL() + "\")";
    }

    public String getDAOCompanion() {
        CBIColumnInfo primary = getPrimary();
        String companionObject = "";
        if(primary.property.isInteger){
            companionObject = "IntEntityClass";
        }
        if(primary.property.isLong){
            companionObject = "LongEntityClass";
        }
        return "companion object: " + companionObject + "<" + this.getNameDAO() + ">(" + this.getNameTable() + ")";
    }

    public String getDAOClass() {
        CBIColumnInfo primary = getPrimary();
        String primaryType = primary.property.complexType;
        if(primaryType == null)
            primaryType = primary.property.dataType;
        String entityClass = "";
        if(primary.property.isInteger){
            entityClass = "IntEntity";
        }
        if(primary.property.isLong){
            entityClass = "LongEntity";
        }
        String extraClass = "";
        if(this.hasInterface())
            extraClass = ", " + this.getNameInterface();
        return this.getNameDAO() + "(id: EntityID<" + primaryType + ">) : " + entityClass + "(id)" + extraClass;
    }

    public String getNameDTO() {
        if("DTO".equals(this.getResourceSuffix())){
            return this.name;
        }
        return this.getBaseName() + "DTO";
    }

    public String getNameDAO() {
        if("DAO".equals(this.getResourceSuffix()))
            return this.name;
        return this.getBaseName() + "DAO";
    }

    public String getNameInterface() {
        if(!this.isDAO() && !this.hasDTO()){
            return this.name;
        }
        return this.getBaseName() + "Interface";
    }

    public static Boolean compareProperty(CodegenProperty property1, CodegenProperty property2) {
        boolean isEqual = property1.name.equals(property2.name) && property1.isArray == property2.isArray;
        if(isEqual){
            CBIColumnInfo column1 = CBIColumnInfo.fromProperty(property1);
            CBIColumnInfo column2 = CBIColumnInfo.fromProperty(property2);
        }
        return isEqual;
    }
    public static class TypeUnionResultModelVar {
        public CodegenProperty propertyParent;
        public CodegenProperty propertyChild;
        public TypeUnionResultModelVar(CodegenProperty propertyParent, CodegenProperty propertyChild) {
            this.propertyParent = propertyParent;
            this.propertyChild = propertyChild;
        }
    }
    public static class TypeUnionResult {
        public CodegenModel modelBase;
        public CodegenModel modelParent;
        public CodegenModel modelBoth;
        public ArrayList<TypeUnionResultModelVar> modelVars;
        public Boolean matchedAll;
        public Boolean matchedNone;
        public boolean shouldAdd = false;
        //public Boolean fromExisting;
    }
    public static TypeUnionResult typeUnion(CodegenModel modelBase, CodegenModel modelParent) {
        TypeUnionResult result = new TypeUnionResult();
        result.modelBase = modelBase;
        result.modelParent = modelParent;
        result.modelBoth = new CodegenModel();
        result.modelVars = new ArrayList<>();
        result.modelBoth.allVars = new ArrayList<>();
        result.modelBoth.name = modelBase.name + "And" + modelParent.name;
        result.modelBoth.classname = result.modelBoth.name;
        result.modelBoth.classFilename = result.modelBoth.classname;
        result.matchedNone = true;
        result.matchedAll = true;
        for(CodegenProperty propertyParent : modelParent.allVars) {
            boolean isModel1 = Util.isPropertyModel(propertyParent);
            boolean hasProperty = false;
            for(CodegenProperty propertyChild: modelBase.allVars) {
                boolean isModel2 = Util.isPropertyModel(propertyChild);
                boolean isModel = isModel1 || isModel2;
                if (compareProperty(propertyParent, propertyChild)) {
                    if(isModel1 && isModel2) {
                        result.modelVars.add(new TypeUnionResultModelVar(propertyParent, propertyChild));
                        hasProperty = true;
                    }else if(!isModel) {
                        result.modelBoth.allVars.add(propertyParent.clone());
                        hasProperty = true;
                    }
                    break;
                }
            }
            if(hasProperty){
                result.matchedNone = false;
            }else{
                result.matchedAll = false;
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
                    added.add(result.modelBoth);
                }
                if(result.modelBoth != null && !result.matchedNone){
                    if(model1.interfaceModels == null)
                        model1.interfaceModels = new ArrayList<>();
                    if(model2.interfaceModels == null)
                        model2.interfaceModels = new ArrayList<>();
                    model1.interfaceModels.add(result.modelBoth);
                    model2.interfaceModels.add(result.modelBoth);
                }
            }
        }
        return added;
    }
    public boolean isBase() {
        return getBaseResource().equals(this);
    }
    public boolean isDAO() {
        return this.getModelMeta().hasDAO;
    }
    public boolean hasDTO() {
        return this.getModelMeta().hasDTO;
    }
    public boolean hasInterface() {
        return this.getModelMeta().hasInterface;
    }
    public CBIResourceInfoShared getDAOResource() {
        if(this.isDAO())
            return this;
        for(CBIResourceInfoChild sub: this.getBaseResource().subResources){
            if(sub.isDAO())
                return sub;
        }
        return null;
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
    public String getBaseName() {
        String suffix = getResourceSuffix();
        if(suffix != null){
            int index = this.name.lastIndexOf(suffix);
            if(index > 0)
                return this.name.substring(0, index);
            return this.name;
        }
        return this.name;
    }
    public String getResourceSuffix() {
        String nameSuffix = getModelMeta().nameSuffix;
        if(nameSuffix != null)
            return nameSuffix;
        if(this.getBaseResource().equals(this))
            return null;
        int startIndex = 0;
        String nameBase = this.getBaseResource().name;

        while(startIndex < this.name.length() && startIndex < nameBase.length() && this.name.charAt(startIndex) == nameBase.charAt(startIndex)){
            startIndex++;
        }
        if(startIndex > 0)
            return this.name.substring(startIndex);
        return null;
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
                CBIResourceInfoShared info = CBIResourceInfoShared.fromModel(parent);
                if(info != null && info.hasInterface())
                    model.interfaces.add(info.getNameInterface());
                else
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
            updateColumnShared(model, property);
            if(CBIModelMeta.hasVar(model, property.name) < 0)
                it.remove();
            property.isInherited = getInheritedFrom(property, model) != null;
            //property.isInherited = info.inheritedFrom != null;
        }
    }
    public static void updateColumnShared(CodegenModel model, CodegenProperty property) {
        CBIRelationMeta relationMeta = CBIRelationMeta.fromModelAndProperty(new ModelAndProperty(model, property));
        CBIModelMeta modelMeta = CBIModelMeta.getOrAdd(model);
        if(property.name.equalsIgnoreCase("id") && !property.dataType.startsWith("EntityID<") && modelMeta.isResource){
            property.complexType = property.dataType;
            property.dataType = "EntityID<" + property.dataType + ">";
        }
        if(property.defaultValue != null) {
            if(property.defaultValue.equals("null") && !property.isOptional)
                property.defaultValue = null;
            if(property.isString && property.defaultValue != null) {
                if(!property.defaultValue.startsWith("\""))
                    property.defaultValue = "\"" + property.defaultValue + "\"";
            }
        }

        if(relationMeta != null) {
            property.vendorExtensions.put("x-relation-meta-cloned", relationMeta);
        }
    }
    public void updateColumns() {
        for (Iterator<CodegenProperty> it = model.allVars.iterator(); it.hasNext(); ) {
            CodegenProperty property = it.next();
            updateColumnShared(model, property);
            CBIColumnInfo info = CBIColumnInfo.getOrAdd(columns, this, property);
            if(CBIModelMeta.hasVar(model, info.columnName) < 0)
                it.remove();
            info.inheritedFrom = getInheritedFrom(property, model);
            property.isInherited = info.inheritedFrom != null;
        }
    }
}
