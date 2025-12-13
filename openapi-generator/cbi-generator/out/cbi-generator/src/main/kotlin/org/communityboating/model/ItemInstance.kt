Model name: ItemInstance
                Resource Suffix: 
                    Relation: ItemInstance_TO_Item, Resource A: ItemInstance, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: ItemInstanceStockChange_TO_ItemInstance, Resource A: ItemInstanceStockChange, ResourceB: ItemInstance, hasForward: , hasBackward: 
                    Relation: LineItem_TO_ItemInstance, Resource A: LineItem, ResourceB: ItemInstance, hasForward: , hasBackward: true
                    Relation: LineItem_TO_ItemInstance, Resource A: LineItemDTO, ResourceB: ItemInstance, hasForward: , hasBackward: false
                Has Resource: ItemInstance
                    Base Resource: ItemInstance
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
                        Base Name: ItemInstance_TO_Item
                        Name: ItemInstance_TO_Item
                        Resource A: ItemInstance
                        Resource B: Item
                        Forward ref: 
                            Column Name: itemId
                            Column Type: Item
                            Is Array: false
                        Back ref: 
                            Column Name: itemInstance
                            Column Type: ItemInstance
                            Is Array: false
        Variable Name: priceCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
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
        Variable Name: itemInstanceStockChange
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemInstanceStockChange_TO_ItemInstance
                        Name: ItemInstanceStockChange_TO_ItemInstance
                        Resource A: ItemInstanceStockChange
                        Resource B: ItemInstance
                        Forward ref: 
                            Column Name: itemInstanceId
                            Column Type: ItemInstance
                            Is Array: false
                        Back ref: 
                            Column Name: itemInstanceStockChange
                            Column Type: ItemInstanceStockChange
                            Is Array: false
        Variable Name: lineItem
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: LineItem_TO_ItemInstance
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_ItemInstance
                        Name: LineItem_TO_ItemInstance
                        Resource A: LineItem
                        Resource B: ItemInstance
                        Forward ref: 
                            Column Name: itemInstanceId
                            Column Type: ItemInstance
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
