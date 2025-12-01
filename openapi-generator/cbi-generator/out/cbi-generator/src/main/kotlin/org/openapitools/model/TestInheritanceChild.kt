            TestInheritanceChildI
Model name: TestInheritanceChild
                Has Resource:
                TestInheritanceChild
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
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: parentOtherValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: TestThroughTableChildSub_TO_TestInheritanceChildBackwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
                    Relation:
                        
                        Name: TestThroughTableChildSub_TO_TestInheritanceChild
                        Resource A: TestThroughTableChildSub
                        Resource B: TestInheritanceChild
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceChild
                            Is Array: false
                        Back ref: 
                            Column Name: TestThroughTableChildSub_TO_TestInheritanceChildBackwardRef
                            Column Type: TestThroughTableChildSub
                            Is Array: false
