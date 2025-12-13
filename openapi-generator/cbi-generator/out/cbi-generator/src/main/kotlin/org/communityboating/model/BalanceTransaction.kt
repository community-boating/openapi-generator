Model name: BalanceTransaction
                Resource Suffix: 
                    Relation: BalanceTransaction_TO_Balance, Resource A: BalanceTransaction, ResourceB: Balance, hasForward: , hasBackward: 
                    Relation: BalanceTransaction_TO_OrderPayment, Resource A: BalanceTransaction, ResourceB: OrderPayment, hasForward: , hasBackward: 
                    Relation: BalanceTransaction_TO_LineItem, Resource A: BalanceTransaction, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: BalanceTransaction_TO_LineItem, Resource A: BalanceTransaction, ResourceB: LineItemDTO, hasForward: false, hasBackward: 
                Has Resource: BalanceTransaction
                    Base Resource: BalanceTransaction
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
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: balanceId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: BalanceTransaction_TO_Balance
                        Name: BalanceTransaction_TO_Balance
                        Resource A: BalanceTransaction
                        Resource B: Balance
                        Forward ref: 
                            Column Name: balanceId
                            Column Type: Balance
                            Is Array: false
                        Back ref: 
                            Column Name: balanceTransaction
                            Column Type: BalanceTransaction
                            Is Array: false
        Variable Name: balanceTransactionType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
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
                        Base Name: BalanceTransaction_TO_OrderPayment
                        Name: BalanceTransaction_TO_OrderPayment
                        Resource A: BalanceTransaction
                        Resource B: OrderPayment
                        Forward ref: 
                            Column Name: paymentId
                            Column Type: OrderPayment
                            Is Array: false
                        Back ref: 
                            Column Name: balanceTransaction
                            Column Type: BalanceTransaction
                            Is Array: false
        Variable Name: transactionAmountCents
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: purchasableState
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: lineItemId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: BalanceTransaction_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: BalanceTransaction_TO_LineItem
                        Name: BalanceTransaction_TO_LineItem
                        Resource A: BalanceTransaction
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItemId
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: balanceTransaction
                            Column Type: BalanceTransaction
                            Is Array: false
