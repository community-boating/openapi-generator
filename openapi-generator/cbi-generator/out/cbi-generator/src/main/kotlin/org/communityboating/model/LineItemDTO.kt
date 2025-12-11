            LineItem
Model name: LineItemDTO
                Has Resource: LineItemDTO
                    Base Resource: LineItem
                    Relation Name: 
                    Parent Resource: LineItem
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
        Variable Name: classSignup
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseClassSignupDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseClassSignupDTO_TO_LineItem
                        Name: PurchaseClassSignupDTO_TO_LineItemDTO
                        Resource A: PurchaseClassSignupDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: classSignup
                            Column Type: PurchaseClassSignupDTO
                            Is Array: false
        Variable Name: membership
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseMembershipDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseMembershipDTO_TO_LineItem
                        Name: PurchaseMembershipDTO_TO_LineItemDTO
                        Resource A: PurchaseMembershipDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: membership
                            Column Type: PurchaseMembershipDTO
                            Is Array: false
        Variable Name: donation
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseDonationDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseDonationDTO_TO_LineItem
                        Name: PurchaseDonationDTO_TO_LineItemDTO
                        Resource A: PurchaseDonationDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: donation
                            Column Type: PurchaseDonationDTO
                            Is Array: false
        Variable Name: card
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseCardDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseCardDTO_TO_LineItem
                        Name: PurchaseCardDTO_TO_LineItemDTO
                        Resource A: PurchaseCardDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: card
                            Column Type: PurchaseCardDTO
                            Is Array: false
        Variable Name: giftCard
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseGiftCardDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseGiftCardDTO_TO_LineItem
                        Name: PurchaseGiftCardDTO_TO_LineItemDTO
                        Resource A: PurchaseGiftCardDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: giftCard
                            Column Type: PurchaseGiftCardDTO
                            Is Array: false
        Variable Name: guestPrivs
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseGuestPrivilegesDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseGuestPrivilegesDTO_TO_LineItem
                        Name: PurchaseGuestPrivilegesDTO_TO_LineItemDTO
                        Resource A: PurchaseGuestPrivilegesDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: guestPrivs
                            Column Type: PurchaseGuestPrivilegesDTO
                            Is Array: false
        Variable Name: damageWaiver
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: PurchaseDamageWaiverDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseDamageWaiverDTO_TO_LineItem
                        Name: PurchaseDamageWaiverDTO_TO_LineItemDTO
                        Resource A: PurchaseDamageWaiverDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: damageWaiver
                            Column Type: PurchaseDamageWaiverDTO
                            Is Array: false
        Variable Name: stockChange
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItem_TO_PurchaseStockedItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PurchaseStockedItemDTO
                        Name: LineItemDTO_TO_PurchaseStockedItemDTO
                        Resource A: LineItemDTO
                        Resource B: PurchaseStockedItemDTO
                        Forward ref: 
                            Column Name: stockChange
                            Column Type: PurchaseStockedItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
        Variable Name: deleted
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: itemType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: referenceId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: parentItemId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItem_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_LineItem
                        Name: LineItemDTO_TO_LineItemDTO
                        Resource A: LineItemDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: parentItemId
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: LineItem_TO_LineItemBackwardRef
                            Column Type: LineItemDTO
                            Is Array: false
        Variable Name: orderId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: orderLineItems
                        Type: ONE_TO_MANY
                        Base Name: orderLineItems
                        Name: LineItemDTO_TO_OrderDTO
                        Resource A: LineItemDTO
                        Resource B: OrderDTO
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItems
                            Column Type: LineItemDTO
                            Is Array: true
        Variable Name: itemInstanceId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItem_TO_ItemInstance
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_ItemInstance
                        Name: LineItemDTO_TO_ItemInstance
                        Resource A: LineItemDTO
                        Resource B: ItemInstance
                        Forward ref: 
                            Column Name: itemInstanceId
                            Column Type: ItemInstance
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
        Variable Name: subscriptionId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItem_TO_PersonSubscription
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PersonSubscription
                        Name: LineItemDTO_TO_PersonSubscription
                        Resource A: LineItemDTO
                        Resource B: PersonSubscription
                        Forward ref: 
                            Column Name: subscriptionId
                            Column Type: PersonSubscription
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
        Variable Name: amountBaseCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountSpecifiedCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountPaidCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: balanceTransaction
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: BalanceTransaction_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: BalanceTransaction_TO_LineItem
                        Name: BalanceTransaction_TO_LineItemDTO
                        Resource A: BalanceTransaction
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItemId
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: balanceTransaction
                            Column Type: BalanceTransaction
                            Is Array: false
        Variable Name: itemInstanceStockChange
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: ItemInstanceStockChange_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: ItemInstanceStockChange_TO_LineItem
                        Name: ItemInstanceStockChange_TO_LineItemDTO
                        Resource A: ItemInstanceStockChange
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: itemInstanceStockChange
                            Column Type: ItemInstanceStockChange
                            Is Array: false
        Variable Name: LineItem_TO_LineItemBackwardRef
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItem_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_LineItem
                        Name: LineItemDTO_TO_LineItemDTO
                        Resource A: LineItemDTO
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: parentItemId
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: LineItem_TO_LineItemBackwardRef
                            Column Type: LineItemDTO
                            Is Array: false
        Variable Name: lineItemDiscountInstance
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItemDiscountInstance_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: LineItemDiscountInstance_TO_LineItem
                        Name: LineItemDiscountInstance_TO_LineItemDTO
                        Resource A: LineItemDiscountInstance
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItemId
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemDiscountInstance
                            Column Type: LineItemDiscountInstance
                            Is Array: false
        Variable Name: lineItemRefund
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: LineItemRefund_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: LineItemRefund_TO_LineItem
                        Name: LineItemRefund_TO_LineItemDTO
                        Resource A: LineItemRefund
                        Resource B: LineItemDTO
                        Forward ref: 
                            Column Name: lineItemId
                            Column Type: LineItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemRefund
                            Column Type: LineItemRefund
                            Is Array: false
