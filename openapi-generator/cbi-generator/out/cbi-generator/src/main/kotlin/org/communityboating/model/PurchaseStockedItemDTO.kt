            Purchasable
Model name: PurchaseStockedItemDTO
                Has Resource: PurchaseStockedItemDTO
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
        Variable Name: assignId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: itemInstanceId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: quantity
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: stockChangeType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: purchasableState
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: itemType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: true
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: lineItem
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItemDTO_TO_PurchaseStockedItemDTO
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PurchaseStockedItemDTO
                        Name: LineItem_TO_PurchaseStockedItemDTO
                        Resource A: LineItem
                        Resource B: PurchaseStockedItemDTO
                        Forward ref: 
                            Column Name: purchaseStockedItemDTO
                            Column Type: PurchaseStockedItemDTO
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
