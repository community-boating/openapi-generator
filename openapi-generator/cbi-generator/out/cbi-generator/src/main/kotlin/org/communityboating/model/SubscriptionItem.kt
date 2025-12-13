Model name: SubscriptionItem
                Resource Suffix: 
                    Relation: SubscriptionItem_TO_Subscription, Resource A: SubscriptionItem, ResourceB: Subscription, hasForward: , hasBackward: 
                    Relation: SubscriptionItem_TO_Item, Resource A: SubscriptionItem, ResourceB: Item, hasForward: , hasBackward: 
                Has Resource: SubscriptionItem
                    Base Resource: SubscriptionItem
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
        Variable Name: subscriptionId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: SubscriptionItem_TO_Subscription
                        Name: SubscriptionItem_TO_Subscription
                        Resource A: SubscriptionItem
                        Resource B: Subscription
                        Forward ref: 
                            Column Name: subscriptionId
                            Column Type: Subscription
                            Is Array: false
                        Back ref: 
                            Column Name: subscriptionItem
                            Column Type: SubscriptionItem
                            Is Array: false
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
        Variable Name: cyclePriceOverrideCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
