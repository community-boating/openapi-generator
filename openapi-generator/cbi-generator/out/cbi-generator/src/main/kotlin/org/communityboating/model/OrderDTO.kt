            OrderNewInterface
Model name: OrderDTO
                Resource Suffix: 
                    Relation: OrderNew_TO_Person, Resource A: OrderDTO, ResourceB: Person, hasForward: , hasBackward: false
                    Relation: orderLineItems, Resource A: LineItemDTO, ResourceB: OrderDTO, hasForward: true, hasBackward: true
                    Relation: orderLineItems, Resource A: LineItem, ResourceB: OrderDTO, hasForward: false, hasBackward: false
                    Relation: OrderPayment_TO_OrderNew, Resource A: OrderPayment, ResourceB: OrderDTO, hasForward: false, hasBackward: 
                    Relation: OrderTax_TO_OrderNew, Resource A: OrderTax, ResourceB: OrderDTO, hasForward: false, hasBackward: 
                Has Resource: Order
                    Parent Resource: OrderNew
                MODEL META
                    hasDTO: true
                    hasDAO: false
                    hasTable: false
                    hasInterface: true
                    isResource: true
                    isBase: false

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: amountServiceChangeCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountBaseCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountDiscountsCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountTaxesCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountTotalCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountPendingCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountRefundedCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountToRefundCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountToPayCents
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: amountPaidCents
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
        Variable Name: orderSource
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: itemCount
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: version
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: orderStatus
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: personId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: OrderNew_TO_Person
                        Type: ONE_TO_ONE
                        Base Name: OrderNew_TO_Person
                        Name: OrderNew_TO_Person
                        Resource A: Order
                        Resource B: Person
                        Forward ref: 
                            Column Name: personId
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: orderNew
                            Column Type: OrderDTO
                            Is Array: false
        Variable Name: deleted
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: lineItems
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: orderLineItems
                        Type: ONE_TO_MANY
                        Base Name: orderLineItems
                        Name: orderLineItems
                        Resource A: LineItem
                        Resource B: Order
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItems
                            Column Type: LineItemDTO
                            Is Array: true
        Variable Name: orderPayment
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: OrderPayment_TO_OrderNew
                        Type: ONE_TO_ONE
                        Base Name: OrderPayment_TO_OrderNew
                        Name: OrderPayment_TO_OrderNew
                        Resource A: OrderPayment
                        Resource B: Order
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderDTO
                            Is Array: false
                        Back ref: 
                            Column Name: orderPayment
                            Column Type: OrderPayment
                            Is Array: false
        Variable Name: orderTax
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Super Relation: OrderTax_TO_OrderNew
                        Type: ONE_TO_ONE
                        Base Name: OrderTax_TO_OrderNew
                        Name: OrderTax_TO_OrderNew
                        Resource A: OrderTax
                        Resource B: Order
                        Forward ref: 
                            Column Name: order
                            Column Type: OrderDTO
                            Is Array: false
                        Back ref: 
                            Column Name: orderTax
                            Column Type: OrderTax
                            Is Array: false
