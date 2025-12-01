package cbi.generator;

import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

public class ModelAndProperty {
    public CodegenModel model;
    public CodegenProperty property;
    public ModelAndProperty(CodegenModel model, CodegenProperty property) {
        this.model = model;
        this.property = property;
    }
}
