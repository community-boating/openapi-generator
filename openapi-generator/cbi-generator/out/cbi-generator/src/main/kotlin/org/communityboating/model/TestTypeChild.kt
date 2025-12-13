Model name: TestTypeChild
                Resource Suffix: 
                    Relation: TestTypeChild_TO_TestTypeRoot, Resource A: TestTypeRoot, ResourceB: TestTypeChild, hasForward: true, hasBackward: true
                Has Resource: TestTypeChild
                    Base Resource: TestTypeChild
                    Child Resource: TestTypeChild
                MODEL META
                    hasDTO: false
                    hasDAO: true
                    hasTable: true
                    hasInterface: true
                    isResource: true
                    isBase: true

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: id
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: parentId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: TestTypeChild_TO_TestTypeRoot
                        Type: ONE_TO_ONE
                        Base Name: TestTypeChild_TO_TestTypeRoot
                        Name: TestTypeChild_TO_TestTypeRoot
                        Resource A: TestTypeRoot
                        Resource B: TestTypeChild
                        Forward ref: 
                            Column Name: testTypeRoot
                            Column Type: TestTypeChild
                            Is Array: false
                        Back ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
