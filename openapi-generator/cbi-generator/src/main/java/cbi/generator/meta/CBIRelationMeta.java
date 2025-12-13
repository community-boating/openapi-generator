package cbi.generator.meta;

import cbi.generator.ModelAndProperty;
import cbi.generator.Util;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.resource.CBIResourceInfoShared;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.Collections;
import java.util.Map;

import static cbi.generator.CBIColumnInfo.getPropertyType;

public class CBIRelationMeta extends MetaBase {
    public String relationName;
    public String modelA;
    public String modelB;
    public String throughResource;
    public String forwardRef;
    public String backwardRef;
    public CBIRelationType relationType;
    public Boolean isBackref;
    public Boolean isForwardOptional;
    public Boolean isBackOptional;
    public Boolean hasForward;
    public Boolean hasBackward;

    public CBIRelationMeta(Map<String, Object> map) {
        super(map);
        this.relationName = this.getString("relationName", null);
        this.modelA = this.getString("modelA", null);
        this.modelB = this.getString("modelA", null);
        this.throughResource = this.getString("throughResource", null);
        this.forwardRef = this.getString("forwardRef", null);
        this.backwardRef = this.getString("backRef", null);
        this.relationType = this.getEnum("relationType", null, CBIRelationType.class);
        this.isBackref = this.getBoolean("isBackref", null);
        this.isForwardOptional = this.getBoolean("isForwardOptional", null);
        this.isBackOptional = this.getBoolean("isBackOptional", null);
        this.hasForward = this.getBoolean("hasForward", true);
        this.hasBackward = this.getBoolean("hasBackward", true);
    }

    public CBIRelationMeta(CBIRelationMeta existing) {
        super(existing.map);
        this.relationName = existing.relationName;
        this.modelA = existing.modelA;
        this.modelB = existing.modelB;
        this.throughResource = existing.throughResource;
        this.forwardRef = existing.forwardRef;
        this.backwardRef = existing.backwardRef;
        this.relationType = existing.relationType;
        this.isBackref = existing.isBackref;
        this.isForwardOptional = existing.isForwardOptional;
        this.isBackOptional = existing.isBackOptional;
        this.hasForward = existing.hasForward;
        this.hasBackward = existing.hasBackward;
    }

    public CBIRelationMeta() {
        super(Collections.emptyMap());
    }

    public static CBIRelationMeta fromResources(CBIRelationMeta existingMeta, CBIResourceInfoShared resourceA, CBIResourceInfoShared resourceB, boolean swapBack, boolean useResourceName) {
        CBIRelationMeta metaCloned = new CBIRelationMeta(existingMeta);
        metaCloned.modelA = resourceA.name;
        metaCloned.modelB = resourceB.name;
        //metaCloned.makeMetaNameFromModels(swapBack);
        //if(!useResourceName) {
        //if(metaCloned.forwardRef == null)
        //metaCloned.makeForwardRef(resourceB.getBaseResource().name);
        //if(metaCloned.backwardRef == null)
        //metaCloned.makeBackwardRef(resourceA.getBaseResource().name);
        //}
        return metaCloned;
    }

    public String makeMetaNameFromModels(boolean swapBack) {
        if(swapBack && this.isBackref != null && this.isBackref) {
            return this.modelB + "_TO_" + this.modelA;
        }else{
            return this.modelA + "_TO_" + this.modelB;
        }
    }

    public static String toCamelCase(String string) {
        if(string != null && string.length() > 1)
            return string.substring(0, 1).toLowerCase() + string.substring(1);
        return string;
    }

    public static String toPascalCase(String string) {
        if(string != null && string.length() > 1)
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        return string;
    }

    public String makeForwardRef(String modelB) {
        if(this.modelA.equals(this.modelB))
            return this.relationName + "ForwardRef";
        else
            return toCamelCase(modelB != null ? modelB : this.modelB);
    }

    public String makeBackwardRef(String modelA) {
        if(this.modelA.equals(this.modelB))
            return this.relationName + "BackwardRef";
        else
            return toCamelCase(modelA != null ? modelA : this.modelA) + (this.relationType == CBIRelationType.ONE_TO_MANY ? "s" : "");
    }

    public static CBIRelationMeta fromModelAndProperty(ModelAndProperty modelAndProperty) {
        CodegenProperty property = modelAndProperty.property;
        CodegenModel model = modelAndProperty.model;
        Object relationMeta = property.vendorExtensions.get("x-relation-meta");
        CBIRelationMeta meta;
        if(relationMeta instanceof CBIRelationMeta){
            meta = (CBIRelationMeta) relationMeta;
        }else if(relationMeta instanceof Map) {
            meta = new CBIRelationMeta((Map<String, Object>)relationMeta);
        }else if(Util.isPropertyModel(property)) {
            meta = new CBIRelationMeta();
            meta.isBackref = false;
        }else {
            return null;
        }
        if(meta.relationType == null){
            if(property.isArray && property.items.isModel){
                meta.relationType = CBIRelationType.ONE_TO_MANY;
                meta.isBackref = true;
            }else if(property.isModel){
                meta.relationType = CBIRelationType.ONE_TO_ONE;
            }
        }

        if(meta.modelB == null)
            meta.modelB = getPropertyType(property);

        if(meta.modelA == null)
            meta.modelA = model.name;

        //if(meta.relationName == null) {
        //    meta.makeMetaNameFromModels(true);
        //}

        if(meta.forwardRef == null && meta.isBackref != null && !meta.isBackref){
            meta.forwardRef = property.name;
        }

        if(meta.backwardRef == null && meta.isBackref != null && meta.isBackref){
            meta.backwardRef = property.name;
        }

        //if(meta.forwardRef == null)
        //    meta.makeForwardRef(null);
        //if(meta.backwardRef == null)
        //    meta.makeBackwardRef(null);

        property.vendorExtensions.put("x-relation-meta", relationMeta);

        return meta;
    }
    @Override
    public String toString(){
        return "RelationType: " + relationType + ", isBackref: " + isBackref;
    }
}