package cbi.generator.relation;

import cbi.generator.enums.CBIRelationType;
import cbi.generator.resource.CBIResourceInfo;

public abstract class CBIRelationInfoManyToManyBase extends CBIRelationInfoNormal {
    CBIResourceInfo throughResource;
    CBIRelationInfoManyToManyBase(CBIRelationType type) {
        super(type);
    }
}
