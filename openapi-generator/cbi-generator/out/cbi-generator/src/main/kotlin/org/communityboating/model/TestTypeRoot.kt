Model name: TestTypeRoot
                Has Resource: TestTypeRoot
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
        Variable Name: optionalStringDTO
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: requiredString
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: child
            Is Required: true
            Is Read Only: true
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
        Variable Name: childMultiple
            Is Required: true
            Is Read Only: true
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
        Variable Name: childrenThroughTable
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: TestThroughTableChild_TO_TestTypeRoot
                        Type: ONE_TO_MANY
                        Base Name: TestThroughTableChild_TO_TestTypeRoot
                        Name: TestThroughTableChildSub_TO_TestTypeRoot
                        Resource A: TestThroughTableChildSub
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChildSub
                            Is Array: true
        Variable Name: testTypeRoot
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: TestTypeRoot_TO_TestTypeChild
                        Type: ONE_TO_ONE
                        Base Name: TestTypeRoot_TO_TestTypeChild
                        Name: TestTypeRoot_TO_TestTypeChildSub
                        Resource A: TestTypeRoot
                        Resource B: TestTypeChildSub
                        Forward ref: 
                            Column Name: testTypeRoot
                            Column Type: TestTypeChildSub
                            Is Array: false
                        Back ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
