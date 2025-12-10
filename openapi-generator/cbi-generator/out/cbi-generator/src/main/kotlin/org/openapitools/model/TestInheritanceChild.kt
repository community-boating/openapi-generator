            TestInheritanceChildI
Model name: TestInheritanceChild
                Has Resource: TestInheritanceChild
                    Base Resource: TestInheritanceParent
                    Relation Name: 
                    Parent Resource: TestInheritanceChildI
                MODEL META
                    hasDTO: true
                    hasDAO: true
                    hasTable: true
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
            Default Value: 
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: parentOtherValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: testThroughTableChild
            Is Required: false
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
                        Name: TestThroughTableChildSub_TO_TestInheritanceChild
                        Resource A: TestThroughTableChildSub
                        Resource B: TestInheritanceChild
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceChild
                            Is Array: false
                        Back ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestThroughTableChildSub
                            Is Array: false
