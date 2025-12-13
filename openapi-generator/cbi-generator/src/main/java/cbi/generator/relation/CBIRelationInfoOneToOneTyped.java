package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.resource.CBIResourceInfoShared;
import org.openapitools.codegen.CodegenDiscriminator;
import org.openapitools.codegen.CodegenModel;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CBIRelationInfoOneToOneTyped extends CBIRelationInfo {
    //Resources B
    public List<CBIRelationInfoOneToOne> typeRelations;
    public CodegenDiscriminator discriminator;
    public CBIColumnInfo typeColumn;
    public CodegenModel parent;
    CBIRelationInfoOneToOneTyped(CodegenModel parent) {
        super(CBIRelationType.ONE_TO_ONE_TYPED);
        this.discriminator = parent.discriminator;
        this.parent = parent;
        if(this.parent.vendorExtensions == null)
            this.parent.vendorExtensions = new TreeMap<>();
        this.parent.vendorExtensions.put("x-cbi-relation-one-to-one-typed", this);
    }
    public boolean isOneToOneTyped = true;
    static CBIRelationInfoOneToOneTyped makeRelationInfoOneToOneTyped(CBIResourceInfoShared resourceA, List<CBIResourceInfoShared> resourceBs, CBIRelationMeta meta, boolean add, boolean swapBack) {
        meta.isBackref = true;
        CBIRelationInfoOneToOneTyped relationInfo = new CBIRelationInfoOneToOneTyped(resourceBs.get(0).model.parentModel);
        Optional<CBIColumnInfo> typeColumn = resourceA.columns.stream().filter((a) -> a.columnName.equalsIgnoreCase(relationInfo.discriminator.getPropertyName())).findAny();
        if(typeColumn.isEmpty())
            throw new RuntimeException("Unable to find type column in parent model: " + resourceA.model.name + ", type column: " + relationInfo.discriminator.getPropertyName());
        relationInfo.typeColumn = typeColumn.get();
        relationInfo.typeRelations = resourceBs.stream().map((resourceB) -> {
            CBIRelationMeta typeMeta = CBIRelationMeta.fromResources(meta, resourceB, resourceA, false, false);
            typeMeta.isBackref = false;
            typeMeta.relationType = CBIRelationType.ONE_TO_ONE;
            //resourceB.model.allVars = resourceB.model.allVars.stream().filter(a -> !a.name.equalsIgnoreCase(relationInfo.discriminator.getPropertyName())).collect(Collectors.toList());
            CBIRelationInfoNormal typeInfo = CBIRelationInfoNormal.makeRelationInfo(resourceB, resourceA, typeMeta, true, false);
            //if(resourceA instanceof CBIResourceInfo) {
            //    ((CBIResourceInfo) resourceA).subResources.forEach(subResource -> subResource.relations.add(typeInfo));
            //}
            ((CBIRelationInfoOneToOne)typeInfo).typeRelation = relationInfo;
            return (CBIRelationInfoOneToOne)typeInfo;
        }).collect(Collectors.toList());
        //relationInfo.resourceBs = resourceBs;
        meta.hasBackward = false;
        meta.hasForward = false;
        relationInfo.resourceA = resourceA;
        relationInfo.meta = meta;
        //if(add) {
            //resourceA.relations.add(relationInfo);
            //resourceBs.forEach((a) -> a.relations.add(relationInfo));
            //resourceB.relations.add(relationInfo);
        //}
        relationInfo.relationName = meta.relationName;
        if(Boolean.TRUE.equals(meta.isBackref) && swapBack) {
            //relationInfo.resourceA = resourceBs.get(0);
            //relationInfo.resourceBs
        }else{
            //relationInfo.resourceA = resourceA;
            //relationInfo.resourceB = resourceB;
        }

        return relationInfo;
    }
    @Override
    public void syncColumnsToModel() {
        //this.typeRelations.forEach(CBIRelationInfoNormal::addMissingColumns);

    }
}
