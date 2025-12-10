package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.resource.CBIResourceInfoShared;

public class CBIRelationInfoNormal extends CBIRelationInfo {
    //Resource B
    public CBIResourceInfoShared resourceB;
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
    public void addMissingColumns() {
        if(forwardRef == null) {
            forwardRef = new CBIColumnInfo(resourceA, null);
            forwardRef.relation = this;
            forwardRef.columnName = meta.forwardRef;
            forwardRef.columnType = resourceB.baseName;
            if(backRef != null)
                forwardRef.isRequired = backRef.isRequired;
        }
        if(!Boolean.FALSE.equals(meta.hasForward))
            forwardRef.addToModel();
        else
            forwardRef.removeFromModel();
        if(backRef == null) {
            backRef = new CBIColumnInfo(resourceB, null);
            backRef.relation = this;
            backRef.columnName = meta.backwardRef;
            if(type == CBIRelationType.MANY_TO_MANY || type == CBIRelationType.ONE_TO_MANY){
                backRef.isArray = true;
            }
            if(forwardRef != null)
                backRef.isRequired = forwardRef.isRequired;
            backRef.columnType = resourceA.baseName;
            //backRef.columnName = "WHATADERP";
        }
        if(!Boolean.FALSE.equals(meta.hasBackward))
            backRef.addToModel();
        else
            backRef.removeFromModel();

    }

    @Override
    public String toString() {
        return "RelationName: " + relationName + "\nResource A: " + resourceA.baseName + "\nResource B: " + resourceB.baseName + "\nForward ref: (" + forwardRef + ")\nBack ref: (" + backRef + ")";
    }
}
