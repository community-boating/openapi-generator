            Purchasable
Model name: PurchaseGiftCardDTO
                Has Resource: PurchaseGiftCardDTO
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
        Variable Name: assignId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: personId
            Is Required: false
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: cardNum
            Is Required: false
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: isRecharge
            Is Required: false
            Is Read Only: false
            Is Write Only: true
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: balance
            Is Required: true
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
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
        Variable Name: balanceTransactionType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: transactionAmountCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: purchasableState
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: itemType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: lineItem
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseGiftCardDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseGiftCardDTO_TO_LineItem
                        Name: PurchaseGiftCardDTO_TO_LineItem
                        Resource A: PurchaseGiftCardDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseGiftCardDTO
                            Column Type: PurchaseGiftCardDTO
                            Is Array: false
