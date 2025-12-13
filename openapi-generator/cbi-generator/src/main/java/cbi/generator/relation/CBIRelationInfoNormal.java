package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.resource.CBIResourceInfoShared;

public class CBIRelationInfoNormal extends CBIRelationInfo {
    //Resource B
    public CBIResourceInfoShared resourceB;
    public boolean forwardOverride;
    public boolean backwardOverride;
    CBIRelationInfoNormal(CBIRelationType type) {
        super(type);
    }

    public boolean isHigherA(CBIRelationInfo other) {
        return other.resourceA.hasParent(this.resourceA);
        //boolean greaterB = other.resourceB.hasParent(this.resourceB);
        //boolean equalA = other.resourceA.equals(this.resourceA);
        //boolean equalB = other.resourceB.equals(this.resourceB);
        //return (other.resourceA.hasParent(this.resourceA) && greaterB) || (other.resourceA.hasParent(this.resourceA) && equalB) || (greaterB && equalA);
    }

    public boolean isHigherB(CBIRelationInfoNormal other) {
        return other.resourceB.hasParent(this.resourceB);
    }

    @Override
    public void syncColumnsToModel() {
        //boolean isRequired = (forwardRef != null && forwardRef.isRequired) || (backRef != null && backRef.isRequired);
        if(forwardRef == null) {
            forwardRef = new CBIColumnInfo(resourceA, null);
        }
        //forwardRef.isRequired = isRequired;
        forwardRef.columnName = meta.forwardRef;
        forwardRef.columnType = resourceB.name;
        if(!forwardOverride) {
            if (!Boolean.FALSE.equals(meta.hasForward)) {
                forwardRef.addToModel();
                forwardRef.relation = this;
            }else{
                forwardRef.removeFromModel();
            }
        }
        if(backRef == null) {
            backRef = new CBIColumnInfo(resourceB, null);
            if(type == CBIRelationType.MANY_TO_MANY || type == CBIRelationType.ONE_TO_MANY){
                backRef.isArray = true;
            }
        }
        backRef.columnName = meta.backwardRef;
        backRef.columnType = resourceA.name;
        if(!backwardOverride) {
            if (!Boolean.FALSE.equals(meta.hasBackward)) {
                backRef.addToModel();
                backRef.relation = this;
            }else {
                backRef.removeFromModel();
            }
        }

    }

    @Override
    public String toString() {
        return "RelationName: " + relationName + "\nResource A: " + resourceA.name + "\nResource B: " + resourceB.name + "\nForward ref: (" + forwardRef + ")\nBack ref: (" + backRef + ")";
    }
}
