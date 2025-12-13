Model name: DiscountInstance
                Resource Suffix: 
                    Relation: LineItemDiscountInstance_TO_DiscountInstance, Resource A: LineItemDiscountInstance, ResourceB: DiscountInstance, hasForward: , hasBackward: 
                Has Resource: DiscountInstance
                    Base Resource: DiscountInstance
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
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: lineItemDiscountInstance
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
