package cbi.generator.meta;

import org.openapitools.codegen.CodegenProperty;

import java.util.Collections;
import java.util.Map;

public class CBIColumnMeta extends MetaBase {
    public String columnNameDB;
    public Boolean isPrimary;
    public CBIColumnMeta(Map<String, Object> map) {
        super(map);
        this.columnNameDB = getString("x-column-name-db", null);
        this.isPrimary = getBoolean("x-is-primary", null);
    }

    public static CBIColumnMeta copy(CBIColumnMeta existing) {
        CBIColumnMeta created = new CBIColumnMeta(Collections.emptyMap());
        created.columnNameDB = existing.columnNameDB;
        created.isPrimary = existing.isPrimary;
        return created;
    }

    public static CBIColumnMeta getOrAdd(CodegenProperty property) {
        CBIColumnMeta meta;
        if(property.vendorExtensions != null){
            Object existing = property.vendorExtensions.get("x-column-meta");
            if(existing instanceof CBIColumnMeta) {
                meta = (CBIColumnMeta) existing;
            }else if(existing instanceof Map){
                meta = new CBIColumnMeta((Map<String, Object>)existing);
            }else{
                meta = new CBIColumnMeta(property.vendorExtensions);
            }
        }else{
            meta = new CBIColumnMeta(Collections.emptyMap());
        }
        if(meta.isPrimary == null)
            meta.isPrimary = property.name.equals("id");
        if(meta.columnNameDB == null)
            meta.columnNameDB = property.nameInSnakeCase;
        return meta;
    }
}
