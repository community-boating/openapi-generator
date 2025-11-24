        Model name: TestTypeChild
                    Has relations:
                    RelationName: TestTypeRoot_TO_TestTypeChild, Resource A: TestTypeRoot, Resource B: TestTypeChild, Forward ref: (Column Name: child, Column Type: TestTypeChild), Back ref: (Column Name: parentId, Column Type: TestTypeRoot)
            id
                {x-dto-name=assignId, x-cbi-column-info=Column Name: id, Column Type: Long}
            readOnlyString
                {x-cbi-column-info=Column Name: readOnlyString, Column Type: String}
            parentId
                {x-relation-definition={isBackref=true}, x-use-new=true, x-cbi-column-info=Column Name: parentId, Column Type: TestTypeRoot, x-dto-flat=true, x-relation-definition-cloned=RelationType: ONE_TO_ONE, isBackref: true}
