package cbi.generator;

import cbi.generator.enums.CBIRelationType;
import cbi.generator.meta.CBIColumnMeta;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.relation.CBIRelationInfo;
import cbi.generator.relation.CBIRelationInfoNormal;
import cbi.generator.relation.CBIRelationInfoOneToOne;
import cbi.generator.relation.CBIRelationInfoOneToOneTyped;
import cbi.generator.resource.CBIResourceInfo;
import cbi.generator.resource.CBIResourceInfoShared;
import cbi.generator.resource.CBIResourceInfoChild;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class CBIColumnInfo extends ModelAndProperty {

    public String columnType = null;
    public String columnName = null;
    public Boolean isArray = false;
    public Boolean isRequired = true;
    public ModelAndProperty inheritedFrom = null;
    public CBIRelationInfo relation;
    public CBIColumnMeta meta = null;
    public CBIResourceInfoShared resource = null;

    public boolean isBackref() {
        if(this.relation != null)
            return this.relation.backRef.equals(this);
        return false;
    }

    public CBIColumnInfo getParentColumn() {
        if(resource instanceof CBIResourceInfoChild) {
            CBIResourceInfo parent = ((CBIResourceInfoChild) resource).base;
            for(CBIColumnInfo column: parent.columns) {
                if(column.compare(this)){
                    return column;
                }
            }
        }
        return null;
    }
    public ArrayList<CBIColumnInfo> getChildColumns() {
        ArrayList<CBIColumnInfo> childColumns = new ArrayList<>();
        if(resource instanceof CBIResourceInfo) {
            for(CBIResourceInfoChild child: ((CBIResourceInfo)resource).subResources) {
                for (CBIColumnInfo column : child.columns) {
                    if (column.compare(this)) {
                        childColumns.add(column);
                    }
                }
            }
        }
        return childColumns;
    }

    public CBIRelationInfoNormal getRelationNormal() {
        if(this.relation instanceof CBIRelationInfoNormal) {
            return (CBIRelationInfoNormal) this.relation;
        }
        return null;
    }

    public CBIRelationInfoOneToOneTyped getRelationOneToOneTyped() {
        if(this.relation instanceof CBIRelationInfoOneToOneTyped) {
            return (CBIRelationInfoOneToOneTyped) this.relation;
        }
        return null;
    }

    public String getExposedSQLName() {
        if(this.meta != null && this.meta.columnNameDB != null)
            return this.meta.columnNameDB;
        if(this.property != null)
            return this.property.nameInSnakeCase;
        return null;
    }

    public boolean hasTableDefine() {
        if(this.getRelationNormal() != null){
            return !this.isBackref();
        }
        if(this.relation != null && this.relation.type == CBIRelationType.ONE_TO_ONE_TYPED)
            return false;
        return this.property != null;
    }

    public boolean isVal() {
        if(this.relation instanceof CBIRelationInfoOneToOneTyped)
            return true;
        if(this.getRelationNormal() == null)
            return false;
        if(this.isBackref()){
            return true;
        }else{
            return this.isArray;
        }
    }

    public boolean hasDAODefine() {
        if(this.resource == null)
            return true;
        if(this.meta != null && this.meta.isPrimary){
            return !this.property.name.equalsIgnoreCase("id");
        }
        return true;
    }

    public String getExposedDAODefine() {
        if(!hasDAODefine())
            return "";
        String by = this.resource.getNameTable();
        String suffix = "." + this.columnName;
        String tableCol = by + suffix;
        if(this.relation instanceof CBIRelationInfoOneToOneTyped){
            StringBuilder sb = new StringBuilder();
            sb.append(":");
            sb.append(this.columnType);
            sb.append("Interface get() = when(this.");
            sb.append(((CBIRelationInfoOneToOneTyped) this.relation).typeColumn.columnName);
            sb.append(") {\n");
            ((CBIRelationInfoOneToOneTyped) this.relation).discriminator.getMappedModels().forEach(mappedModel -> {
                sb.append(((CBIRelationInfoOneToOneTyped) this.relation).typeColumn.columnType);
                sb.append(".");
                sb.append(mappedModel.getMappingName());
                sb.append(" -> this.");
                CodegenModel model = mappedModel.getModel();
                Optional<CBIRelationInfoOneToOne> matchingOptional = ((CBIRelationInfoOneToOneTyped) this.relation).typeRelations.stream().filter(typeRelation -> typeRelation.resourceA.model.equals(model) || typeRelation.resourceB.model.equals(model)).findAny();
                if(matchingOptional.isEmpty())
                    throw new RuntimeException("Failed to find relation for type: " + model.name + ", " + this.model.name);
                CBIRelationInfoOneToOne matching = matchingOptional.get();
                sb.append(matching.backRef.columnName);
                sb.append("\n");
            });
            sb.append("}");
            return sb.toString();
        }
        if(this.getRelationNormal() != null) {
            boolean isOptional = this.property != null && this.property.isOptional;
            if(this.isBackref()) {
                //isOptional = this.getRelationNormal().backRef.property != null && this.getRelationNormal().backRef.property.isOptional;
                by = this.getRelationNormal().resourceA.getNameDAO();
                if (this.isArray) {
                    if (isOptional) {
                        suffix = " optionalReferrersOn ";
                    } else {
                        suffix = " referrersOn ";
                    }
                }else{
                    if (isOptional) {
                        suffix = " optionalBackReferencedOn ";
                    } else {
                        suffix = " backReferencedOn ";
                    }
                }
                suffix += this.getRelationNormal().resourceA.getNameTable() + "." + this.getRelationNormal().forwardRef.columnName;
            }
            else{
                by = this.getRelationNormal().resourceB.getNameDAO();
                if(this.isArray) {
                    /*if (isOptional) {
                        suffix = " optionalReferrersOn";
                    }else{
                        suffix = " referrersOn";
                    }*/
                }else{
                    if (isOptional) {
                        suffix = " optionalReferencedOn " + tableCol;
                    }else{
                        suffix = " referencedOn " + tableCol;
                    }
                }
            }
        }
        return "by " + by + suffix;
    }

    public boolean isID() {
        return this.meta != null && this.meta.isPrimary && this.resource != null;
    }

    public boolean isEntityID() {
        return this.isID() && this.columnName.equalsIgnoreCase("id");
    }

    public String getExposedTableDefine() {
        if(!hasTableDefine())
            return "";
        String functionName;
        String nameSuffix = "";
        String columnName = this.columnName;
        if(this.getRelationNormal() != null) {
            functionName = "reference";
            nameSuffix = ", " + this.getRelationNormal().resourceB.getNameTable();
        } else if(this.property.isModel) {
            functionName = "model";
        } else if(this.property.isString) {
            if (this.property.maxLength != null) {
                functionName = "varchar";
                nameSuffix = ", " + this.property.maxLength;
            }else{
                functionName = "text";
            }
        }else if(this.property.isEnum || this.property.isEnumRef) {
            functionName = "enumerationByName<" + this.property.dataType + ">";
            nameSuffix = ", 30";
        }else if(this.property.isBoolean) {
            functionName = "bool";
        }else if(this.property.isDate) {
            functionName = "date";
        }else if(this.property.isDateTime) {
            functionName = "datetime";
        }else if(this.property.isLong) {
            functionName = "long";
        }else if(this.property.isInteger) {
            functionName = "integer";
        }else if(this.property.isDouble) {
            functionName = "double";
        }else if(this.property.isFloat) {
            functionName = "float";
        }else if(this.property.isNumeric) {
            functionName = "numeric";
        }else{
            throw new RuntimeException("Unknown type: " + this.property.dataType + ", property: " + this.property.name + ", model: " + this.model.name);
        }
        String extraPre = "";
        String extraPost = "";
        if(this.isID()){
            if(columnName.equalsIgnoreCase("id")) {
                columnName = "assignId";
                extraPost = "\noverride val id = assignId.entityId()";
            }else{
                extraPost = "\noverride val id = " + this.columnName + ".entityId()";
            }
        }
        if(this.property != null) {
            if (this.property.isOptional || this.property.isNullable)
                extraPost += ".nullable()";
            if (this.property.defaultValue != null) {
                extraPost += ".default(" + this.property.defaultValue + ")";
            }
        }
        return extraPre +
                "val " +
                columnName +
                " = " +
                functionName +
                "(\"" +
                this.getExposedSQLName() +
                "\"" +
                nameSuffix +
                ")" +
                extraPost;

    }

    public boolean compare(CBIColumnInfo other) {
        return this.isArray == other.isArray && this.columnName.equals(other.columnName);
    }

    public CBIColumnInfo(CBIResourceInfoShared resource, CodegenProperty property) {
        super(resource.model, property);
        resource.columns.add(this);
        this.resource = resource;
    }

    public static CBIColumnInfo fromProperty(CodegenProperty property) {
        Object columnInfo = property.vendorExtensions.get("x-cbi-column-info");
        if(columnInfo instanceof CBIColumnInfo)
            return (CBIColumnInfo) columnInfo;
        return null;
    }

    public static String getPropertyType(CodegenProperty property) {
        if(property.isArray){
            return property.items.dataType;
        }else{
            return property.dataType;
        }
    }
    public static CBIColumnInfo getOrAdd(ArrayList<CBIColumnInfo> columns, CBIResourceInfoShared resource, CodegenProperty property) {
        CBIColumnInfo column = null;
        CodegenModel model = resource.model;
        String columnType = getPropertyType(property);

        for(CBIColumnInfo columnI : columns) {
            if(columnI.columnName.equals(property.name) && columnI.columnType.equals(columnType) && (columnI.isArray == property.isArray) && columnI.resource == resource){
                column = columnI;
                break;
            }
        }

        if(column == null){
            CBIColumnMeta meta = CBIColumnMeta.getOrAdd(property);
            column = new CBIColumnInfo(resource, property);
            column.columnName = property.name;
            column.columnType = columnType;
            column.isArray = property.isArray;
            column.meta = meta;
        }

        property.vendorExtensions.put("x-cbi-column-info", column);

        return column;
    }
    public void removeFromModel() {
        for(CodegenProperty propertyExisting: this.model.allVars) {
            if(propertyExisting.name.equals(this.columnName)) {
                model.allVars.remove(propertyExisting);
                break;
            }
        }
    }
    public void addToModel() {
        //CodegenProperty property = null;
        if(property == null) {
            for (CodegenProperty propertyExisting : this.model.allVars) {
                if (propertyExisting.name.equals(this.columnName)) {
                    property = propertyExisting;
                    break;
                }
            }
        }
        if(property == null) {
            property = new CodegenProperty();
            model.allVars.add(property);
            property.name = this.columnName;
            property.nameInSnakeCase = CBIResourceInfoShared.toSnakeCase(this.columnName);
            property.nameInPascalCase = CBIRelationMeta.toPascalCase(this.columnName);
            property.baseName = this.columnName;
            property.isArray = this.isArray;
            property.vendorExtensions = new HashMap<>();
        }
        property.required = this.isRequired;
        property.isNullable = !property.required;
        property.isOptional = property.isNullable;
        property.vendorExtensions.put("x-column-meta", this.meta);
        property.vendorExtensions.put("x-cbi-column-info", this);
        if(this.isArray){
            CodegenProperty items = new CodegenProperty();
            items.isModel = true;
            items.dataType = this.columnType;
            property.dataType = "List";
            property.items = items;
        }else{
            property.isModel = true;
            property.dataType = this.columnType;
        }
        property.datatypeWithEnum = "";
    }
    @Override
    public int hashCode(){
        return columnName.hashCode();
    }
    @Override
    public boolean equals(final Object other){
        if(other == null)
            return false;
        if(other instanceof CBIColumnInfo){
            CBIColumnInfo otherCast = (CBIColumnInfo) other;
            return this.columnName.equals(otherCast.columnName);
        }
        return false;
    }
}

