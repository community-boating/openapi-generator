package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.meta.CBIModelMeta;
import cbi.generator.meta.CBIRelationMeta;
import cbi.generator.resource.CBIResourceInfo;
import cbi.generator.resource.CBIResourceInfoShared;
import cbi.generator.resource.CBIResourceInfoChild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CBIRelationInfo {
    public String relationName;
    public CBIRelationType type;
    //Resource A
    public CBIResourceInfoShared resourceA;
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

    void updateSuperRelation(CBIRelationInfo parent) {
        this.superRelation = parent;
        this.meta.forwardRef = parent.meta.forwardRef;
        this.meta.backwardRef = parent.meta.backwardRef;
        //this.meta.hasForward = parent.meta.hasForward;
        //this.meta.hasBackward = parent.meta.hasBackward;
    }

    public CBIRelationInfo getBaseRelation() {
        if(superRelation != null)
            return superRelation;
        return this;
    }

    public String getRelationBaseName() {
        if(superRelation != null)
            return superRelation.getRelationBaseName();
        return relationName;
    }

    static CBIRelationInfoNormal findByResourceB(ArrayList<CBIRelationInfo> relations, CBIResourceInfoShared resourceB, String relationBaseName){
        for(CBIRelationInfo relation: relations) {
            if(relation instanceof CBIRelationInfoNormal) {
                if(((CBIRelationInfoNormal) relation).resourceB == resourceB && relation.getRelationBaseName().equals(relationBaseName))
                    return (CBIRelationInfoNormal) relation;
            }
        }
        return null;
    }

    static CBIRelationInfoNormal findByResourceA(ArrayList<CBIRelationInfo> relations, CBIResourceInfoShared resourceA, String relationBaseName){
        for(CBIRelationInfo relation: relations) {
            if(relation instanceof CBIRelationInfoNormal) {
                if(relation.resourceA == resourceA && (relation.getRelationBaseName().equals(relationBaseName)))
                    return (CBIRelationInfoNormal) relation;
            }
        }
        return null;
    }

    static CBIRelationInfoNormal findByResources(ArrayList<CBIRelationInfo> relations, CBIResourceInfoShared resourceA, CBIResourceInfoShared resourceB){
        for(CBIRelationInfo relation: relations) {
            if(relation instanceof CBIRelationInfoNormal) {
                if(relation.resourceA == resourceA && ((CBIRelationInfoNormal) relation).resourceB == resourceB)
                    return (CBIRelationInfoNormal) relation;
            }
        }
        return null;
    }

    public abstract void addMissingColumns();

    public static CBIRelationInfoNormal findOrAddBaseRelation(ArrayList<CBIRelationInfo> relations, CBIRelationInfo potentialChild){
        if(potentialChild instanceof CBIRelationInfoNormal){
            CBIResourceInfoShared resourceA = potentialChild.resourceA;
            CBIResourceInfoShared resourceB = ((CBIRelationInfoNormal) potentialChild).resourceB;
            if(!(resourceA instanceof CBIResourceInfoChild) && !(resourceB instanceof CBIResourceInfoChild))
                return null;
            if(resourceA instanceof CBIResourceInfoChild)
                resourceA = ((CBIResourceInfoChild) resourceA).base;
            if(resourceB instanceof CBIResourceInfoChild)
                resourceB = ((CBIResourceInfoChild) resourceB).base;
            CBIRelationInfoNormal existing = findByResources(relations, resourceA, resourceB);
            if(existing == null) {
                CBIRelationMeta meta = CBIRelationMeta.fromResources(potentialChild.getBaseRelation().meta, resourceA, resourceB, false, false);
                existing = CBIRelationInfo.makeRelationInfo(resourceA, resourceB, meta, true, false);
                existing.meta.hasForward = false;
                existing.meta.hasBackward = false;
                relations.add(existing);
            }
            existing.subRelations.add(potentialChild);
            potentialChild.updateSuperRelation(existing);

            return existing;
        }
        return null;
    }

    static void findOrAddChildRelation(ArrayList<CBIRelationInfo> relations, CBIResourceInfoShared childResourceA, CBIResourceInfoShared childResourceB, CBIRelationInfo potentialParent, boolean doRecurse) {
        String relationNameBase = potentialParent.getRelationBaseName();
        CBIRelationInfoNormal existingExact = CBIRelationInfo.findByResources(relations, childResourceA, childResourceB);


        if(existingExact != null)
            //TODO delete relationship
            return;

        CBIRelationInfoNormal existingA = CBIRelationInfo.findByResourceA(relations, childResourceA, relationNameBase);
        CBIRelationInfoNormal existingB = CBIRelationInfo.findByResourceB(relations, childResourceB, relationNameBase);

        boolean hasA = existingA != null;
        boolean hasB = existingB != null;
        boolean hasRelationA = CBIModelMeta.hasRelation(childResourceA.model, relationNameBase) >= 0;
        boolean hasRelationB = CBIModelMeta.hasRelation(childResourceB.model, relationNameBase) >= 0;

        CBIRelationInfoNormal newRelation = null;
        if((hasRelationA && !hasA) || (hasRelationB && !hasB) || (hasRelationA && hasRelationB)) {
            CBIRelationMeta meta = CBIRelationMeta.fromResources(potentialParent.getBaseRelation().meta, childResourceA, childResourceB, false, true);
            newRelation = CBIRelationInfo.makeRelationInfo(childResourceA, childResourceB, meta, false, false);
            relations.add(newRelation);
            if(potentialParent.superRelation != null) {
                potentialParent.superRelation.subRelations.add(newRelation);
                newRelation.superRelation = potentialParent.superRelation;
            }else{
                potentialParent.subRelations.add(newRelation);
                newRelation.superRelation = potentialParent;
            }
            //newRelation.parentRelation = potentialParent;
            if(doRecurse)
                findOrAddChildRelations(relations, newRelation);
        }

        if(hasRelationA) {
            //if(!hasA) {

                //if(!hasB || !childResourceA.hasParent(existingB.resourceA)){
                    childResourceA.relations.add(newRelation);
                //}
                if(hasB){
                    //existingB.childRelations.add(newRelation);
                    //newRelation.parentRelation = existingB;
                }
                //existingA = newRelation;
                //childResourceA.relations.add(newRelation);
            //}else{
                if(hasB){
                    System.out.println("BOOMERANG");
                }
                //if(existingA.parentRelation == null) {
                    //potentialParent.childRelations.add(existingA);
                    //existingA.parentRelation = potentialParent;
                //}
                //existingA.parentRelation = existingA;
                System.out.println(relationNameBase);
            //}
            /*if(existingA.resourceA.hasParent(childResourceA)){
                existingA.parentRelation = newRelation;
                //newRelation.childRelations.add(existingA);
            }else{
                if(newRelation != null)
                    newRelation.parentRelation = existingA;
                //existingA.childRelations.add(newRelation);
                //childResourceA.relations.add(newRelation);
            }*/
        }
        if(hasRelationB) {
            //if(!hasB) {
                //if(!hasA || !childResourceB.hasParent(existingA.resourceB)){
                    childResourceB.relations.add(newRelation);
                //}
                //if(!hasA){
                    //childResourceB.relations.add(newRelation);
                    //existingA.childRelations.add(newRelation);
                    //newRelation.parentRelation = existingA;
                //}
                //existingB = newRelation;
            //}else{
                //if(existingB.parentRelation == null) {
                    //potentialParent.childRelations.add(existingB);
                    //existingB.parentRelation = potentialParent;
                //}
            //}
            /*if(existingB.resourceB.hasParent(childResourceB)){
                existingB.parentRelation = newRelation;
                //newRelation.childRelations.add(existingB);
            }else{
                if(newRelation != null)
                    newRelation.parentRelation = existingB;
                //existingB.childRelations.add(newRelation);
                //childResourceB.relations.add(newRelation);
            }*/
        }
    }

    public static void findOrAddChildRelations(ArrayList<CBIRelationInfo> relations, CBIRelationInfo potentialParent){
        if(potentialParent instanceof CBIRelationInfoNormal){
            CBIResourceInfoShared resourceA = potentialParent.resourceA;
            CBIResourceInfoShared resourceB = ((CBIRelationInfoNormal) potentialParent).resourceB;
            for(CBIResourceInfoChild childResourceA: resourceA.findChildResources()){
                findOrAddChildRelation(relations, childResourceA, resourceB, potentialParent, true);
            }
            for(CBIResourceInfoChild childResourceB: resourceB.findChildResources()) {
                findOrAddChildRelation(relations, resourceA, childResourceB, potentialParent, true);
            }
            for(CBIResourceInfoChild childResourceA: resourceA.findChildResources()){
                for(CBIResourceInfoChild childResourceB: resourceB.findChildResources()) {
                    findOrAddChildRelation(relations, childResourceA, childResourceB, potentialParent, true);
                }
            }
        }
    }

    public void updateColumns() {
        if(this.forwardRef != null)
            forwardRef.relation = this;
        if(this.backRef != null)
            backRef.relation = this;
    }

    public static ArrayList<CBIRelationInfo> findAllRelations(ArrayList<CBIResourceInfoShared> resources) {
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
        for(CBIResourceInfoShared resourceA: resources){
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
                        if(relationMeta.relationType == CBIRelationType.ONE_TO_ONE_TYPED){
                            /*if(resourceA instanceof CBIResourceInfo){
                                String type = column.property.dataType;
                                List<CBIResourceInfoShared> resourceBs = resources.stream().filter((a) -> a.model.interfaces != null && a.model.interfaces.contains(type)).collect(Collectors.toList());
                                CBIRelationInfoOneToOneTyped relationInfoTyped = CBIRelationInfoOneToOneTyped.makeRelationInfoOneToOneTyped(resourceA, resourceBs, relationMeta, true, true);
                                relationInfo = relationInfoTyped;
                                relations.addAll(relationInfoTyped.typeRelations);
                                relations.add(relationInfo);
                                //findOrAddBaseRelation(relations, relationInfo);
                                for(CBIRelationInfoOneToOne typeRelation: relationInfoTyped.typeRelations) {
                                    findOrAddBaseRelation(relations, typeRelation);
                                }
                            }*/
                        }else {
                            CBIResourceInfoShared resourceB = CBIResourceInfo.findByName(resources, relationMeta.modelB);
                            if (resourceB == null)
                                throw new RuntimeException("Unable to find resource B for relation(relationName: " + relationMeta.relationName + ", modelB: " + relationMeta.modelB + ")");
                            relationInfo = CBIRelationInfo.makeRelationInfo(resourceA, resourceB, relationMeta, true, true);
                            //relations.add(relationInfo);
                            //findOrAddBaseRelation(relations, relationInfo);
                        }
                        if(relationInfo != null) {
                            relations.add(relationInfo);
                            findOrAddBaseRelation(relations, relationInfo);
                        }
                    }
                    if(relationInfo != null) {
                        if (!Boolean.TRUE.equals(relationMeta.isBackref)) {
                            relationInfo.forwardRef = column;
                        } else {
                            relationInfo.backRef = column;
                        }
                        relationInfo.updateColumns();
                    }
                }
            }
        }
        for(CBIRelationInfo relationInfo: new ArrayList<>(relations)) {
            findOrAddChildRelations(relations, relationInfo);
        }
        return relations;
    }
    static CBIRelationInfoNormal makeRelationInfo(CBIResourceInfoShared resourceA, CBIResourceInfoShared resourceB, CBIRelationMeta meta, boolean add, boolean swapBack) {
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
            if(add) {
                resourceA.relations.add(relationInfo);
                resourceB.relations.add(relationInfo);
            }
            relationInfo.relationName = meta.relationName;
            if(Boolean.TRUE.equals(meta.isBackref) && swapBack) {
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

