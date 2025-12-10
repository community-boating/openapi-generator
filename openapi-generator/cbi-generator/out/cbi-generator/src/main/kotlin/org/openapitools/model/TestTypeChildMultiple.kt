Model name: TestTypeChildMultiple
                Has Resource: TestTypeChildMultiple
                    Relation Name: 
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
            Default Value: 
                    COL INFO
        Variable Name: testDTOOnly
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 100
                    COL INFO
        Variable Name: testDAOOnly
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 100
                    COL INFO
        Variable Name: aString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: parentId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: TestTypeChildMultiple_TO_TestTypeRoot
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
