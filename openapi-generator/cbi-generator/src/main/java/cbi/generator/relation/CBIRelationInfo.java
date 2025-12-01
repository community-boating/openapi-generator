package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.resource.CBIResourceInfo;
import cbi.generator.resource.CBIResourceInfoBase;
import cbi.generator.resource.CBIResourceInfoChild;

import java.util.ArrayList;

public class CBIRelationInfo {
    public String relationName;
    public CBIRelationType type;
    //Resource A
    public CBIResourceInfoBase resourceA;
    //Forward ref property A -> B
    public CBIColumnInfo forwardRef;
    //Back ref property B -> A
    public CBIColumnInfo backRef;
    public CBIRelationMeta meta;
    public CBIRelationInfo superRelation;
    public ArrayList<CBIRelationInfo> subRelations = new ArrayList<>();
    public CBIRelationInfo(CBIRelationType type) {
        this.type = type;
    }
    @Override
    public int hashCode(){
        return relationName.hashCode();
    }
    @Override
    public boolean equals(final Object other){
        if(other == null)
            return false;
        if(other instanceof CBIRelationInfo){
            CBIRelationInfo otherCast = (CBIRelationInfo) other;
            return this.relationName.equals(otherCast.relationName);
        }
        return false;
    }

    static CBIRelationInfoNormal findByResources(ArrayList<CBIRelationInfo> relations, CBIResourceInfoBase resourceA, CBIResourceInfoBase resourceB){
        for(CBIRelationInfo relation: relations) {
            if(relation instanceof CBIRelationInfoNormal) {
                if(relation.resourceA == resourceA && ((CBIRelationInfoNormal) relation).resourceB == resourceB)
                    return (CBIRelationInfoNormal) relation;
            }
        }
        return null;
    }

    public static CBIRelationInfoNormal findOrAddBaseRelation(ArrayList<CBIRelationInfo> relations, CBIRelationInfo potentialChild){
        if(potentialChild instanceof CBIRelationInfoNormal){
            CBIResourceInfoBase resourceA = potentialChild.resourceA;
            CBIResourceInfoBase resourceB = ((CBIRelationInfoNormal) potentialChild).resourceB;
            if(!(resourceA instanceof CBIResourceInfoChild) && !(resourceB instanceof CBIResourceInfoChild))
                return null;
            if(resourceA instanceof CBIResourceInfoChild)
                resourceA = ((CBIResourceInfoChild) resourceA).parent;
            if(resourceB instanceof CBIResourceInfoChild)
                resourceB = ((CBIResourceInfoChild) resourceB).parent;
            CBIRelationInfoNormal existing = findByResources(relations, resourceA, resourceB);
            if(existing == null) {
                CBIRelationMeta meta = CBIRelationMeta.fromResources(potentialChild.meta, resourceA, resourceB);
                existing = CBIRelationInfo.makeRelationInfo(resourceA, resourceB, meta);
                relations.add(existing);
            }
            existing.subRelations.add(potentialChild);
            potentialChild.superRelation = existing;


            return existing;
        }
        return null;
    }

    public static ArrayList<CBIRelationInfoNormal> findOrAddChildRelations(ArrayList<CBIRelationInfo> relations, CBIRelationInfo potentialParent){
        if(potentialParent instanceof CBIRelationInfoNormal){
            CBIResourceInfoBase resourceA = potentialParent.resourceA;
            CBIResourceInfoBase resourceB = ((CBIRelationInfoNormal) potentialParent).resourceB;
            if(resourceA instanceof CBIResourceInfo)
                resourceA = ((CBIResourceInfo) resourceA).subResources;
            if(resourceB instanceof CBIResourceInfoChild)
                resourceB = ((CBIResourceInfoChild) resourceB).parent;
            CBIRelationInfoNormal existing = findByResources(relations, resourceA, resourceB);


        }
        return null;
    }

    public void updateColumns() {
        if(this.forwardRef != null)
            forwardRef.relation = this;
        if(this.backRef != null)
            backRef.relation = this;
    }

    public static ArrayList<CBIRelationInfo> findAllRelations(ArrayList<CBIResourceInfoBase> resources) {
        ArrayList<CBIRelationInfo> relations = new ArrayList<>();
        /*for(CBIRelationMeta existing: existingRelations) {
            CBIResourceInfo resourceA = findByName(resources, existing.modelA);
            CBIResourceInfo resourceB = findByName(resources, existing.modelB);
            if(resourceA == null)
                throw new RuntimeException("Unable to find resource A for relation(relationName: " + existing.relationName + ", modelA: " + existing.modelA + ")");
            if(resourceB == null)
                throw new RuntimeException("Unable to find resource B for relation(relationName: " + existing.relationName + ", modelB: " + existing.modelB + ")");
            CBIRelationInfo relationInfo = CBIRelationInfo.makeRelationInfo(resourceA, resourceB, existing);
            relations.add(relationInfo);
            resourceA.relations.add(relationInfo);
            resourceB.relations.add(relationInfo);
        }*/
        for(CBIResourceInfoBase resourceA: resources){
            for(CBIColumnInfo column: resourceA.columns){
                CBIRelationMeta relationMeta = CBIRelationMeta.fromModelAndProperty(column);
                if(relationMeta != null) {
                    CBIRelationInfo relationInfo = null;
                    for (CBIRelationInfo existing : relations) {
                        if (existing.relationName.equals(relationMeta.relationName)) {
                            relationInfo = existing;
                            break;
                        }
                    }
                    if (relationInfo == null) {
                        CBIResourceInfoBase resourceB = CBIResourceInfo.findByName(resources, relationMeta.modelB);
                        if(resourceB == null)
                            throw new RuntimeException("Unable to find resource B for relation(relationName: " + relationMeta.relationName + ", modelB: " + relationMeta.modelB + ")");
                        relationInfo = CBIRelationInfo.makeRelationInfo(resourceA, resourceB, relationMeta);
                        relations.add(relationInfo);
                        //CBIRelationInfoNormal baseRelation = findOrAddBaseRelation(relations, relationInfo);
                        //if(baseRelation != null) {
                            //relations.add(baseRelation);
                        //}
                    }

                    if(relationInfo != null) {
                        if (!relationMeta.isBackref) {
                            relationInfo.forwardRef = column;
                        } else {
                            relationInfo.backRef = column;
                        }
                        relationInfo.updateColumns();
                    }

                }

            }
        }
        return relations;
    }
    static CBIRelationInfoNormal makeRelationInfo(CBIResourceInfoBase resourceA, CBIResourceInfoBase resourceB, CBIRelationMeta meta) {
        CBIRelationInfoNormal relationInfo = null;
        if(meta.relationType == CBIRelationType.ONE_TO_ONE) {
            relationInfo = new CBIRelationInfoOneToOne();
        }
        else if(meta.relationType == CBIRelationType.ONE_TO_MANY) {
            relationInfo = new CBIRelationInfoOneToMany();
        }
        else if(meta.relationType == CBIRelationType.MANY_TO_MANY) {
            relationInfo = new CBIRelationInfoManyToMany();
        }
        if(relationInfo != null) {
            relationInfo.meta = meta;
            resourceA.relations.add(relationInfo);
            resourceB.relations.add(relationInfo);
            relationInfo.relationName = meta.relationName;
            if(meta.isBackref) {
                relationInfo.resourceA = resourceB;
                relationInfo.resourceB = resourceA;
            }else{
                relationInfo.resourceA = resourceA;
                relationInfo.resourceB = resourceB;
            }
        }
        return relationInfo;
    }
}

