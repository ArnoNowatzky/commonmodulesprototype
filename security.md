- Security with https and SingleSignOn (oAuth2 server)   
  -> Wie bekome ich den integrierten Browser mit Infos gef�ttert (Zertifikat)
  -> Token holen, GUI mit Token aufrufen      **!!!!**
- https://www.freecodecamp.org/news/how-to-setup-jwt-authorization-and-authentication-in-spring/


- https://objex.medium.com/openapi-3-1f4ddd7a4934 JWT in OpenAPI
- https://connect2id.com/products/nimbus-jose-jwt -> Handeln von jwt

- BearerToken
- Splitten (->3x)
- Header extrahieren:
- ist es ein JWT Token
- ist der Algorithmus derjenige, den ich unterst�tze alg, darf nicht NONE sein
- Signatur pr�fen (3. Block) ->asynchrone Verschl�sselung
- Content vertrauen, Payload aufdr�seln
- G�ltigkeitsdatum validieren
- z.B. IK pr�fen
  -> bei Rollen muss man sich nicht um Lifecycle k�mmern

-> oAuth Token anschauen

-> was ist wenn in der Zwischenzeit Rollen �ndern
-> sind CommonModules in Jobs involviert? Wawi muss sich um Tokens k�mmern in dem
Kontext von zeitgetriggered Dingen



bei UI: Authentication Header im http request
Refresh: JavaScript-API


�ffentlicher / privater schl�ssel

- mit privatem Schl�ssel kann man signieren,
- und mit dem �ffentlichen Schl�ssel des Gegen�bers kann ich was verschl�sseln, was nur Gegen�ber lesen kann oder Signatur pr�fen.

Zertifikat = �ffentlicher Schl�ssel + Metainfos
verschiedene Arten von Zerts (TLS, andere Zertifikate erstellen)



Aus dem KeyStore das Zertifikat exportieren und in einen neuen Truststore importieren
- weil dann die M�glichkeit besteht, den KeyStore besonders zu sichern
- sp�testens dann, wenn alle Arbeitspl�tze verwendet werden (nicht nur ein Server) kann dann das Zertifikat

-> AUSTAUSCHEN DES ZERTIFIKATS



keytool -genkeypair -alias commonmodule -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore commonmodule.p12 -validity 3650


openssl req -x509 -out localhost.crt -keyout localhost.key \
-newkey rsa:2048 -nodes -sha256 \
-subj '/CN=localhost' -extensions EXT -config <( \
printf "[dn]\nCN=localhost\n[req]\ndistinguished_name = dn\n[EXT]\nsubjectAltName=DNS:localhost\nkeyUsage=digitalSignature\nextendedKeyUsage=serverAuth")
