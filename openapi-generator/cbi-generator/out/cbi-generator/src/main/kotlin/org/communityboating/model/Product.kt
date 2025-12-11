Model name: Product
                Has Resource: Product
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
        Variable Name: productName
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: productDescription
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: active
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
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
                        Base Name: Item_TO_Product
                        Name: Item_TO_Product
                        Resource A: Item
                        Resource B: Product
                        Forward ref: 
                            Column Name: productId
                            Column Type: Product
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
