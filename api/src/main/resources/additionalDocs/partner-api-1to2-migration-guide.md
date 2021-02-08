# Migration Guide for migrating from Connect Public Partner API version 1 to 2

Between v1 and v2 are some incompatible changes. This guide lists all changes, that are relevant to you and marks the comptibility.

## Authentication:
The authentication changed from an OAuth JWT Token based to an API key authentication. The reason is, that we want to unify our APIs and in other APIs it is additionally needed to identify as an app user. To be able to do this, we changed the identification of our partners to an API Token. You get this token from you NOVENTI contact.

## Pharmacies
Pharmacies are not identified with our internal pharmacyId, but with the pharmacyIk (IK = Institutionskennzeichen). So the response pharmacy objects no longer contain the internal pharmacyId, but the only the pharmacyIk. There are some additional fields in the pharmacy response objects, like
* owner
* description
* contact.fax
* logos

### Find pharmacies
* You find that with the endpoint name searchPharmaciesInArea in the tag Pharmacies
* The path changed to {url}/partner/pharmacies/searches/area

### Get Pharmacy
You can read the information of a single pharmacy by pharmacyIk as new endpoint getPharamacy in the tag Pharmacies

## Transfer a prescription
* You find that with the endpoint name addPkvEprescriptionPreOrder in the tag Orders
* The path changed to {url}/partner/preorders/pkv-eprescription
* The request body changed:
    * tenantId was removed
    * pharmacyId was changed to pharmacyIk, as described in the headline "Pharmacies"
    * prescription.id was removed. The identification of a prescription is now the orderId, that you get as response to this request. This orderId is used to identify your preorder also in the message endpoint and the callback
* Response changed: Now the orderId is returned instead of an empty response

## Messaging

* Sending a message with endpoint sendChatTextMessage in the tag "Message" is clearly seperated from changing the status (which is only cancelling the order for the patient side) which is done with the cancelPreOrder endpoint in that tag "Orders" 
* For sending a message this changed:
    * The path changed to {url}/partner/preorders/{orderId}/chat/messages/text
    * To identify the prescription, the orderId is used as path parameter instead of the prescriptionId
    * In the request body the messageId attribute was removed, because the id is created internally and is not referenced in any other API
    * The response changed from a 200 with body to a 204 with empty body
* For cancelling the preorder:
    * The path changed to {url}/connect/public/partner/v2/preorders/{orderId}/actions/cancel
    * To identify the prescription, the orderId is used as path parameter instead of the prescriptionId
* For receiving messages from the pharmacy, the callback API was specified in <a href="../connect-api/connect-public-partner-messagecallback-api-v2.html">Connect Public Partner Messagecallback API</a>    
    
