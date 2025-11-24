        Model name: TestThroughTableChild
                    Has relations:
                    RelationName: TestThroughTableChild_TO_TestTypeRoot, Resource A: TestThroughTableChild, Resource B: TestTypeRoot, Forward ref: (null), Back ref: (Column Name: childrenThroughTable, Column Type: List)
            id
                {x-dto-name=assignId, x-cbi-column-info=Column Name: id, Column Type: Long}
            derping
                {x-cbi-column-info=Column Name: derping, Column Type: String}
            readOnlyString
                {x-cbi-column-info=Column Name: readOnlyString, Column Type: String}
            testChild
                {x-relation-definition-cloned=RelationType: ONE_TO_ONE, isBackref: false, x-use-new=true, x-cbi-column-info=Column Name: testChild, Column Type: TestInheritanceChild}
