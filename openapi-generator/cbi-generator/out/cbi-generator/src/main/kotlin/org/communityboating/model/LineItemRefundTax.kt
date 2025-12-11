Model name: LineItemRefundTax
                Has Resource: LineItemRefundTax
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
        Variable Name: lineItemRefundId
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
        Variable Name: taxId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
