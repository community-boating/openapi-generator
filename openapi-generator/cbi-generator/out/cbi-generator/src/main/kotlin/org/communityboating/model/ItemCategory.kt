Model name: ItemCategory
                Has Resource: ItemCategory
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
        Variable Name: item
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemCategory_TO_Item
                        Name: ItemCategory_TO_Item
                        Resource A: ItemCategory
                        Resource B: Item
                        Forward ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
                        Back ref: 
                            Column Name: itemCategory
                            Column Type: ItemCategory
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
