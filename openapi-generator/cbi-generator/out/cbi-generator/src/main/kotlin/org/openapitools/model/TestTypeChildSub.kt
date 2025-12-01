            TestTypeChild
Model name: TestTypeChildSub
                Has Resource:
                TestTypeChildSub
                MODEL META
                    hasDTO: true
                    hasDAO: true
                    hasTable: true
                    isResource: true
                    isBase: false

                    varsIncluded: 
                        id,

                        readOnlyString,

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
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: parentId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
                    Relation:
                        
                        Name: TestTypeRoot_TO_TestTypeChildSub
                        Resource A: TestTypeRoot
                        Resource B: TestTypeChildSub
                        Forward ref: 
                            Column Name: TestTypeRoot_TO_TestTypeChildSubForwardRef
                            Column Type: TestTypeChildSub
                            Is Array: false
                        Back ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
