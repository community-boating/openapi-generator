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
            Default Value: null
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: testThroughTableChild
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: TestThroughTableChildSub_TO_TestInheritanceChild
                            Sub Relation: TestThroughTableChildSub_TO_TestInheritanceParent
                            Sub Relation: TestThroughTableChildSub_TO_TestInheritanceChildI
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceChildI
                            Sub Relation: TestThroughTableChild_TO_TestInheritanceChild
                        Type: ONE_TO_ONE
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChild_TO_TestInheritanceParent
                        Resource A: TestThroughTableChild
                        Resource B: TestInheritanceParent
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceParent
                            Is Array: false
                        Back ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestThroughTableChild
                            Is Array: false
