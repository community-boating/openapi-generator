Model name: StripeTransactionDTO
                MODEL META
                    hasDTO: true
                    hasDAO: false
                    hasTable: true
                    hasInterface: true
                    isResource: false
                    isBase: false

                    varsIncluded: none
                    
                    varsExcluded: none
                    
                    relationsIncluded: none
                    
                    relationsExcluded: none
                    
    Variables:
        Variable Name: assignId
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
        Variable Name: transactionType
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
        Variable Name: stripePaymentIntent
            Is Required: true
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
        Variable Name: stripePaymentSecret
            Is Required: false
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: &quot;null&quot;
        Variable Name: transactionAmountCents
            Is Required: true
            Is Read Only: true
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
