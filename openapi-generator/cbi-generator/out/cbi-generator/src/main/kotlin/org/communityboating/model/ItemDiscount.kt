Model name: ItemDiscount
                Resource Suffix: 
                    Relation: ItemDiscount_TO_Item, Resource A: ItemDiscount, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: ItemDiscount_TO_Discount, Resource A: ItemDiscount, ResourceB: Discount, hasForward: , hasBackward: 
                Has Resource: ItemDiscount
                    Base Resource: ItemDiscount
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
        Variable Name: itemId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemDiscount_TO_Item
                        Name: ItemDiscount_TO_Item
                        Resource A: ItemDiscount
                        Resource B: Item
                        Forward ref: 
                            Column Name: itemId
                            Column Type: Item
                            Is Array: false
                        Back ref: 
                            Column Name: itemDiscount
                            Column Type: ItemDiscount
                            Is Array: false
        Variable Name: requiresParentEligibility
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: discountType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: amountCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: percent
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
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
