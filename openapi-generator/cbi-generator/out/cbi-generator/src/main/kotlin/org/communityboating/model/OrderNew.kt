Model name: OrderNew
                Has Resource: OrderNew
                    Relation Name: 
                    Child Resource: OrderDTO
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
        Variable Name: orderSource
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountBaseCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountDiscountsCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountTaxesCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountTotalCents
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
        Variable Name: itemCount
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: version
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: orderStatus
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: personId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: OrderDTO_TO_Person
                        Type: ONE_TO_ONE
                        Base Name: OrderNew_TO_Person
                        Name: OrderNew_TO_Person
                        Resource A: OrderNew
                        Resource B: Person
                        Forward ref: 
                            Column Name: personId
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: orderNew
                            Column Type: OrderNew
                            Is Array: false
        Variable Name: deleted
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: lineItems
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
        Variable Name: orderPayment
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: OrderPayment_TO_OrderDTO
                        Type: ONE_TO_ONE
                        Base Name: OrderPayment_TO_OrderNew
                        Name: OrderPayment_TO_OrderNew
                        Resource A: OrderPayment
                        Resource B: OrderNew
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderNew
                            Is Array: false
                        Back ref: 
                            Column Name: orderPayment
                            Column Type: OrderPayment
                            Is Array: false
        Variable Name: orderTax
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: OrderTax_TO_OrderDTO
                        Type: ONE_TO_ONE
                        Base Name: OrderTax_TO_OrderNew
                        Name: OrderTax_TO_OrderNew
                        Resource A: OrderTax
                        Resource B: OrderNew
                        Forward ref: 
                            Column Name: order
                            Column Type: OrderNew
                            Is Array: false
                        Back ref: 
                            Column Name: orderTax
                            Column Type: OrderTax
                            Is Array: false
