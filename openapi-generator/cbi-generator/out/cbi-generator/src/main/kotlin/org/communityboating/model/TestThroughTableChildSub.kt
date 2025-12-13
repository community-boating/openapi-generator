            TestThroughTableChildInterface
Model name: TestThroughTableChildSub
                Resource Suffix: 
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChildSub, ResourceB: TestInheritanceChild, hasForward: false, hasBackward: false
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChildSub, ResourceB: TestInheritanceChildI, hasForward: false, hasBackward: false
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChildSub, ResourceB: TestInheritanceParent, hasForward: true, hasBackward: false
                    Relation: TestTypeRoot_TO_TestThroughTableChild, Resource A: TestThroughTableChildSub, ResourceB: TestTypeRoot, hasForward: , hasBackward: false
                Has Resource: TestThroughTableChild
                    Parent Resource: TestThroughTableChild
                MODEL META
                    hasDTO: false
                    hasDAO: false
                    hasTable: false
                    hasInterface: true
                    isResource: true
                    isBase: false

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: testChild
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: TestThroughTableChild_TO_TestInheritanceParent
                        Type: ONE_TO_ONE
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChild_TO_TestInheritanceParent
                        Resource A: TestThroughTableChild
                        Resource B: TestInheritanceParent
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceParent
                            Is Array: false
                        Back ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestThroughTableChildSub
                            Is Array: false
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: derping
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: testThroughTableChild
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: TestTypeRoot_TO_TestThroughTableChild
                        Type: ONE_TO_MANY
                        Base Name: TestTypeRoot_TO_TestThroughTableChild
                        Name: TestTypeRoot_TO_TestThroughTableChild
                        Resource A: TestThroughTableChild
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChildSub
                            Is Array: true
