package cbi.generator;

import cbi.generator.meta.CBIColumnMeta;
import cbi.generator.relation.CBIRelationInfo;
import cbi.generator.resource.CBIResourceInfo;
import cbi.generator.resource.CBIResourceInfoShared;
import cbi.generator.resource.CBIResourceInfoChild;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class CBIColumnInfo extends ModelAndProperty {

    public String columnType = null;
    public String columnName = null;
    public Boolean isArray = false;
    public ModelAndProperty inheritedFrom = null;
    public CBIRelationInfo relation;
    public CBIColumnMeta meta = null;
    public CBIResourceInfoShared resource = null;

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
        CodegenProperty property = null;
        for(CodegenProperty propertyExisting: this.model.allVars) {
            if(propertyExisting.name.equals(this.columnName)) {
                property = propertyExisting;
                break;
            }
        }
        if(property == null) {
            property = new CodegenProperty();
            model.allVars.add(property);
        }
        property.name = this.columnName;
        property.baseName = this.columnName;
        property.isArray = this.isArray;
        property.vendorExtensions = new HashMap<>();
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
        if(property.name.equals("TestThroughTableChild_TO_TestInheritanceChildBackwardRef")){
            System.out.println("WHAT");
        }
        if(property.name.equals("TestThroughTableChild_TO_TestInheritanceChildBackwardRef")){
            System.out.println("WHAT");
        }
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

