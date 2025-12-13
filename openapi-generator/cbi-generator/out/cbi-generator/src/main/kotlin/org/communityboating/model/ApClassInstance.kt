Model name: ApClassInstance
                Resource Suffix: 
                    Relation: Item_TO_ApClassInstance, Resource A: Item, ResourceB: ApClassInstance, hasForward: , hasBackward: 
                Has Resource: ApClassInstance
                    Base Resource: ApClassInstance
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
                        Base Name: Item_TO_ApClassInstance
                        Name: Item_TO_ApClassInstance
                        Resource A: Item
                        Resource B: ApClassInstance
                        Forward ref: 
                            Column Name: classInstanceId
                            Column Type: ApClassInstance
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
