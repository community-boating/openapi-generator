            TestThroughTableChild
Model name: TestThroughTableChildSub
                Has Resource: TestThroughTableChildSub
                    Base Resource: TestThroughTableChild
                    Relation Name: 
                    Parent Resource: TestThroughTableChild
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
        Variable Name: testChild
            Is Required: false
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
            Default Value: 
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
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
                            Super Relation: TestThroughTableChild_TO_TestTypeRoot
                        Type: ONE_TO_MANY
                        Base Name: TestThroughTableChild_TO_TestTypeRoot
                        Name: TestThroughTableChildSub_TO_TestTypeRoot
                        Resource A: TestThroughTableChildSub
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChildSub
                            Is Array: true
