            Purchasable
Model name: PurchaseDamageWaiverDTO
                Resource Suffix: 
                    Relation: PurchaseDamageWaiverDTO_TO_LineItem, Resource A: PurchaseDamageWaiverDTO, ResourceB: LineItemDTO, hasForward: false, hasBackward: true
                    Relation: PurchaseDamageWaiverDTO_TO_LineItem, Resource A: PurchaseDamageWaiverDTO, ResourceB: LineItem, hasForward: true, hasBackward: true
                Has Resource: PurchaseDamageWaiverDTO
                    Base Resource: PurchaseDamageWaiverDTO
                MODEL META
                    hasDTO: true
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
        Variable Name: waiverId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: 
                    COL INFO
        Variable Name: personId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: startDate
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
        Variable Name: voidCloseId
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
                            Sub Relation: PurchaseDamageWaiverDTO_TO_LineItem
                        Type: ONE_TO_ONE
                        Base Name: PurchaseDamageWaiverDTO_TO_LineItem
                        Name: PurchaseDamageWaiverDTO_TO_LineItem
                        Resource A: PurchaseDamageWaiverDTO
                        Resource B: LineItem
                        Forward ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
                        Back ref: 
                            Column Name: damageWaiver
                            Column Type: PurchaseDamageWaiverDTO
                            Is Array: false
