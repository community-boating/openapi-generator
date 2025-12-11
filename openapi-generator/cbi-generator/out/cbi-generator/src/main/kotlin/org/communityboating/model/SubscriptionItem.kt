Model name: SubscriptionItem
                Has Resource: SubscriptionItem
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
