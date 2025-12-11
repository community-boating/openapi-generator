Model name: OrderPayment
                Has Resource: OrderPayment
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
        Variable Name: orderId
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                            Sub Relation: OrderPayment_TO_OrderDTO
                        Type: ONE_TO_ONE
                        Base Name: OrderPayment_TO_OrderNew
                        Name: OrderPayment_TO_OrderNew
                        Resource A: OrderPayment
                        Resource B: OrderNew
                        Forward ref: 
                            Column Name: orderId
                            Column Type: OrderNew
                            Is Array: false
                        Back ref: 
                            Column Name: orderPayment
                            Column Type: OrderPayment
                            Is Array: false
        Variable Name: paymentType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: paymentSource
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: paymentServiceChangeCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: paymentPaidCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: paymentTotalCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: paymentRefundedCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: paymentToRefundCents
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: paymentStatus
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: paymentDueDate
            Is Required: false
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: null
                    COL INFO
        Variable Name: balanceTransaction
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: BalanceTransaction_TO_OrderPayment
                        Name: BalanceTransaction_TO_OrderPayment
                        Resource A: BalanceTransaction
                        Resource B: OrderPayment
                        Forward ref: 
                            Column Name: paymentId
                            Column Type: OrderPayment
                            Is Array: false
                        Back ref: 
                            Column Name: balanceTransaction
                            Column Type: BalanceTransaction
                            Is Array: false
        Variable Name: cashTransaction
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: CashTransaction_TO_OrderPayment
                        Name: CashTransaction_TO_OrderPayment
                        Resource A: CashTransaction
                        Resource B: OrderPayment
                        Forward ref: 
                            Column Name: paymentId
                            Column Type: OrderPayment
                            Is Array: false
                        Back ref: 
                            Column Name: cashTransaction
                            Column Type: CashTransaction
                            Is Array: false
        Variable Name: stripeTransaction
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
                    Relation:
                        Type: ONE_TO_ONE
                        Base Name: StripeTransaction_TO_OrderPayment
                        Name: StripeTransaction_TO_OrderPayment
                        Resource A: StripeTransaction
                        Resource B: OrderPayment
                        Forward ref: 
                            Column Name: paymentId
                            Column Type: OrderPayment
                            Is Array: false
                        Back ref: 
                            Column Name: stripeTransaction
                            Column Type: StripeTransaction
                            Is Array: false
