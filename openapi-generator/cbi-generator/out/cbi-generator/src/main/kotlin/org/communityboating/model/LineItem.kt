Model name: LineItem
                Has Resource: LineItem
                    Relation Name: 
                    Child Resource: LineItemDTO
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
        Variable Name: itemType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: referenceId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: parentItemId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_LineItem
                            Sub Relation: LineItem_TO_LineItemDTO
                            Sub Relation: LineItemDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_LineItem
                        Name: LineItem_TO_LineItem
                        Resource A: LineItem
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: parentItemId
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: LineItem_TO_LineItemBackwardRef
                            Column Type: LineItem
                            Is Array: false
        Variable Name: orderId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_OrderNew
                            Sub Relation: LineItemDTO_TO_OrderDTO
                            Sub Relation: LineItem_TO_OrderDTO
                        Type: ONE_TO_MANY
                        Base Name: orderLineItems
                        Name: orderLineItems
                        Resource A: LineItem
                        Resource B: OrderNew
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderNew
                            Is Array: false
                        Back ref: 
                            Column Name: lineItems
                            Column Type: LineItem
                            Is Array: true
        Variable Name: itemInstanceId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_ItemInstance
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_ItemInstance
                        Name: LineItem_TO_ItemInstance
                        Resource A: LineItem
                        Resource B: ItemInstance
                        Forward ref: 
                            Column Name: itemInstanceId
                            Column Type: ItemInstance
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
        Variable Name: subscriptionId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_PersonSubscription
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PersonSubscription
                        Name: LineItem_TO_PersonSubscription
                        Resource A: LineItem
                        Resource B: PersonSubscription
                        Forward ref: 
                            Column Name: subscriptionId
                            Column Type: PersonSubscription
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
        Variable Name: amountBaseCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountSpecifiedCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountPaidCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: deleted
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: balanceTransaction
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: BalanceTransaction_TO_LineItemDTO
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
        Variable Name: itemInstanceStockChange
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: ItemInstanceStockChange_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: ItemInstanceStockChange_TO_LineItem
                        Name: ItemInstanceStockChange_TO_LineItem
                        Resource A: ItemInstanceStockChange
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: itemInstanceStockChange
                            Column Type: ItemInstanceStockChange
                            Is Array: false
        Variable Name: LineItem_TO_LineItemBackwardRef
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_LineItem
                            Sub Relation: LineItem_TO_LineItemDTO
                            Sub Relation: LineItemDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_LineItem
                        Name: LineItem_TO_LineItem
                        Resource A: LineItem
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: parentItemId
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: LineItem_TO_LineItemBackwardRef
                            Column Type: LineItem
                            Is Array: false
        Variable Name: lineItemDiscountInstance
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDiscountInstance_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItemDiscountInstance_TO_LineItem
                        Name: LineItemDiscountInstance_TO_LineItem
                        Resource A: LineItemDiscountInstance
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItemId
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemDiscountInstance
                            Column Type: LineItemDiscountInstance
                            Is Array: false
        Variable Name: lineItemRefund
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemRefund_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItemRefund_TO_LineItem
                        Name: LineItemRefund_TO_LineItem
                        Resource A: LineItemRefund
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItemId
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemRefund
                            Column Type: LineItemRefund
                            Is Array: false
        Variable Name: purchaseClassSignupDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseClassSignupDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseClassSignupDTO_TO_LineItem
                        Name: PurchaseClassSignupDTO_TO_LineItem
                        Resource A: PurchaseClassSignupDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseClassSignupDTO
                            Column Type: PurchaseClassSignupDTO
                            Is Array: false
        Variable Name: purchaseMembershipDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseMembershipDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseMembershipDTO_TO_LineItem
                        Name: PurchaseMembershipDTO_TO_LineItem
                        Resource A: PurchaseMembershipDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseMembershipDTO
                            Column Type: PurchaseMembershipDTO
                            Is Array: false
        Variable Name: purchaseDonationDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseDonationDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseDonationDTO_TO_LineItem
                        Name: PurchaseDonationDTO_TO_LineItem
                        Resource A: PurchaseDonationDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseDonationDTO
                            Column Type: PurchaseDonationDTO
                            Is Array: false
        Variable Name: purchaseCardDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseCardDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseCardDTO_TO_LineItem
                        Name: PurchaseCardDTO_TO_LineItem
                        Resource A: PurchaseCardDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseCardDTO
                            Column Type: PurchaseCardDTO
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
        Variable Name: purchaseGuestPrivilegesDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseGuestPrivilegesDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseGuestPrivilegesDTO_TO_LineItem
                        Name: PurchaseGuestPrivilegesDTO_TO_LineItem
                        Resource A: PurchaseGuestPrivilegesDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseGuestPrivilegesDTO
                            Column Type: PurchaseGuestPrivilegesDTO
                            Is Array: false
        Variable Name: purchaseDamageWaiverDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseDamageWaiverDTO_TO_LineItemDTO
                        Type: ONE_TO_ONE
                        Base Name: PurchaseDamageWaiverDTO_TO_LineItem
                        Name: PurchaseDamageWaiverDTO_TO_LineItem
                        Resource A: PurchaseDamageWaiverDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: purchaseDamageWaiverDTO
                            Column Type: PurchaseDamageWaiverDTO
                            Is Array: false
        Variable Name: purchaseStockedItemDTO
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_PurchaseStockedItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PurchaseStockedItemDTO
                        Name: LineItem_TO_PurchaseStockedItemDTO
                        Resource A: LineItem
                        Resource B: PurchaseStockedItemDTO
                        Forward ref: 
                            Column Name: purchaseStockedItemDTO
                            Column Type: PurchaseStockedItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
