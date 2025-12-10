package cbi.generator.relation;

import cbi.generator.enums.CBIRelationType;

public class CBIRelationInfoOneToOne extends CBIRelationInfoNormal {
    public CBIRelationInfoOneToOneTyped typeRelation;
    public boolean hasTypeRelation() {
        return typeRelation != null;
    }
    CBIRelationInfoOneToOne() {
        super(CBIRelationType.ONE_TO_ONE);
    }
}
