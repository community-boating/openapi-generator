            TestInheritanceChildAndTestInheritanceParent
            TestInheritanceChildIAndTestInheritanceParent
Model name: TestInheritanceParent
                Has Resource: TestInheritanceParent
                    Relation Name: 
                    Child Resource: TestInheritanceChildI
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
            Is Overridden: false
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
        Variable Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
                    Relation:
                            Sub Relation: TestThroughTableChildSub_TO_TestInheritanceChild
                            Sub Relation: TestThroughTableChildSub_TO_TestInheritanceParent
                            Sub Relation: TestThroughTableChildSub_TO_TestInheritanceChildI
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceChildI
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceChild
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChild_TO_TestInheritanceParent
                        Resource A: TestThroughTableChild
                        Resource B: TestInheritanceParent
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceParent
                            Is Array: false
                        Back ref: 
                            Column Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
                            Column Type: TestThroughTableChild
                            Is Array: false
