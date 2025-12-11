Model name: ApClassType
                Has Resource: ApClassType
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
        Variable Name: item
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
