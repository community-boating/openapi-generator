Model name: OrderTax
                Has Resource: OrderTax
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
        Variable Name: taxId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: OrderTax_TO_Tax
                        Name: OrderTax_TO_Tax
                        Resource A: OrderTax
                        Resource B: Tax
                        Forward ref: 
                            Column Name: taxId
                            Column Type: Tax
                            Is Array: false
                        Back ref: 
                            Column Name: orderTax
                            Column Type: OrderTax
                            Is Array: false
        Variable Name: order
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
        Variable Name: amountRefundedCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountToRefundCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: taxRateUsed
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
