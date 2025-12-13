Model name: ItemTax
                Resource Suffix: 
                    Relation: ItemTax_TO_Item, Resource A: ItemTax, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: ItemTax_TO_Tax, Resource A: ItemTax, ResourceB: Tax, hasForward: , hasBackward: 
                Has Resource: ItemTax
                    Base Resource: ItemTax
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
                        Base Name: ItemTax_TO_Item
                        Name: ItemTax_TO_Item
                        Resource A: ItemTax
                        Resource B: Item
                        Forward ref: 
                            Column Name: itemId
                            Column Type: Item
                            Is Array: false
                        Back ref: 
                            Column Name: itemTax
                            Column Type: ItemTax
                            Is Array: false
        Variable Name: taxId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemTax_TO_Tax
                        Name: ItemTax_TO_Tax
                        Resource A: ItemTax
                        Resource B: Tax
                        Forward ref: 
                            Column Name: taxId
                            Column Type: Tax
                            Is Array: false
                        Back ref: 
                            Column Name: itemTax
                            Column Type: ItemTax
                            Is Array: false
