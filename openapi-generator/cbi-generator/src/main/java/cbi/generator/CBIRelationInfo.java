package cbi.generator;

import java.util.ArrayList;

enum CBIRelationType {
    ONE_TO_ONE,
    ONE_TO_ONE_TYPED,
    ONE_TO_MANY,
    MANY_TO_MANY
}

public class CBIRelationInfo {
    String relationName;
    CBIRelationType type;
    //Resource A
    CBIResourceInfo resourceA;
    //Forward ref property A -> B
    CBIColumnInfo forwardRef;
    //Back ref property B -> A
    CBIColumnInfo backRef;
    CBIRelationInfo(CBIRelationType type) {
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
    static CBIResourceInfo findByName(ArrayList<CBIResourceInfo> resources, String name) {
        for(CBIResourceInfo resource: resources) {
            if(resource.baseName.equals(name)){
                return resource;
            }
        }
        return null;
    }
    static ArrayList<CBIRelationInfo> findAllRelations(ArrayList<CBIResourceInfo> resources) {
        ArrayList<CBIRelationInfo> relations = new ArrayList<>();
        for(CBIResourceInfo resourceA: resources){
            for(CBIColumnInfo column: resourceA.columns){
                if(column.modelProperties != null && !column.modelProperties.isEmpty()) {
                    CBIColumnInfo.ModelAndProperty modelAndProperty = column.modelProperties.get(0);
                    CBIColumnInfo.CBIRelationDefinition relationDefinition = CBIColumnInfo.CBIRelationDefinition.fromModelAndProperty(modelAndProperty);
                    if(relationDefinition != null){
                        CBIRelationInfo relationInfo = null;
                        for(CBIRelationInfo existing: relations) {
                            if(existing.relationName.equals(relationDefinition.relationName)){
                                relationInfo = existing;
                                break;
                            }
                        }
                        if(relationInfo == null){
                            CBIResourceInfo resourceB = findByName(resources, relationDefinition.modelB);
                            relationInfo = CBIRelationInfo.getRelationInfo(resourceA, resourceB, relationDefinition);
                            relations.add(relationInfo);
                        }
                        if(relationInfo.forwardRef == null && !relationDefinition.isBackref) {
                            relationInfo.forwardRef = column;
                        }
                        if(relationInfo.backRef == null && relationDefinition.isBackref) {
                            relationInfo.backRef = column;
                        }
                    }
                }
            }
        }
        return null;
    }
    static CBIRelationInfoNormal getRelationInfo(CBIResourceInfo resourceA, CBIResourceInfo resourceB, CBIColumnInfo.CBIRelationDefinition definition) {
        CBIRelationInfoNormal relationInfo = null;
        if(definition.relationType == CBIRelationType.ONE_TO_ONE) {
            relationInfo = new CBIRelationInfoOneToOne();
        }
        else if(definition.relationType == CBIRelationType.ONE_TO_MANY) {
            relationInfo = new CBIRelationInfoOneToMany();
        }
        else if(definition.relationType == CBIRelationType.MANY_TO_MANY) {
            relationInfo = new CBIRelationInfoManyToMany();
        }
        if(relationInfo != null) {
            relationInfo.relationName = definition.relationName;
            if(definition.isBackref) {
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

class CBIRelationInfoNormal extends CBIRelationInfo {
    //Resource B
    CBIResourceInfo resourceB;
    CBIRelationInfoNormal(CBIRelationType type) {
        super(type);
    }
}

class CBIRelationInfoOneToOneTyped extends CBIRelationInfo {
    //Resources B
    ArrayList<CBIResourceInfo> resourceBs = new ArrayList<>();
    CBIColumnInfo typeColumn;
    CBIRelationInfoOneToOneTyped() {
        super(CBIRelationType.ONE_TO_ONE_TYPED);
    }
}

class CBIRelationInfoOneToOne extends CBIRelationInfoNormal {
    CBIRelationInfoOneToOne() {
        super(CBIRelationType.ONE_TO_ONE);
    }
}

class CBIRelationInfoOneToMany extends CBIRelationInfoNormal {
    CBIRelationInfoOneToMany() {
        super(CBIRelationType.ONE_TO_MANY);
    }
}

class CBIRelationInfoManyToMany extends CBIRelationInfoNormal {
    String throughTableName;
    CBIRelationInfoManyToMany() {
        super(CBIRelationType.MANY_TO_MANY);
    }
}
