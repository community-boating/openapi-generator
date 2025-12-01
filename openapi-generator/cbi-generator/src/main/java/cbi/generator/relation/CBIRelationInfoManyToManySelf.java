package cbi.generator.relation;

import cbi.generator.enums.CBIRelationType;

public class CBIRelationInfoManyToManySelf extends CBIRelationInfoManyToManyBase {
    CBIRelationInfoManyToManySelf() {
        super(CBIRelationType.MANY_TO_MANY_SELF);
    }
}
