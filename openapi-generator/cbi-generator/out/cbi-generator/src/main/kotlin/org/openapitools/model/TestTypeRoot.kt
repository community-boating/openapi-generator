Model name: TestTypeRoot
                    SCHEMA
    Variables:
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: optionalStringDTO
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: requiredString
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: child
            Is Required: false
            Is Read Only: true
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
        Variable Name: childMultiple
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    Relation:
                        Name: TestTypeChildMultiple_TO_TestTypeRoot
                        Resource A: TestTypeChildMultiple
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childMultiple
                            Column Type: TestTypeChildMultiple
                            Is Array: true
        Variable Name: childrenThroughTable
            Is Required: false
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: 
                    Relation:
                        Name: TestThroughTableChild_TO_TestTypeRoot
                        Resource A: TestThroughTableChild
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: forwardRef
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChild
                            Is Array: true
