Model name: CashDrawer
                Resource Suffix: 
                    Relation: CashTransaction_TO_CashDrawer, Resource A: CashTransaction, ResourceB: CashDrawer, hasForward: true, hasBackward: true
                Has Resource: CashDrawer
                    Base Resource: CashDrawer
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
        Variable Name: cashDrawerId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: cashTransactions
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_MANY
                        Base Name: CashTransaction_TO_CashDrawer
                        Name: CashTransaction_TO_CashDrawer
                        Resource A: CashTransaction
                        Resource B: CashDrawer
                        Forward ref: 
                            Column Name: cashDrawer
                            Column Type: CashDrawer
                            Is Array: false
                        Back ref: 
                            Column Name: cashTransactions
                            Column Type: CashTransaction
                            Is Array: true
