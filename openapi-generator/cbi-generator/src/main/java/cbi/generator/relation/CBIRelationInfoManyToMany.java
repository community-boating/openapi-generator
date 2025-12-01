package cbi.generator.relation;

import cbi.generator.enums.CBIRelationType;

public class CBIRelationInfoManyToMany extends CBIRelationInfoManyToManyBase {
    CBIRelationInfoManyToMany() {
        super(CBIRelationType.MANY_TO_MANY);
    }
}
