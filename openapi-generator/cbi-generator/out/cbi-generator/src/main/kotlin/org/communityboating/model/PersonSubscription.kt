Model name: PersonSubscription
                Resource Suffix: 
                    Relation: LineItem_TO_PersonSubscription, Resource A: LineItem, ResourceB: PersonSubscription, hasForward: , hasBackward: true
                    Relation: PersonSubscription_TO_Person, Resource A: PersonSubscription, ResourceB: Person, hasForward: , hasBackward: 
                    Relation: PersonSubscription_TO_Subscription, Resource A: PersonSubscription, ResourceB: Subscription, hasForward: , hasBackward: 
                    Relation: LineItem_TO_PersonSubscription, Resource A: LineItemDTO, ResourceB: PersonSubscription, hasForward: , hasBackward: false
                Has Resource: PersonSubscription
                    Base Resource: PersonSubscription
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
        Variable Name: personId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: PersonSubscription_TO_Person
                        Name: PersonSubscription_TO_Person
                        Resource A: PersonSubscription
                        Resource B: Person
                        Forward ref: 
                            Column Name: personId
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: personSubscription
                            Column Type: PersonSubscription
                            Is Array: false
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
        Variable Name: billingDate
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: billingCycle
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
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
                            Sub Relation: LineItem_TO_PersonSubscription
                        Type: ONE_TO_ONE
                        Base Name: LineItem_TO_PersonSubscription
                        Name: LineItem_TO_PersonSubscription
                        Resource A: LineItem
                        Resource B: PersonSubscription
                        Forward ref: 
                            Column Name: subscriptionId
                            Column Type: PersonSubscription
                            Is Array: false
                        Back ref: 
                            Column Name: lineItem
                            Column Type: LineItem
                            Is Array: false
