            TestInheritanceChildI
Model name: TestInheritanceChild
                Resource Suffix: 
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChildSub, ResourceB: TestInheritanceChild, hasForward: false, hasBackward: false
                    Relation: TestThroughTableChild_TO_TestInheritanceParent, Resource A: TestThroughTableChild, ResourceB: TestInheritanceChild, hasForward: false, hasBackward: true
                Has Resource: TestInheritance
                    Parent Resource: TestInheritance
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
        Variable Name: id
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: parentOtherValue
            Is Required: false
            Is Read Only: false
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
                            Super Relation: TestThroughTableChild_TO_TestInheritanceParent
                        Type: ONE_TO_ONE
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChild_TO_TestInheritanceParent
                        Resource A: TestThroughTableChild
                        Resource B: TestInheritance
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceChild
                            Is Array: false
                        Back ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestThroughTableChild
                            Is Array: false
