
# This is a sample api mustache template.  It is representing a fictitious
# language and won't be usable or compile to anything without lots of changes.
# Use it as an example.  You can access the variables in the generator object
# like such:

# use the package from the `apiPackage` variable
package: org.communityboating.api

# operations block
classname: Default

# loop over each operation in the API:

# each operation has an `operationId`:
operationId: apClassEnrollIdPost

# and parameters:
id: kotlin.Int
aPClassEnroll: APClassEnroll


# each operation has an `operationId`:
operationId: apClassGetEligiblePersonIdGet

# and parameters:
personId: kotlin.Int


# each operation has an `operationId`:
operationId: apClassGetFuturePersonIdGet

# and parameters:
personId: kotlin.Int


# each operation has an `operationId`:
operationId: classesSignupPost

# and parameters:
classSignupRequestDTO: ClassSignupRequestDTO


# each operation has an `operationId`:
operationId: memberTestPost

# and parameters:
testRequest: TestRequest


# end of operations block
