package cbi.generator;

import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.Map;

public class CBIColumnInfo {
    Boolean isPrimary = false;
    String columnNameDB;
    String columnName;
    String columnType;
    ArrayList<ModelAndProperty> modelProperties = new ArrayList<>();
    static CBIColumnInfo getOrAdd(ArrayList<CBIColumnInfo> columns, CodegenModel model, CodegenProperty property) {
        CBIColumnInfo column = null;
        for(CBIColumnInfo columnI : columns) {
            if(columnI.columnName.equals(property.name) && columnI.columnType.equals(property.dataType)){
                column = columnI;
                break;
            }
        }
        if(column == null){
            column = new CBIColumnInfo();
            column.columnName = property.name;
            column.columnNameDB = property.nameInSnakeCase;
            column.columnType = property.dataType;
            columns.add(column);
        }
        property.vendorExtensions.put("x-cbi-column-info", column);
        column.modelProperties.add(new ModelAndProperty(model, property));
        return column;
    }
    @Override
    public int hashCode(){
        return columnName.hashCode() + columnType.hashCode() * 31;
    }
    @Override
    public boolean equals(final Object other){
        if(other == null)
            return false;
        if(other instanceof CBIColumnInfo){
            CBIColumnInfo otherCast = (CBIColumnInfo) other;
            return this.columnName.equals(otherCast.columnName) && this.columnType.equals(otherCast.columnType);
        }
        return false;
    }
    @Override
    public String toString() {
        return "Column Name: " + this.columnName + ", Column Type: " + this.columnType;
    }
    static class ModelAndProperty {
        CodegenModel model;
        CodegenProperty property;
        ModelAndProperty(CodegenModel model, CodegenProperty property) {
            this.model = model;
            this.property = property;
        }
    }
    static class CBIRelationDefinition {
        String relationName;
        String modelA;
        String modelB;
        String forwardRef;
        String backwardRef;
        CBIRelationType relationType;
        Boolean isBackref;
        static CBIRelationDefinition fromModelAndProperty(ModelAndProperty modelAndProperty) {
            CodegenProperty property = modelAndProperty.property;
            CodegenModel model = modelAndProperty.model;
            Object relationDefinition = property.vendorExtensions.get("x-relation-definition");
            CBIRelationDefinition definition;
            if(relationDefinition instanceof Map) {
                definition = fromMap((Map<?, ?>)relationDefinition);
            }else if(property.isModel || (property.isArray && property.items.isModel)) {
                definition = new CBIRelationDefinition();
                definition.isBackref = false;
            }else {
                return null;
            }

            if(property.isArray && property.items.isModel){
                definition.relationType = CBIRelationType.ONE_TO_MANY;
                definition.isBackref = true;
                if(definition.modelB == null)
                    definition.modelB = property.items.dataType;
            }else if(property.isModel){
                definition.relationType = CBIRelationType.ONE_TO_ONE;
                if(definition.modelB == null)
                    definition.modelB = property.dataType;
            }

            if(definition.modelA == null)
                definition.modelA = model.name;

            if(definition.relationName == null) {
                if(definition.isBackref != null && definition.isBackref) {
                    definition.relationName = definition.modelB + "_TO_" + definition.modelA;
                }else{
                    definition.relationName = definition.modelA + "_TO_" + definition.modelB;
                }
            }

            if(definition.forwardRef == null && definition.isBackref != null && !definition.isBackref){
                definition.forwardRef = property.name;
            }

            if(definition.backwardRef == null && definition.isBackref != null && definition.isBackref){
                definition.backwardRef = property.name;
            }

            return definition;
        }
        static CBIRelationDefinition fromMap(Map<?, ?> map) {

            CBIRelationDefinition definition = new CBIRelationDefinition();
            Object relationTypeObj = map.get("relationType");
            if(relationTypeObj != null) {
                definition.relationType = CBIRelationType.valueOf(relationTypeObj.toString().toUpperCase());
            }

            Object isBackrefObj = map.get("isBackref");
            if(isBackrefObj != null)
                definition.isBackref = isBackrefObj.equals(true);

            Object relationNameObj = map.get("relationName");
            if(relationNameObj != null)
                definition.relationName = relationNameObj.toString();

            Object modelAObj = map.get("modelA");
            if(modelAObj != null)
                definition.modelA = modelAObj.toString();

            Object modelBObj = map.get("modelB");
            if(modelBObj != null)
                definition.modelB = modelBObj.toString();

            Object forwardRefObj = map.get("forwardRef");
            if(forwardRefObj != null)
                definition.forwardRef = forwardRefObj.toString();

            Object backwardRefObj = map.get("backwardRef");
            if(backwardRefObj != null)
                definition.backwardRef = backwardRefObj.toString();

            return definition;
        }
        @Override
        public String toString(){
            return "RelationType: " + relationType + ", isBackref: " + isBackref;
        }
    }

}
