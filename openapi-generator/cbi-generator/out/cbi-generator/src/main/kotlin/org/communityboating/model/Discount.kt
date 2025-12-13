Model name: Discount
                Resource Suffix: 
                    Relation: DiscountCategory_TO_Discount, Resource A: DiscountCategory, ResourceB: Discount, hasForward: , hasBackward: 
                    Relation: ItemDiscount_TO_Discount, Resource A: ItemDiscount, ResourceB: Discount, hasForward: , hasBackward: 
                Has Resource: Discount
                    Base Resource: Discount
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
        Variable Name: discountCategory
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: DiscountCategory_TO_Discount
                        Name: DiscountCategory_TO_Discount
                        Resource A: DiscountCategory
                        Resource B: Discount
                        Forward ref: 
                            Column Name: discountId
                            Column Type: Discount
                            Is Array: false
                        Back ref: 
                            Column Name: discountCategory
                            Column Type: DiscountCategory
                            Is Array: false
        Variable Name: itemDiscount
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemDiscount_TO_Discount
                        Name: ItemDiscount_TO_Discount
                        Resource A: ItemDiscount
                        Resource B: Discount
                        Forward ref: 
                            Column Name: discountId
                            Column Type: Discount
                            Is Array: false
                        Back ref: 
                            Column Name: itemDiscount
                            Column Type: ItemDiscount
                            Is Array: false
