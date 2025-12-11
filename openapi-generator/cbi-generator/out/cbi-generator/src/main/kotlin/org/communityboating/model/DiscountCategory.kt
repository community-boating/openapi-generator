Model name: DiscountCategory
                Has Resource: DiscountCategory
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
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: discountId
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
        Variable Name: categoryId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: DiscountCategory_TO_Category
                        Name: DiscountCategory_TO_Category
                        Resource A: DiscountCategory
                        Resource B: Category
                        Forward ref: 
                            Column Name: categoryId
                            Column Type: Category
                            Is Array: false
                        Back ref: 
                            Column Name: discountCategory
                            Column Type: DiscountCategory
                            Is Array: false
