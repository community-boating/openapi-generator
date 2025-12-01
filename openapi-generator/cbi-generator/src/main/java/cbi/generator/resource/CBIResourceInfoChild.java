package cbi.generator.resource;

import org.openapitools.codegen.CodegenModel;

import java.util.ArrayList;

public class CBIResourceInfoChild extends CBIResourceInfoBase {
    public CBIResourceInfo parent;
    public CBIResourceInfoChild(CBIResourceInfo parent, CodegenModel subResourceModel) {
        this.parent = parent;
        this.baseName = subResourceModel.name;
        this.model = subResourceModel;
        this.columns = new ArrayList<>(parent.columns.size());

        this.relations = new ArrayList<>();
    }
}
