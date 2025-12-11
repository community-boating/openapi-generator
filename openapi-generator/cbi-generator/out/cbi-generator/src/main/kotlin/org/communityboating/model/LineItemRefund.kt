Model name: LineItemRefund
                Has Resource: LineItemRefund
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
        Variable Name: stockChangeId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: LineItemRefund_TO_ItemInstanceStockChange
                        Name: LineItemRefund_TO_ItemInstanceStockChange
                        Resource A: LineItemRefund
                        Resource B: ItemInstanceStockChange
                        Forward ref: 
                            Column Name: stockChangeId
                            Column Type: ItemInstanceStockChange
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemRefund
                            Column Type: LineItemRefund
                            Is Array: false
        Variable Name: amountToRefundUnitCents
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
        Variable Name: refundQuantity
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: returnStock
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: revokeAfter
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: revokeDuring
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: lineItemRefundTax
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: LineItemRefundTax_TO_LineItemRefund
                        Name: LineItemRefundTax_TO_LineItemRefund
                        Resource A: LineItemRefundTax
                        Resource B: LineItemRefund
                        Forward ref: 
                            Column Name: lineItemRefundId
                            Column Type: LineItemRefund
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemRefundTax
                            Column Type: LineItemRefundTax
                            Is Array: false
