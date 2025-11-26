package cbi.generator;

import org.openapitools.codegen.CodegenModel;

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
    CBIColumnInfo.CBIRelationDefinition definition;
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
        //Change it so it will check all resource combinations rather than based on column, for relations specified without using a column
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
                            if(resourceB != null) {
                                relationInfo = CBIRelationInfo.makeRelationInfo(resourceA, resourceB, relationDefinition);
                                relations.add(relationInfo);
                            }
                        }
                        if(relationInfo != null) {
                            if (!relationDefinition.isBackref) {
                                relationInfo.forwardRef = column;
                            } else {
                                relationInfo.backRef = column;
                            }
                            column.relation = relationInfo;
                        }
                    }
                }
            }
        }
        return null;
    }
    static CBIRelationInfoNormal makeRelationInfo(CBIResourceInfo resourceA, CBIResourceInfo resourceB, CBIColumnInfo.CBIRelationDefinition definition) {
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
            relationInfo.definition = definition;
            resourceA.relations.add(relationInfo);
            resourceB.relations.add(relationInfo);
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

    void addMissingColumns() {
        if(forwardRef == null) {
            forwardRef = new CBIColumnInfo();
            forwardRef.relation = this;
            forwardRef.columnName = definition.forwardRef;
            forwardRef.columnType = resourceB.baseName;
            for(CodegenModel model : resourceA.schema) {
                forwardRef.addToModel(model);
            }
        }
        if(backRef == null) {
            backRef = new CBIColumnInfo();
            backRef.relation = this;
            backRef.columnName = definition.backwardRef;
            if(type == CBIRelationType.MANY_TO_MANY || type == CBIRelationType.ONE_TO_MANY){
                backRef.isArray = true;
            }
            backRef.columnType = resourceA.baseName;
            for(CodegenModel model : resourceA.schema) {
                backRef.addToModel(model);
            }
        }
    }

    @Override
    public String toString() {
        return "RelationName: " + relationName + "\nResource A: " + resourceA.baseName + "\nResource B: " + resourceB.baseName + "\nForward ref: (" + forwardRef + ")\nBack ref: (" + backRef + ")";
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
