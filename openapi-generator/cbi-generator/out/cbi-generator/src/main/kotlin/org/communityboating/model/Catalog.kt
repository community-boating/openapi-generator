Model name: Catalog
                Resource Suffix: 
                    Relation: Category_TO_Catalog, Resource A: Category, ResourceB: Catalog, hasForward: , hasBackward: 
                    Relation: Item_TO_Catalog, Resource A: Item, ResourceB: Catalog, hasForward: , hasBackward: 
                    Relation: Product_TO_Catalog, Resource A: Product, ResourceB: Catalog, hasForward: , hasBackward: 
                    Relation: Tax_TO_Catalog, Resource A: Tax, ResourceB: Catalog, hasForward: , hasBackward: 
                Has Resource: Catalog
                    Base Resource: Catalog
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
        Variable Name: startActive
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: endActive
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: catalogName
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: category
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
                        Base Name: Item_TO_Catalog
                        Name: Item_TO_Catalog
                        Resource A: Item
                        Resource B: Catalog
                        Forward ref: 
                            Column Name: catalogId
                            Column Type: Catalog
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
        Variable Name: product
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Product_TO_Catalog
                        Name: Product_TO_Catalog
                        Resource A: Product
                        Resource B: Catalog
                        Forward ref: 
                            Column Name: catalogId
                            Column Type: Catalog
                            Is Array: false
                        Back ref: 
                            Column Name: product
                            Column Type: Product
                            Is Array: false
        Variable Name: tax
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Tax_TO_Catalog
                        Name: Tax_TO_Catalog
                        Resource A: Tax
                        Resource B: Catalog
                        Forward ref: 
                            Column Name: catalogId
                            Column Type: Catalog
                            Is Array: false
                        Back ref: 
                            Column Name: tax
                            Column Type: Tax
                            Is Array: false
