Model name: TestTypeChildMultiple
                    SCHEMA
    Variables:
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: testDTOOnly
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: testDAOOnly
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
        Variable Name: aString
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
