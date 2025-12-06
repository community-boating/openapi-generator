package cbi.generator.resource;

import org.openapitools.codegen.CodegenModel;

import java.util.ArrayList;

public class CBIResourceInfoChild extends CBIResourceInfoShared {
    public CBIResourceInfo base;
    public CBIResourceInfoChild(CBIResourceInfo base, CodegenModel subResourceModel) {
        this.base = base;
        this.baseName = subResourceModel.name;
        this.model = subResourceModel;
        this.columns = new ArrayList<>(base.columns.size());

        this.relations = new ArrayList<>();
    }
}
