Model name: Tax
                Resource Suffix: 
                    Relation: ItemTax_TO_Tax, Resource A: ItemTax, ResourceB: Tax, hasForward: , hasBackward: 
                    Relation: OrderTax_TO_Tax, Resource A: OrderTax, ResourceB: Tax, hasForward: , hasBackward: 
                    Relation: Tax_TO_Catalog, Resource A: Tax, ResourceB: Catalog, hasForward: , hasBackward: 
                Has Resource: Tax
                    Base Resource: Tax
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
        Variable Name: taxName
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: taxCode
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: taxRate
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: taxMinValueCents
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: taxBeforeDiscount
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
        Variable Name: itemTax
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
        Variable Name: orderTax
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: OrderTax_TO_Tax
                        Name: OrderTax_TO_Tax
                        Resource A: OrderTax
                        Resource B: Tax
                        Forward ref: 
                            Column Name: taxId
                            Column Type: Tax
                            Is Array: false
                        Back ref: 
                            Column Name: orderTax
                            Column Type: OrderTax
                            Is Array: false
