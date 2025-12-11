Model name: Person
                Has Resource: Person
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
        Variable Name: address
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Address_TO_Person
                        Name: Address_TO_Person
                        Resource A: Address
                        Resource B: Person
                        Forward ref: 
                            Column Name: personId
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: address
                            Column Type: Address
                            Is Array: false
        Variable Name: balance
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: Balance_TO_Person
                        Name: Balance_TO_Person
                        Resource A: Balance
                        Resource B: Person
                        Forward ref: 
                            Column Name: balanceOwner
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: balance
                            Column Type: Balance
                            Is Array: false
        Variable Name: orderNew
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: OrderDTO_TO_Person
                        Type: ONE_TO_ONE
                        Base Name: OrderNew_TO_Person
                        Name: OrderNew_TO_Person
                        Resource A: OrderNew
                        Resource B: Person
                        Forward ref: 
                            Column Name: personId
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: orderNew
                            Column Type: OrderNew
                            Is Array: false
        Variable Name: paymentSource
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: PaymentSource_TO_Person
                        Name: PaymentSource_TO_Person
                        Resource A: PaymentSource
                        Resource B: Person
                        Forward ref: 
                            Column Name: personId
                            Column Type: Person
                            Is Array: false
                        Back ref: 
                            Column Name: paymentSource
                            Column Type: PaymentSource
                            Is Array: false
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
