Model name: CashDrawersChange
                Has Resource: CashDrawersChange
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
        Variable Name: changeType
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
        Variable Name: changeAmountCents
            Is Required: true
            Is Read Only: false
            Is Write Only: false
            Is Inherited: false
            Is Overridden: 
            Default Value: 
                    COL INFO
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
                        Base Name: CashTransaction_TO_CashDrawersChange
                        Name: CashTransaction_TO_CashDrawersChange
                        Resource A: CashTransaction
                        Resource B: CashDrawersChange
                        Forward ref: 
                            Column Name: cashDrawerChangeId
                            Column Type: CashDrawersChange
                            Is Array: false
                        Back ref: 
                            Column Name: cashTransaction
                            Column Type: CashTransaction
                            Is Array: false
