Model name: Balance
                Resource Suffix: 
                    Relation: Balance_TO_Person, Resource A: Balance, ResourceB: Person, hasForward: , hasBackward: 
                    Relation: BalanceTransaction_TO_Balance, Resource A: BalanceTransaction, ResourceB: Balance, hasForward: , hasBackward: 
                    Relation: PaymentSource_TO_Balance, Resource A: PaymentSource, ResourceB: Balance, hasForward: , hasBackward: 
                    Relation: PurchaseGiftCardDTO_TO_Balance, Resource A: PurchaseGiftCardDTO, ResourceB: Balance, hasForward: , hasBackward: 
                Has Resource: Balance
                    Base Resource: Balance
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
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: balanceAccountNumber
            Is Required: false
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: balanceAccountToken
            Is Required: false
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: balanceType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: balanceOwner
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Balance_TO_Person
                        Name: Balance_TO_Person
                        Resource A: Balance
                        Resource B: Person
                        Forward ref: 
                            Column Name: balanceOwner
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: balance
                            Column Type: Balance
                            Is Array: false
        Variable Name: balanceTransaction
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
        Variable Name: paymentSource
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: PaymentSource_TO_Balance
                        Name: PaymentSource_TO_Balance
                        Resource A: PaymentSource
                        Resource B: Balance
                        Forward ref: 
                            Column Name: balanceSource
                            Column Type: Balance
                            Is Array: false
                        Back ref: 
                            Column Name: paymentSource
                            Column Type: PaymentSource
                            Is Array: false
        Variable Name: purchaseGiftCardDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: PurchaseGiftCardDTO_TO_Balance
                        Name: PurchaseGiftCardDTO_TO_Balance
                        Resource A: PurchaseGiftCardDTO
                        Resource B: Balance
                        Forward ref: 
                            Column Name: balance
                            Column Type: Balance
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseGiftCardDTO
                            Column Type: PurchaseGiftCardDTO
                            Is Array: false
