            LineItemDTOAndLineItem
Model name: LineItem
                Resource Suffix: 
                    Relation: BalanceTransaction_TO_LineItem, Resource A: BalanceTransaction, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: ItemInstanceStockChange_TO_LineItem, Resource A: ItemInstanceStockChange, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: LineItem_TO_LineItem, Resource A: LineItem, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: LineItem_TO_LineItem, Resource A: LineItem, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: orderLineItems, Resource A: LineItem, ResourceB: OrderNew, hasForward: true, hasBackward: true
                    Relation: LineItem_TO_ItemInstance, Resource A: LineItem, ResourceB: ItemInstance, hasForward: , hasBackward: true
                    Relation: LineItem_TO_PersonSubscription, Resource A: LineItem, ResourceB: PersonSubscription, hasForward: , hasBackward: true
                    Relation: LineItemDiscountInstance_TO_LineItem, Resource A: LineItemDiscountInstance, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: LineItemRefund_TO_LineItem, Resource A: LineItemRefund, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: PurchaseClassSignupDTO_TO_LineItem, Resource A: PurchaseClassSignupDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: PurchaseMembershipDTO_TO_LineItem, Resource A: PurchaseMembershipDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: PurchaseDonationDTO_TO_LineItem, Resource A: PurchaseDonationDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: PurchaseCardDTO_TO_LineItem, Resource A: PurchaseCardDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: PurchaseGiftCardDTO_TO_LineItem, Resource A: PurchaseGiftCardDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: PurchaseGuestPrivilegesDTO_TO_LineItem, Resource A: PurchaseGuestPrivilegesDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: PurchaseDamageWaiverDTO_TO_LineItem, Resource A: PurchaseDamageWaiverDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                    Relation: LineItem_TO_PurchaseStockedItemDTO, Resource A: LineItem, ResourceB: PurchaseStockedItemDTO, hasForward: , hasBackward: true
                    Relation: LineItem_TO_LineItem, Resource A: LineItemDTO, ResourceB: LineItem, hasForward: false, hasBackward: false
                    Relation: LineItem_TO_LineItem, Resource A: LineItem, ResourceB: LineItemDTO, hasForward: false, hasBackward: false
                    Relation: orderLineItems, Resource A: LineItem, ResourceB: OrderDTO, hasForward: false, hasBackward: false
                Has Resource: LineItem
                    Base Resource: LineItem
                MODEL META
                    hasDTO: false
                    hasDAO: true
                    hasTable: true
                    hasInterface: true
                    isResource: true
                    isBase: false

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: id
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
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
                            Sub Relation: LineItem_TO_LineItem
                            Sub Relation: LineItem_TO_LineItem
                            Sub Relation: LineItem_TO_LineItem
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
                            Sub Relation: orderLineItems
                            Sub Relation: orderLineItems
                            Sub Relation: orderLineItems
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
                            Sub Relation: LineItem_TO_ItemInstance
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
                            Sub Relation: LineItem_TO_PersonSubscription
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
        Variable Name: itemInstanceStockChange
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: ItemInstanceStockChange_TO_LineItem
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
                            Sub Relation: LineItem_TO_LineItem
                            Sub Relation: LineItem_TO_LineItem
                            Sub Relation: LineItem_TO_LineItem
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
                            Sub Relation: LineItemDiscountInstance_TO_LineItem
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
                            Sub Relation: LineItemRefund_TO_LineItem
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
        Variable Name: classSignup
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseClassSignupDTO_TO_LineItem
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
                            Column Name: classSignup
                            Column Type: PurchaseClassSignupDTO
                            Is Array: false
        Variable Name: membership
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseMembershipDTO_TO_LineItem
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
                            Column Name: membership
                            Column Type: PurchaseMembershipDTO
                            Is Array: false
        Variable Name: donation
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseDonationDTO_TO_LineItem
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
                            Column Name: donation
                            Column Type: PurchaseDonationDTO
                            Is Array: false
        Variable Name: card
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseCardDTO_TO_LineItem
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
                            Column Name: card
                            Column Type: PurchaseCardDTO
                            Is Array: false
        Variable Name: giftCard
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseGiftCardDTO_TO_LineItem
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
                            Column Name: giftCard
                            Column Type: PurchaseGiftCardDTO
                            Is Array: false
        Variable Name: guestPrivs
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseGuestPrivilegesDTO_TO_LineItem
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
                            Column Name: guestPrivs
                            Column Type: PurchaseGuestPrivilegesDTO
                            Is Array: false
        Variable Name: damageWaiver
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: PurchaseDamageWaiverDTO_TO_LineItem
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
                            Column Name: damageWaiver
                            Column Type: PurchaseDamageWaiverDTO
                            Is Array: false
        Variable Name: stockChange
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItem_TO_PurchaseStockedItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PurchaseStockedItemDTO
                        Name: LineItem_TO_PurchaseStockedItemDTO
                        Resource A: LineItem
                        Resource B: PurchaseStockedItemDTO
                        Forward ref: 
                            Column Name: stockChange
                            Column Type: PurchaseStockedItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
