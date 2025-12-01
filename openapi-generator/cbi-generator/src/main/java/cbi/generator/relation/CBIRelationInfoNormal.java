package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.resource.CBIResourceInfoBase;

public class CBIRelationInfoNormal extends CBIRelationInfo {
    //Resource B
    CBIResourceInfoBase resourceB;
    CBIRelationInfoNormal(CBIRelationType type) {
        super(type);
    }

    public void addMissingColumns() {
        if(forwardRef == null) {
            forwardRef = new CBIColumnInfo(resourceA, null);
            forwardRef.relation = this;
            forwardRef.columnName = meta.forwardRef;
            forwardRef.columnType = resourceB.baseName;
            forwardRef.addToModel();
        }
        if(backRef == null) {
            backRef = new CBIColumnInfo(resourceB, null);
            backRef.relation = this;
            backRef.columnName = meta.backwardRef;
            if(type == CBIRelationType.MANY_TO_MANY || type == CBIRelationType.ONE_TO_MANY){
                backRef.isArray = true;
            }
            backRef.columnType = resourceA.baseName;
            //backRef.columnName = "WHATADERP";
            backRef.addToModel();
            System.out.println(backRef.relation == null);
        }
    }

    @Override
    public String toString() {
        return "RelationName: " + relationName + "\nResource A: " + resourceA.baseName + "\nResource B: " + resourceB.baseName + "\nForward ref: (" + forwardRef + ")\nBack ref: (" + backRef + ")";
    }
}
