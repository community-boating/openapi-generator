            OrderNew
Model name: OrderDTO
                Has Resource: OrderDTO
                    Base Resource: OrderNew
                    Relation Name: 
                    Parent Resource: OrderNew
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
                        Name: OrderDTO_TO_Person
                        Resource A: OrderDTO
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
                        Name: LineItem_TO_OrderDTO
                        Resource A: LineItem
                        Resource B: OrderDTO
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItems
                            Column Type: LineItem
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
                        Name: OrderPayment_TO_OrderDTO
                        Resource A: OrderPayment
                        Resource B: OrderDTO
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
                        Name: OrderTax_TO_OrderDTO
                        Resource A: OrderTax
                        Resource B: OrderDTO
                        Forward ref: 
                            Column Name: order
                            Column Type: OrderDTO
                            Is Array: false
                        Back ref: 
                            Column Name: orderTax
                            Column Type: OrderTax
                            Is Array: false
