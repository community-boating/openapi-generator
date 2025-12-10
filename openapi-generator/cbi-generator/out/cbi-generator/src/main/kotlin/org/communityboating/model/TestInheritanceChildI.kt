            TestInheritanceParent
            TestInheritanceParentOther
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
            Default Value: null
                    COL INFO
        Variable Name: parentValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: parentOtherValue
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
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
