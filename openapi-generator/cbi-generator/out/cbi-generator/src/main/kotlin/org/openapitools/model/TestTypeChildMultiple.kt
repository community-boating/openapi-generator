        Model name: TestTypeChildMultiple
                    Has relations:
                    RelationName: TestTypeChildMultiple_TO_TestTypeRoot, Resource A: TestTypeChildMultiple, Resource B: TestTypeRoot, Forward ref: (Column Name: parentId, Column Type: TestTypeRoot), Back ref: (Column Name: childMultiple, Column Type: List)
            id
                {x-dto-name=assignId, x-cbi-column-info=Column Name: id, Column Type: Long}
            testDTOOnly
                {x-dto-only=true, x-cbi-column-info=Column Name: testDTOOnly, Column Type: Int}
            testDAOOnly
                {x-dao-only=true, x-cbi-column-info=Column Name: testDAOOnly, Column Type: Int}
            aString
                {x-cbi-column-info=Column Name: aString, Column Type: String}
            parentId
                {x-use-new=true, x-cbi-column-info=Column Name: parentId, Column Type: TestTypeRoot, x-dto-flat=true, x-relation-definition-cloned=RelationType: ONE_TO_ONE, isBackref: false}
