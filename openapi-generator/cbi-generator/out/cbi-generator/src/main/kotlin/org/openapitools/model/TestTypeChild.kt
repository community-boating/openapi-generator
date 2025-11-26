Model name: TestTypeChild
                    SCHEMA
    Variables:
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: parentId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    Relation:
                        Name: TestTypeRoot_TO_TestTypeChild
                        Resource A: TestTypeRoot
                        Resource B: TestTypeChild
                        Forward ref: 
                            Column Name: child
                            Column Type: TestTypeChild
                            Is Array: false
                        Back ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
