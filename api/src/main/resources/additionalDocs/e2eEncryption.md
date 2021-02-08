# End-to-End-Encryption Overview

<!-- toc -->
<!-- /toc -->

In the DDAP the chat are data, that must be written and read by the one, that created it, but also by the one, that is adressed. So we have to use asymmetric encryption (public/private keys). Because we don't want to store all data at least twice, we combine that with symmetric encryption and a one time key for that. The following key types are used:

## Key Types
### Client Main Key (for patient and pharmacy)

The client, which can be the patient or the pharmacy, initially creates a private public key pair for asymmetric encryption. This is also done for anonymous patient users. For asymmetric encyryption, a pair of keys is used: A public key, which is used for encryption, and a private key for decryption. So anybody can encrypt data with the public key, that only I can decrypt with the private key.

The Public Client Main Key is uploaded to the Public Key Service. The Private Client Main Key must not be stored or transferred unencryptedly! If the client uses different devices, the private key has to be transfered, see chapter below

### Scoped Data Encryption Key

This is a symmetric key, which is created for scope of information, in our case for a chat.
### User Related Key Encryption Key or Secure Hardware on mobile clients

To store the Private Client Main Key on the device of the user, it has to be encrypted itself:

#### Browser

In the browser we store the Private Client Main Key encrypted with a PBKDF2 with password in the Indexed DB, see Secure Data Stored in Browser: https://pragmaticwebsecurity.com/files/cheatsheets/browsersecrets.pdf

PBKDF2 Algorithm

This algorithm is designed for encrypting data with a rather short PIN or password, but providing a good savety. It is used widely for encrypting keys and other secrets

#### Mobile Device

Android and iOS provide secure way of creating a device specific key, e.g. with a secure hardware, which is secured by fingerprint, FaceID, etc.

## UseCases

### Bootstrapping

Before the first communication, key bootstrapping has to be done on the client:

1. Create the Client Main Key pair
2. Register public key on server
3. Encrypt Private Client Main Key using a User Related Key Encryption Key or Secure Hardware. (Explanation: Secure storage on a mobile device also works with encryption, but the encryption key is held inside a hardware module and cannot be extracted, but it can be used to encrypt other data)
4. Store encrypted Private Client Main Key

### Write new chat messages
1. Client creates a new Scoped Data Encryption Key
2. Client encrypts the object data with symmetric encryption with the Scoped Data Encryption Key and adds it to the request
3. Fetching public keys:
     1. Pharmacy client fetches the public key of the other participant from the public key service
     2. Patient client fetches the public keys of the pharmacies of the pharmacy group
4. Encrypt the Scoped Data Encryption Key with one or more public keys and add them to the request
5. Client uses his Public Main Client Key to encrypt the symmetric key for reading the data for himself and adds it to the request
6. Client sends the request to the backend

### Read new chat messages

1. Decrypt the private key
2. Client makes a request to the backend and gets a response with encrypted data
3. Decrypt the Scoped Data Encryption Key with the Private Main Client Key
4. Decrypt message with the Scoped Data Encryption Key

### Change Client Main Key

1. Create a new Client Main Key Pair on the client and encrypt it (see Bootstrapping)
2. Request a list of encrypted Scoped Data Encryption Keys for all active chats of the client from the server
3. Decrypt them with the old Private Client Main Key
4. Encrypt them with the new Prviate Client Main Key
5. Send the request with the newly encrypted keys to the server

## Key Management
### Public key service

To use asymmetric encryption we have to have a public registry of the public keys of all participants. On registering a new patient or pharmacy the client has to create a public / private key pair and has to provide the public key to the service. For telemedicine partners the public key has to be stored manually in the DB.

- Endpoint for uploading a public key
- Endpoint for downloading a public key for
  - A DDAP known user
  - All pharmacies in a pharmacy group
  - A telemedicine partner representative for it's users, if it cannot provide public keys for all of it's users
  
The API specification can be found here: <a href="../connect-api/connect-key-management-api-v1.html">NOVENTI Connect Key Management API</a>  
  
### Storing private keys


## Algorithms to be used

Proposed algrorithms, key lenght and other parameters are based on the BSI TR-02102-1 technical guidline.

Due to many platforms involved, a common consensus must be achieved regarding overall security (available algorithms, mode of operation and key lenght, ...) and user experience (performance, password policy, ...). The proposals have to be adapted if necessary. Some POC code and compatibility checks is needed.

### Password Based Key Derivation

Using PBKDF2 with a hash function of the SHA-2 family should be appropriate. Hashing should be applied 50000 times. A password policy is recommended, e.g. a length of 10 containing characters, digits and special characters.

Example: PBKDF2 with HMAC SHA-256
### Asymmetric Encryption

For asymmetric encryption, ECIES or RSA might come in place.

#### ECIES

ECIES should be used with a supported symmetric encryption scheme (e.g. AES-256), a key size of >200 Bit (e.g. 256 Bit) and a

Example: ECC over secp256k1 curve and AES-256-CBC.

#### RSA

RSA should be used with a key size >3000 Bit (4096 Bit if applicable) and OAEP padding. The widely available PKCS#1 Padding is not recommended.

Example: RSA-4096 and OAEP (with SHA-256 and MGF1) Padding

### Symmetric Encryption

AES-GCM should be widely supported, using a keysize of 128, 192, 256. With GCM, a new IV (96 Bit) must be generated with every encryption using a secure random mechanism. Under these premises, key rotation for a single chat can be ignored.

Example: AES-256 GCM  