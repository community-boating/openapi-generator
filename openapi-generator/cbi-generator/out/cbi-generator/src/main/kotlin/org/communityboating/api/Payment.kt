
# This is a sample api mustache template.  It is representing a fictitious
# language and won't be usable or compile to anything without lots of changes.
# Use it as an example.  You can access the variables in the generator object
# like such:

# use the package from the `apiPackage` variable
package: org.communityboating.api

# operations block
classname: Payment

# loop over each operation in the API:

# each operation has an `operationId`:
operationId: memberCheckoutSessionGet

# and parameters:


# each operation has an `operationId`:
operationId: memberPaymentCancelIdPost

# and parameters:
id: kotlin.Int


# each operation has an `operationId`:
operationId: memberPaymentPost

# and parameters:
createOrderPaymentDTO: CreateOrderPaymentDTO


# each operation has an `operationId`:
operationId: staffPaymentPost

# and parameters:
createOrderPaymentDTO: CreateOrderPaymentDTO


# end of operations block
