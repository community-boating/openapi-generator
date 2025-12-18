package cbi.generator.meta;

import cbi.generator.ModelAndProperty;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static cbi.generator.resource.CBIResourceInfo.compareProperty;

public class CBIModelMeta extends MetaBase {
    public Boolean hasDTO;
    public Boolean hasDAO;
    public Boolean hasMutable;
    public boolean hasTable;
    public boolean hasInterface;
    public Boolean isResource;
    public boolean isBase;
    public String nameSQL;
    public String nameSuffix;
    public ArrayList<String> groups;
    public Boolean hasWriteOnly;
    public Boolean hasReadOnly;
    public ArrayList<String> varsIncluded;
    public ArrayList<String> varsExcluded;
    public ArrayList<String> relationsIncluded;
    public ArrayList<String> relationsExcluded;
    public CBIModelMeta(Map<String, Object> map) {
        super(map);
        this.hasDTO = this.getBoolean("x-has-dto", null);
        this.hasDAO = this.getBoolean("x-has-dao", null);
        this.hasMutable = this.getBoolean("x-has-mutable", null);
        this.hasTable = this.getBoolean("x-has-table", true);
        this.hasInterface = this.getBoolean("x-has-interface", true);
        this.isResource = this.getBoolean("x-is-resource", null);
        //this.isBase = this.getBoolean("x-is-base", null);
        this.groups = this.getStringArray("x-groups");
        this.nameSuffix = this.getString("x-name-suffix", null);
        this.nameSQL = this.getString("x-name-sql", null);
        this.hasWriteOnly = this.getBoolean("x-has-write-only", null);
        this.hasReadOnly = this.getBoolean("x-has-read-only", null);
        this.varsIncluded = this.getStringArray("x-vars-included");
        this.varsExcluded = this.getStringArray("x-vars-excluded");
        this.relationsIncluded = this.getStringArray("x-relations-included");
        this.relationsExcluded = this.getStringArray("x-relations-excluded");
    }

    public static int hasRelation(CodegenModel model, String relationName) {
        CBIModelMeta meta = CBIModelMeta.getOrAdd(model);
        int has = meta.hasRelation(relationName);
        if(has != 0)
            return has;
        if(model.interfaceModels == null)
            return 0;
        for(CodegenModel parent: model.interfaceModels) {
            has = hasRelation(parent, relationName);
            if(has != 0)
                return has;
        }
        return 0;
    }

    int hasRelation(String relationName) {
        if(relationsIncluded.contains(relationName))
            return 1;
        if(relationsExcluded.contains(relationName))
            return -1;
        return 0;
    }

    public static int hasVar(CodegenModel model, String varName) {
        CBIModelMeta meta = CBIModelMeta.getOrAdd(model);


        int has = meta.hasVar(varName);
        if(has != 0)
            return has;
        if(model.interfaceModels == null)
            return 0;
        for(CodegenModel parent: model.interfaceModels) {
            has = hasVar(parent, varName);
            if(has != 0)
                return has;
        }
        if(Boolean.FALSE.equals(meta.hasReadOnly) || Boolean.FALSE.equals(meta.hasWriteOnly)) {
            CodegenProperty property = model.allVars.stream().filter(a -> a.name.equals(varName)).findFirst().orElse(null);
            if(property != null) {
                if (Boolean.FALSE.equals(meta.hasReadOnly) && property.isReadOnly){
                    return -1;
                }
                if (Boolean.FALSE.equals(meta.hasWriteOnly) && property.isWriteOnly){
                    return -1;
                }
            }
        }
        return 0;
    }

    int hasVar(String varName) {
        if(varsIncluded.contains(varName))
            return 1;
        if(varsExcluded.contains(varName))
            return -1;
        return 0;
    }

    public static boolean hasParentDiscriminator(CodegenModel model) {
        if(model.interfaceModels != null) {
            for (CodegenModel parent : model.interfaceModels) {
                if (parent.discriminator != null)
                    return true;
            }
        }
        return false;
    }

    public static CBIModelMeta getOrAdd(CodegenModel model) {
        CBIModelMeta meta = null;
        if(model.vendorExtensions != null) {
            Object existing = model.vendorExtensions.get("x-model-meta");
            if(existing instanceof CBIModelMeta){
                meta = (CBIModelMeta) existing;
            }
            else if(existing instanceof Map<?, ?>){
                meta = new CBIModelMeta((Map<String, Object>)existing);
            }else {
                meta = new CBIModelMeta(model.vendorExtensions);
            }
        }
        if(meta == null)
            meta = new CBIModelMeta(Collections.emptyMap());
        CodegenProperty primary = getPrimary(model);
        if(meta.isResource == null) {
            meta.isResource = primary != null;
        }
        if(primary == null) {
            meta.isBase = false;
        }else {
            primary.isInherited = getInheritedFrom(primary, model) != null;
            meta.isBase = !primary.isInherited || hasParentDiscriminator(model);
        }
        if(meta.hasDAO == null){
            meta.hasDAO = model.classname.endsWith("DAO");
        }
        if(meta.hasDTO == null){
            meta.hasDTO = model.classname.endsWith("DTO");
        }
        if(meta.hasMutable == null){
            meta.hasMutable = meta.hasDAO;
        }
        model.vendorExtensions.put("x-model-meta", meta);
        return meta;
    }

    public static ModelAndProperty getSharedInheritedFrom(CodegenProperty property, CodegenModel model1, CodegenModel model2) {
        if(model1.interfaceModels == null || model2.interfaceModels == null)
            return null;
        for(CodegenModel parentModel: model1.interfaceModels) {
            ModelAndProperty inheritedFrom = getInheritedFromRecurse(property, parentModel);
            if(inheritedFrom != null)
                return inheritedFrom;
        }
        return null;
    }

    public static ModelAndProperty getInheritedFrom(CodegenProperty property, CodegenModel model) {
        if(model.interfaceModels == null)
            return null;
        for(CodegenModel parentModel: model.interfaceModels) {
            ModelAndProperty inheritedFrom = getInheritedFromRecurse(property, parentModel);
            if(inheritedFrom != null)
                return inheritedFrom;
        }
        return null;
    }

    static ModelAndProperty getInheritedFromI(CodegenProperty property, CodegenModel parentModel) {
        if(parentModel.allVars == null)
            return null;
        for(CodegenProperty parentProperty : parentModel.allVars) {
            if(compareProperty(property, parentProperty)){
                return new ModelAndProperty(parentModel, parentProperty);
            }
        }
        return null;
    }

    public static ModelAndProperty getInheritedFromRecurse(CodegenProperty property, CodegenModel model) {
        ModelAndProperty inheritedFrom = getInheritedFromI(property, model);
        if(inheritedFrom != null)
            return inheritedFrom;
        if(model.interfaceModels == null)
            return null;
        for(CodegenModel parentModel: model.interfaceModels) {
            inheritedFrom = getInheritedFromRecurse(property, parentModel);
            if(inheritedFrom != null)
                return inheritedFrom;
        }
        return null;
    }

    public static CodegenProperty getPrimary(CodegenModel model) {
        CodegenProperty primary = null;
        for(CodegenProperty property : model.allVars) {
            CBIColumnMeta meta = CBIColumnMeta.getOrAdd(property);
            if(meta.isPrimary)
                primary = property;
        }
        return primary;
    }

    public static boolean isResourceModel(CodegenModel model) {
        return CBIModelMeta.getOrAdd(model).isResource;
    }

    public static boolean isBaseModel(CodegenModel model) {
        return CBIModelMeta.getOrAdd(model).isBase;
    }
}
