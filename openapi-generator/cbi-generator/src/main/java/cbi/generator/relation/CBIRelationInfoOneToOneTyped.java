package cbi.generator.relation;

import cbi.generator.CBIColumnInfo;
import cbi.generator.enums.CBIRelationType;
import cbi.generator.resource.CBIResourceInfoShared;

import java.util.ArrayList;

public class CBIRelationInfoOneToOneTyped extends CBIRelationInfo {
    //Resources B
    ArrayList<CBIResourceInfoShared> resourceBs = new ArrayList<>();
    CBIColumnInfo typeColumn;
    CBIRelationInfoOneToOneTyped() {
        super(CBIRelationType.ONE_TO_ONE_TYPED);
    }
}
