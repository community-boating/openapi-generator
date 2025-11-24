        TestTypeChild
            {x-use-new=true, x-cbi-resource-info=cbi.generator.CBIResourceInfo@74eef970}
            id
                {x-dto-name=assignId, x-cbi-column-info=cbi.generator.CBIColumnInfo@46325ff}
            readOnlyString
                {x-cbi-column-info=cbi.generator.CBIColumnInfo@3546e702}
            parentId
                {x-relation-definition={isBackref=true, testRef=[{$ref=#/components/schemas/TestTypeRoot}]}, x-use-new=true, x-cbi-column-info=cbi.generator.CBIColumnInfo@bbd12f17, x-dto-flat=true, x-relation-definition-cloned=RelationType: ONE_TO_ONE, isBackref: true}
