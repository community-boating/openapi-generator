
# This is a sample api mustache template.  It is representing a fictitious
# language and won't be usable or compile to anything without lots of changes.
# Use it as an example.  You can access the variables in the generator object
# like such:

# use the package from the `apiPackage` variable
package: org.communityboating.api

# operations block
classname: Balance

# loop over each operation in the API:

# each operation has an `operationId`:
operationId: memberBalanceNumberGet

# and parameters:
number: kotlin.String


# each operation has an `operationId`:
operationId: staffBalanceNumberGet

# and parameters:
number: kotlin.String


# each operation has an `operationId`:
operationId: staffBalancesGet

# and parameters:
personId: kotlin.Int


# each operation has an `operationId`:
operationId: staffBalancesPost

# and parameters:
balance: Balance


# end of operations block
