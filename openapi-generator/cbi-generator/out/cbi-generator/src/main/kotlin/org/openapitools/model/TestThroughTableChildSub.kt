            TestThroughTableChild
Model name: TestThroughTableChildSub
                Has Resource:
                TestThroughTableChildSub
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
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: derping
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
