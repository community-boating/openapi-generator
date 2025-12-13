Model name: MembershipType
                Resource Suffix: 
                    Relation: Item_TO_MembershipType, Resource A: Item, ResourceB: MembershipType, hasForward: , hasBackward: 
                Has Resource: MembershipType
                    Base Resource: MembershipType
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
                        Base Name: Item_TO_MembershipType
                        Name: Item_TO_MembershipType
                        Resource A: Item
                        Resource B: MembershipType
                        Forward ref: 
                            Column Name: membershipTypeId
                            Column Type: MembershipType
                            Is Array: false
                        Back ref: 
                            Column Name: item
                            Column Type: Item
                            Is Array: false
