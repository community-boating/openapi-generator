Model name: TestThroughTableChild
                Resource Suffix: 
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChild, ResourceB: TestInheritanceParent, hasForward: true, hasBackward: true
                    Relation: TestTypeRoot_TO_TestThroughTableChild, Resource A: TestThroughTableChild, ResourceB: TestTypeRoot, hasForward: , hasBackward: true
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChild, ResourceB: TestInheritanceChild, hasForward: false, hasBackward: true
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChild, ResourceB: TestInheritanceChildI, hasForward: false, hasBackward: true
                Has Resource: TestThroughTableChild
                    Base Resource: TestThroughTableChild
                    Child Resource: TestThroughTableChild
                MODEL META
                    hasDTO: false
                    hasDAO: true
                    hasTable: true
                    hasInterface: true
                    isResource: true
                    isBase: true

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: derping
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: testChild
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceParent
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceParent
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceParent
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceParent
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceParent
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
                            Column Type: TestThroughTableChild
                            Is Array: false
        Variable Name: testThroughTableChild
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: TestTypeRoot_TO_TestThroughTableChild
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
                            Column Type: TestThroughTableChild
                            Is Array: true
