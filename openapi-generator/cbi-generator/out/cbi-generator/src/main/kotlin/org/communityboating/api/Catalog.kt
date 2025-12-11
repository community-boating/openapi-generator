
# This is a sample api mustache template.  It is representing a fictitious
# language and won't be usable or compile to anything without lots of changes.
# Use it as an example.  You can access the variables in the generator object
# like such:

# use the package from the `apiPackage` variable
package: org.communityboating.api

# operations block
classname: Catalog

# loop over each operation in the API:

# each operation has an `operationId`:
operationId: catalogGet

# and parameters:


# each operation has an `operationId`:
operationId: catalogInventoryGet

# and parameters:


# each operation has an `operationId`:
operationId: catalogInventoryIdGet

# and parameters:
id: kotlin.Long


# each operation has an `operationId`:
operationId: catalogInventoryIdPost

# and parameters:
id: kotlin.Long
stockChangeDTO: StockChangeDTO


# each operation has an `operationId`:
operationId: catalogSyncClassesPost

# and parameters:


# each operation has an `operationId`:
operationId: staffCatalogGet

# and parameters:


# each operation has an `operationId`:
operationId: staffCatalogPost

# and parameters:
catalog: Catalog


# end of operations block
