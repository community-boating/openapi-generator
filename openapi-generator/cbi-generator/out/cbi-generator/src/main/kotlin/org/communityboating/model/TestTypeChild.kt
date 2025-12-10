Model name: TestTypeChild
                Has Resource: TestTypeChild
                    Relation Name: 
                    Child Resource: TestTypeChildSub
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
                            Sub Relation: TestTypeRoot_TO_TestTypeChildSub
                            Sub Relation: TestTypeRoot_TO_TestTypeChildSub
                        Type: ONE_TO_ONE
                        Base Name: TestTypeRoot_TO_TestTypeChild
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
