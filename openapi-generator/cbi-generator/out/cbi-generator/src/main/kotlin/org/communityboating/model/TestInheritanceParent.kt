Model name: TestInheritanceParent
                Resource Suffix: 
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChild, ResourceB: TestInheritanceParent, hasForward: true, hasBackward: true
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChildSub, ResourceB: TestInheritanceParent, hasForward: true, hasBackward: false
                Has Resource: TestInheritanceParent
                    Base Resource: TestInheritanceParent
                    Child Resource: TestInheritance
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
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: testThroughTableChild
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
