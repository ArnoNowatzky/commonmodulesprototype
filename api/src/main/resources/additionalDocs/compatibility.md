# Compatibility of changes

What are compatible changes regarding a REST API for you? 

First of all, we have to distinguish between the role of the API implementation. Our APIs are mostly implented by ourselves, so act as server, and your implementation act as client. But there is one exception to that rule: The Connect AVS API, where you as implementer of a pharmacy systems act as server, and the DDAP acts as client.

## Common case: You act as client of the spec
### Endpoints
Changing paths of endpoints or removing endpoints of course is incompatible, but adding new endpoints to the API is compatible.  

### Requests
Adding optional query or header paramters is compatible, adding required parameters or changing paramter names is not. Adding optinal attributes for JSON bodies is compatible, adding required attributes or changing attribute names or whole object structure is not.

### Responses
We demand to configure your JSON parser as tolerant reader. That means that unkown JSON properties will be ignored.

Adding attributes to the JSON body of an answer is a compatible change, changing or removing attributes is not.
<!--- ## Connect AVS API: You act as server of the spec
### Endpoints
Adding endpoints or changing paths of endpoints is incompatible, removing endpoints is not

### Requests
Adding--->

