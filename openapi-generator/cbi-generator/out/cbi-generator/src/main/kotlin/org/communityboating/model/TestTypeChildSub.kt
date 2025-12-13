            TestTypeChildInterface
Model name: TestTypeChildSub
                Resource Suffix: 
                    Relation: TestTypeChild_TO_TestTypeRoot, Resource A: TestTypeRoot, ResourceB: TestTypeChildSub, hasForward: false, hasBackward: true
                Has Resource: TestTypeChild
                    Parent Resource: TestTypeChild
                MODEL META
                    hasDTO: false
                    hasDAO: false
                    hasTable: false
                    hasInterface: true
                    isResource: true
                    isBase: false

                    varsIncluded: 
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
            Default Value: null
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: parentId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: TestTypeChild_TO_TestTypeRoot
                        Type: ONE_TO_ONE
                        Base Name: TestTypeChild_TO_TestTypeRoot
                        Name: TestTypeChild_TO_TestTypeRoot
                        Resource A: TestTypeRoot
                        Resource B: TestTypeChild
                        Forward ref: 
                            Column Name: testTypeRoot
                            Column Type: TestTypeChildSub
                            Is Array: false
                        Back ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
