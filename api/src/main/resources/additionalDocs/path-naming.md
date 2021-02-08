# Path Naming and HTTP Method Usage
  
The idea is to have paths, that are created from the concept of resources. To use the definition of 
the creator of REST, Roy Fielding:

_"The key abstraction of information in REST is a resource. Any information that can be named can be 
a resource: a document or image, a temporal service (e.g. “today’s weather in Los Angeles”), a 
collection of other resources, a non-virtual object (e.g., a person), and so on. In other words, 
any concept that might be the target of an author’s hypertext reference must fit within the definition 
of a resource"_

So resources in this API can be (rougly inspired by https://restfulapi.net/resource-naming/):

* Collections of resources: Collections are named plural and contain a list of resources. To create 
  an item in a collection, normally POST requests are used, e.g. /preorders
  * Root collections: Mostly the root path is a collection, e.g. /articles
  * Subcollections: Sometimes a resource has subcollections, e.g. /medicationplan/medications
  * If the normal HTTP methods are not enough to distinguish between certain type of actions, that 
    can be performed on a certain resource, a pseudo collection named actions is used. To perform these 
    actions, a resource is created with a POST, e.g. /user/actions/send-email-reset-password/
  * If multiple searches are possible in a collection, and it is not feasable to distinguish them with 
    parameters, then the pseudo collection searches is used, e.g. /articles/searches/name-or-product-nr
* Singleton resource: Sometimes a thing in reality exists only once, so there is no need to have a 
  collection and add only one item, so singleton resources are named in singular, e.g. /medicationplan.
  * Root singleton resource: e.g. /medicationplan
  * Subresource: e.g. /preorders/{orderId}/chat
* Resources identified with an id: A collection contains of multiple resources. To identify exacly 
  one of them, we use the collection path and add a path segment with the id, e.g. /preorders is the collection and /preorders/{orderId} is one unique resource inside the collection. To get them, GET method is used, to modify PUT and to delete DELETE
    
