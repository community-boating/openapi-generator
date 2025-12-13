package cbi.generator;

import org.openapitools.codegen.CodegenProperty;

public class Util {
    public static boolean isPropertyModel(CodegenProperty property) {
        return property.isModel || (property.isArray && property.items.isModel);
    }
}
