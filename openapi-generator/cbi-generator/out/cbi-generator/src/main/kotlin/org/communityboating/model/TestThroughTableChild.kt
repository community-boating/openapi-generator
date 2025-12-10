Model name: TestThroughTableChild
                Has Resource: TestThroughTableChild
                    Relation Name: 
                    Child Resource: TestThroughTableChildSub
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
        Variable Name: derping
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
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
                            Sub Relation: TestThroughTableChildSub_TO_TestTypeRoot
                        Type: ONE_TO_MANY
                        Base Name: TestThroughTableChild_TO_TestTypeRoot
                        Name: TestThroughTableChild_TO_TestTypeRoot
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
        Variable Name: testChild
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: TestThroughTableChild_TO_TestInheritanceParent
                        Type: ONE_TO_ONE
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChild_TO_TestInheritanceChildI
                        Resource A: TestThroughTableChild
                        Resource B: TestInheritanceChildI
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceChildI
                            Is Array: false
                        Back ref: 
                            Column Name: testThroughTableChild
                            Column Type: TestThroughTableChild
                            Is Array: false
