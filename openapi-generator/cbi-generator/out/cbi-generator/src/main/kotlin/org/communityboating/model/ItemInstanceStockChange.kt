Model name: ItemInstanceStockChange
                Resource Suffix: 
                    Relation: ItemInstanceStockChange_TO_ItemInstance, Resource A: ItemInstanceStockChange, ResourceB: ItemInstance, hasForward: , hasBackward: 
                    Relation: ItemInstanceStockChange_TO_LineItem, Resource A: ItemInstanceStockChange, ResourceB: LineItem, hasForward: true, hasBackward: 
                    Relation: LineItemRefund_TO_ItemInstanceStockChange, Resource A: LineItemRefund, ResourceB: ItemInstanceStockChange, hasForward: , hasBackward: 
                    Relation: ItemInstanceStockChange_TO_LineItem, Resource A: ItemInstanceStockChange, ResourceB: LineItemDTO, hasForward: false, hasBackward: 
                Has Resource: ItemInstanceStockChange
                    Base Resource: ItemInstanceStockChange
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
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: itemInstanceId
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
                            Sub Relation: ItemInstanceStockChange_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: ItemInstanceStockChange_TO_LineItem
                        Name: ItemInstanceStockChange_TO_LineItem
                        Resource A: ItemInstanceStockChange
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: itemInstanceStockChange
                            Column Type: ItemInstanceStockChange
                            Is Array: false
        Variable Name: changeAmount
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: stockChangeType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: purchasableState
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: lineItemRefund
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: LineItemRefund_TO_ItemInstanceStockChange
                        Name: LineItemRefund_TO_ItemInstanceStockChange
                        Resource A: LineItemRefund
                        Resource B: ItemInstanceStockChange
                        Forward ref: 
                            Column Name: stockChangeId
                            Column Type: ItemInstanceStockChange
                            Is Array: false
                        Back ref: 
                            Column Name: lineItemRefund
                            Column Type: LineItemRefund
                            Is Array: false
