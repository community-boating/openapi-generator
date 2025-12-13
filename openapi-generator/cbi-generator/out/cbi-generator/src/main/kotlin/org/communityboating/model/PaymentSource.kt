Model name: PaymentSource
                Resource Suffix: 
                    Relation: PaymentSource_TO_Person, Resource A: PaymentSource, ResourceB: Person, hasForward: , hasBackward: 
                    Relation: PaymentSource_TO_Balance, Resource A: PaymentSource, ResourceB: Balance, hasForward: , hasBackward: 
                Has Resource: PaymentSource
                    Base Resource: PaymentSource
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
        Variable Name: personId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: false
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
        Variable Name: paymentType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: stripePaymentSource
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
                    COL INFO
        Variable Name: balanceSource
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: PaymentSource_TO_Balance
                        Name: PaymentSource_TO_Balance
                        Resource A: PaymentSource
                        Resource B: Balance
                        Forward ref: 
                            Column Name: balanceSource
                            Column Type: Balance
                            Is Array: false
                        Back ref: 
                            Column Name: paymentSource
                            Column Type: PaymentSource
                            Is Array: false
        Variable Name: active
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
