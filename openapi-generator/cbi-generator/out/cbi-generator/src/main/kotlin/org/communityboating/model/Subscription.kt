Model name: Subscription
                Has Resource: Subscription
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
        Variable Name: name
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: billingCycle
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: personSubscription
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: PersonSubscription_TO_Subscription
                        Name: PersonSubscription_TO_Subscription
                        Resource A: PersonSubscription
                        Resource B: Subscription
                        Forward ref: 
                            Column Name: subscriptionId
                            Column Type: Subscription
                            Is Array: false
                        Back ref: 
                            Column Name: personSubscription
                            Column Type: PersonSubscription
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
