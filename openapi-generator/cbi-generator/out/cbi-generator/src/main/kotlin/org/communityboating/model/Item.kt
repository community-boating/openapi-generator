Model name: Item
                Resource Suffix: 
                    Relation: Item_TO_ApClassType, Resource A: Item, ResourceB: ApClassType, hasForward: , hasBackward: 
                    Relation: Item_TO_ApClassInstance, Resource A: Item, ResourceB: ApClassInstance, hasForward: , hasBackward: 
                    Relation: Item_TO_MembershipType, Resource A: Item, ResourceB: MembershipType, hasForward: , hasBackward: 
                    Relation: Item_TO_Product, Resource A: Item, ResourceB: Product, hasForward: , hasBackward: 
                    Relation: Item_TO_Catalog, Resource A: Item, ResourceB: Catalog, hasForward: , hasBackward: 
                    Relation: ItemCategory_TO_Item, Resource A: ItemCategory, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: ItemDiscount_TO_Item, Resource A: ItemDiscount, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: ItemInstance_TO_Item, Resource A: ItemInstance, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: ItemTax_TO_Item, Resource A: ItemTax, ResourceB: Item, hasForward: , hasBackward: 
                    Relation: SubscriptionItem_TO_Item, Resource A: SubscriptionItem, ResourceB: Item, hasForward: , hasBackward: 
                Has Resource: Item
                    Base Resource: Item
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
        Variable Name: itemType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
            Default Value: null
                    COL INFO
        Variable Name: classTypeId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Item_TO_ApClassType
                        Name: Item_TO_ApClassType
                        Resource A: Item
                        Resource B: ApClassType
                        Forward ref: 
                            Column Name: classTypeId
                            Column Type: ApClassType
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
        Variable Name: classInstanceId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Item_TO_ApClassInstance
                        Name: Item_TO_ApClassInstance
                        Resource A: Item
                        Resource B: ApClassInstance
                        Forward ref: 
                            Column Name: classInstanceId
                            Column Type: ApClassInstance
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
        Variable Name: membershipTypeId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Item_TO_MembershipType
                        Name: Item_TO_MembershipType
                        Resource A: Item
                        Resource B: MembershipType
                        Forward ref: 
                            Column Name: membershipTypeId
                            Column Type: MembershipType
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
        Variable Name: productId
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
        Variable Name: itemName
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: itemDescription
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: imageURL
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: itemSKU
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: minQuantity
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: maxQuantity
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: allowPriceOverride
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: priceOverrideMin
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: priceOverrideMax
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: squareItemId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
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
        Variable Name: itemDiscount
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: ItemDiscount_TO_Item
                        Name: ItemDiscount_TO_Item
                        Resource A: ItemDiscount
                        Resource B: Item
                        Forward ref: 
                            Column Name: itemId
                            Column Type: Item
                            Is Array: false
                        Back ref: 
                            Column Name: itemDiscount
                            Column Type: ItemDiscount
                            Is Array: false
        Variable Name: itemInstance
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
        Variable Name: subscriptionItem
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: SubscriptionItem_TO_Item
                        Name: SubscriptionItem_TO_Item
                        Resource A: SubscriptionItem
                        Resource B: Item
                        Forward ref: 
                            Column Name: itemId
                            Column Type: Item
                            Is Array: false
                        Back ref: 
                            Column Name: subscriptionItem
                            Column Type: SubscriptionItem
                            Is Array: false
