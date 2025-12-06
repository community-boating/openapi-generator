            TestInheritanceParent
            TestInheritanceParentOther
            TestInheritanceChildIAndTestInheritanceParent
            TestInheritanceChildIAndTestInheritanceChild
Model name: TestInheritanceChildI
                Has Resource: TestInheritanceChildI
                    Base Resource: TestInheritanceParent
                    Relation Name: 
                    Parent Resource: TestInheritanceParent
                    Child Resource: TestInheritanceChild
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
        Variable Name: id
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: parentOtherValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
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
