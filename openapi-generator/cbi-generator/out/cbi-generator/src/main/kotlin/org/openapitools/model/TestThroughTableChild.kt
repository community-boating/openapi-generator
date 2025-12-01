Model name: TestThroughTableChild
                Has Resource:
                TestThroughTableChild
                MODEL META
                    hasDTO: true
                    hasDAO: true
                    hasTable: true
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
                    COL INFO
        Variable Name: derping
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
                    COL INFO
        Variable Name: testChild
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
                    Relation:
                        
                        Name: TestThroughTableChild_TO_TestInheritanceParent
                        Resource A: TestThroughTableChild
                        Resource B: TestInheritanceParent
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceParent
                            Is Array: false
                        Back ref: 
                            Column Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
                            Column Type: TestThroughTableChild
                            Is Array: false
        Variable Name: TestThroughTableChild_TO_TestTypeRootForwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
                    Relation:
                        
                        Name: TestThroughTableChild_TO_TestTypeRoot
                        Resource A: TestThroughTableChild
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: TestThroughTableChild_TO_TestTypeRootForwardRef
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChild
                            Is Array: true
