            TestThroughTableChild
            TestThroughTableChildSubAndTestThroughTableChild
Model name: TestThroughTableChildSub
                Has Resource: TestThroughTableChildSub
                    Base Resource: TestThroughTableChild
                    Relation Name: 
                    Parent Resource: TestThroughTableChild
                MODEL META
                    hasDTO: true
                    hasDAO: true
                    hasTable: true
                    isResource: true
                    isBase: false

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: testChild
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
                    Relation:
                            Super Relation: TestThroughTableChild_TO_TestInheritanceParent
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChildSub_TO_TestInheritanceChildI
                        Resource A: TestThroughTableChildSub
                        Resource B: TestInheritanceChildI
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceChildI
                            Is Array: false
                        Back ref: 
                            Column Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
                            Column Type: TestThroughTableChildSub
                            Is Array: false
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: derping
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
        Variable Name: TestThroughTableChild_TO_TestTypeRootForwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
                    COL INFO
                    Relation:
                            Super Relation: TestThroughTableChild_TO_TestTypeRoot
                        Base Name: TestThroughTableChild_TO_TestTypeRoot
                        Name: TestThroughTableChildSub_TO_TestTypeRoot
                        Resource A: TestThroughTableChildSub
                        Resource B: TestTypeRoot
                        Forward ref: 
                            Column Name: TestThroughTableChild_TO_TestTypeRootForwardRef
                            Column Type: TestTypeRoot
                            Is Array: false
                        Back ref: 
                            Column Name: childrenThroughTable
                            Column Type: TestThroughTableChildSub
                            Is Array: true
