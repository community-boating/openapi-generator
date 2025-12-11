
# This is a sample api mustache template.  It is representing a fictitious
# language and won't be usable or compile to anything without lots of changes.
# Use it as an example.  You can access the variables in the generator object
# like such:

# use the package from the `apiPackage` variable
package: org.communityboating.api

# operations block
classname: CompassOrder

# loop over each operation in the API:

# each operation has an `operationId`:
operationId: memberCompassOrderGet

# and parameters:


# each operation has an `operationId`:
operationId: memberCompassOrderPost

# and parameters:
orderDTO: OrderDTO


# each operation has an `operationId`:
operationId: memberCompassOrderSummaryGet

# and parameters:


# each operation has an `operationId`:
operationId: memberOrdersCancelPost

# and parameters:


# each operation has an `operationId`:
operationId: staffCompassOrderIdGet

# and parameters:
id: kotlin.Long


# each operation has an `operationId`:
operationId: staffCompassOrderPost

# and parameters:
orderDTO: OrderDTO


# each operation has an `operationId`:
operationId: staffOrdersCancelIdPost

# and parameters:
id: kotlin.Long


# end of operations block
