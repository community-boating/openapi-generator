        TestTypeRoot
            {x-use-new=true, x-cbi-resource-info=cbi.generator.CBIResourceInfo@c0ea20e}
            id
                {x-dto-name=assignId, x-cbi-column-info=cbi.generator.CBIColumnInfo@46325ff}
            optionalStringDTO
                {x-dto-only=true, x-cbi-column-info=cbi.generator.CBIColumnInfo@96dd3e7d}
            requiredString
                {x-cbi-column-info=cbi.generator.CBIColumnInfo@860d3e7f}
            child
                {x-backref=parentId, x-use-new=true, x-cbi-column-info=cbi.generator.CBIColumnInfo@2e9429ac, x-relation-definition-cloned=RelationType: ONE_TO_ONE, isBackref: null}
            childMultiple
                {x-backref=parentId, x-include-when-flat=true, x-cbi-column-info=cbi.generator.CBIColumnInfo@978e964e}
            childrenThroughTable
                {x-cbi-column-info=cbi.generator.CBIColumnInfo@148ed2aa}
