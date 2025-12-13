Model name: LineItemDiscountInstance
                Resource Suffix: 
                    Relation: LineItemDiscountInstance_TO_LineItem, Resource A: LineItemDiscountInstance, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: LineItemDiscountInstance_TO_DiscountInstance, Resource A: LineItemDiscountInstance, ResourceB: DiscountInstance, hasForward: , hasBackward: 
                    Relation: LineItemDiscountInstance_TO_LineItem, Resource A: LineItemDiscountInstance, ResourceB: LineItemDTO, hasForward: false, hasBackward: 
                Has Resource: LineItemDiscountInstance
                    Base Resource: LineItemDiscountInstance
                MODEL META
                    hasDTO: false
                    hasDAO: true
                    hasTable: true
                    hasInterface: true
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
        Variable Name: lineItemId
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
        Variable Name: discountInstanceId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: LineItemDiscountInstance_TO_DiscountInstance
                        Name: LineItemDiscountInstance_TO_DiscountInstance
                        Resource A: LineItemDiscountInstance
                        Resource B: DiscountInstance
                        Forward ref: 
                            Column Name: discountInstanceId
                            Column Type: DiscountInstance
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemDiscountInstance
                            Column Type: LineItemDiscountInstance
                            Is Array: false
        Variable Name: isApplied
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: discountType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: specifiedCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: specifiedPercent
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: amountBaseCents
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
        Variable Name: universalCode
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
