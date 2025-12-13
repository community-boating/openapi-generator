Model name: TestTypeRoot
                Resource Suffix: 
                    Relation: TestTypeChild_TO_TestTypeRoot, Resource A: TestTypeRoot, ResourceB: TestTypeChild, hasForward: true, hasBackward: true
                    Relation: TestTypeChildMultiple_TO_TestTypeRoot, Resource A: TestTypeChildMultiple, ResourceB: TestTypeRoot, hasForward: , hasBackward: 
                    Relation: TestTypeRoot_TO_TestTypeChildMultiple, Resource A: TestTypeChildMultiple, ResourceB: TestTypeRoot, hasForward: , hasBackward: 
                    Relation: TestTypeRoot_TO_TestThroughTableChild, Resource A: TestThroughTableChild, ResourceB: TestTypeRoot, hasForward: , hasBackward: true
                    Relation: TestTypeChild_TO_TestTypeRoot, Resource A: TestTypeRoot, ResourceB: TestTypeChildSub, hasForward: false, hasBackward: true
                    Relation: TestTypeRoot_TO_TestThroughTableChild, Resource A: TestThroughTableChildSub, ResourceB: TestTypeRoot, hasForward: , hasBackward: false
                Has Resource: TestTypeRoot
                    Base Resource: TestTypeRoot
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
        Variable Name: testTypeRoot
            Is Required: true
            Is Read Only: true
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
        Variable Name: childMultiple
            Is Required: true
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_MANY
                        Base Name: TestTypeRoot_TO_TestTypeChildMultiple
                        Name: TestTypeRoot_TO_TestTypeChildMultiple
                        Resource A: TestTypeChildMultiple
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: testTypeChildMultiple
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childMultiple
                            Column Type: TestTypeChildMultiple
                            Is Array: true
        Variable Name: childrenThroughTable
            Is Required: true
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: TestTypeRoot_TO_TestThroughTableChild
                        Type: ONE_TO_MANY
                        Base Name: TestTypeRoot_TO_TestThroughTableChild
                        Name: TestTypeRoot_TO_TestThroughTableChild
                        Resource A: TestThroughTableChild
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChild
                            Is Array: true
        Variable Name: testTypeChildMultiple
            Is Required: true
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
                            Column Name: testTypeChildMultiple
                            Column Type: TestTypeChildMultiple
                            Is Array: false
