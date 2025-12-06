Model name: ChildAndParent
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
Model name: ChildIAndParent
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
Model name: ChildIAndChild
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
Model name: TestInheritanceChildAndTestInheritanceParent
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
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
                    COL INFO
                    Relation:
                            Super Relation: TestThroughTableChild_TO_TestInheritanceParent
                        Base Name: TestThroughTableChild_TO_TestInheritanceParent
                        Name: TestThroughTableChildSub_TO_TestInheritanceChild
                        Resource A: TestThroughTableChildSub
                        Resource B: TestInheritanceChild
                        Forward ref: 
                            Column Name: testChild
                            Column Type: TestInheritanceChild
                            Is Array: false
                        Back ref: 
                            Column Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
                            Column Type: TestThroughTableChildSub
                            Is Array: false
Model name: TestInheritanceChildIAndTestInheritanceParent
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
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: TestThroughTableChild_TO_TestInheritanceParentBackwardRef
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
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
Model name: TestInheritanceChildIAndTestInheritanceChild
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
            Is Inherited: false
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
Model name: TestThroughTableChildSubAndTestThroughTableChild
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
            Is Inherited: false
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
            Is Inherited: false
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
Model name: TestTypeChildSubAndTestTypeChild
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
        Variable Name: readOnlyString
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
        Variable Name: parentId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
                    COL INFO
                    Relation:
                            Super Relation: TestTypeRoot_TO_TestTypeChild
                        Base Name: TestTypeRoot_TO_TestTypeChild
                        Name: TestTypeRoot_TO_TestTypeChildSub
                        Resource A: TestTypeRoot
                        Resource B: TestTypeChildSub
                        Forward ref: 
                            Column Name: TestTypeRoot_TO_TestTypeChildForwardRef
                            Column Type: TestTypeChildSub
                            Is Array: false
                        Back ref: 
                            Column Name: parentId
                            Column Type: TestTypeRoot
                            Is Array: false
