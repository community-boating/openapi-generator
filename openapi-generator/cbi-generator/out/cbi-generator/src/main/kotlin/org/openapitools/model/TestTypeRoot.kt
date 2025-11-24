        Model name: TestTypeRoot
                    Has relations:
                    RelationName: TestTypeRoot_TO_TestTypeChild, Resource A: TestTypeRoot, Resource B: TestTypeChild, Forward ref: (Column Name: child, Column Type: TestTypeChild), Back ref: (Column Name: parentId, Column Type: TestTypeRoot)
                    RelationName: TestTypeChildMultiple_TO_TestTypeRoot, Resource A: TestTypeChildMultiple, Resource B: TestTypeRoot, Forward ref: (Column Name: parentId, Column Type: TestTypeRoot), Back ref: (Column Name: childMultiple, Column Type: List)
                    RelationName: TestThroughTableChild_TO_TestTypeRoot, Resource A: TestThroughTableChild, Resource B: TestTypeRoot, Forward ref: (null), Back ref: (Column Name: childrenThroughTable, Column Type: List)
            id
                {x-dto-name=assignId, x-cbi-column-info=Column Name: id, Column Type: Long}
            optionalStringDTO
                {x-dto-only=true, x-cbi-column-info=Column Name: optionalStringDTO, Column Type: String}
            requiredString
                {x-cbi-column-info=Column Name: requiredString, Column Type: String}
            child
                {x-backref=parentId, x-use-new=true, x-cbi-column-info=Column Name: child, Column Type: TestTypeChild, x-relation-definition-cloned=RelationType: ONE_TO_ONE, isBackref: false}
            childMultiple
                {x-backref=parentId, x-cbi-column-info=Column Name: childMultiple, Column Type: List, x-relation-definition-cloned=RelationType: ONE_TO_MANY, isBackref: true, x-include-when-flat=true}
            childrenThroughTable
                {x-relation-definition-cloned=RelationType: ONE_TO_MANY, isBackref: true, x-cbi-column-info=Column Name: childrenThroughTable, Column Type: List}
