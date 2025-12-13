Model name: Category
                Resource Suffix: 
                    Relation: Category_TO_Catalog, Resource A: Category, ResourceB: Catalog, hasForward: , hasBackward: 
                    Relation: DiscountCategory_TO_Category, Resource A: DiscountCategory, ResourceB: Category, hasForward: , hasBackward: 
                    Relation: ItemCategory_TO_Category, Resource A: ItemCategory, ResourceB: Category, hasForward: , hasBackward: 
                Has Resource: Category
                    Base Resource: Category
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
        Variable Name: categoryName
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: description
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: categoryType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: catalogId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Category_TO_Catalog
                        Name: Category_TO_Catalog
                        Resource A: Category
                        Resource B: Catalog
                        Forward ref: 
                            Column Name: catalogId
                            Column Type: Catalog
                            Is Array: false
                        Back ref: 
                            Column Name: category
                            Column Type: Category
                            Is Array: false
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
        Variable Name: itemCategory
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemCategory_TO_Category
                        Name: ItemCategory_TO_Category
                        Resource A: ItemCategory
                        Resource B: Category
                        Forward ref: 
                            Column Name: categoryId
                            Column Type: Category
                            Is Array: false
                        Back ref: 
                            Column Name: itemCategory
                            Column Type: ItemCategory
                            Is Array: false
