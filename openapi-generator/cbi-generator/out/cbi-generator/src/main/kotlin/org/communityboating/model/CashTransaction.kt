Model name: CashTransaction
                Has Resource: CashTransaction
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
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: cashDrawerId
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
                            Column Name: cashDrawerId
                            Column Type: CashDrawer
                            Is Array: false
                        Back ref: 
                            Column Name: cashTransactions
                            Column Type: CashTransaction
                            Is Array: true
        Variable Name: transactionAmountCents
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: paymentId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: CashTransaction_TO_OrderPayment
                        Name: CashTransaction_TO_OrderPayment
                        Resource A: CashTransaction
                        Resource B: OrderPayment
                        Forward ref: 
                            Column Name: paymentId
                            Column Type: OrderPayment
                            Is Array: false
                        Back ref: 
                            Column Name: cashTransaction
                            Column Type: CashTransaction
                            Is Array: false
        Variable Name: cashDrawerChangeId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: CashTransaction_TO_CashDrawersChange
                        Name: CashTransaction_TO_CashDrawersChange
                        Resource A: CashTransaction
                        Resource B: CashDrawersChange
                        Forward ref: 
                            Column Name: cashDrawerChangeId
                            Column Type: CashDrawersChange
                            Is Array: false
                        Back ref: 
                            Column Name: cashTransaction
                            Column Type: CashTransaction
                            Is Array: false
