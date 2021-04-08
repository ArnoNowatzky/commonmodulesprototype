- Security with https and SingleSignOn (oAuth2 server)   
  -> Wie bekome ich den integrierten Browser mit Infos gefüttert (Zertifikat)
  -> Token holen, GUI mit Token aufrufen      **!!!!**
- https://www.freecodecamp.org/news/how-to-setup-jwt-authorization-and-authentication-in-spring/


- https://objex.medium.com/openapi-3-1f4ddd7a4934 JWT in OpenAPI
- https://connect2id.com/products/nimbus-jose-jwt -> Handeln von jwt

- BearerToken
- Splitten (->3x)
- Header extrahieren:
- ist es ein JWT Token
- ist der Algorithmus derjenige, den ich unterstütze alg, darf nicht NONE sein
- Signatur prüfen (3. Block) ->asynchrone Verschlüsselung
- Content vertrauen, Payload aufdröseln
- Gültigkeitsdatum validieren
- z.B. IK prüfen
  -> bei Rollen muss man sich nicht um Lifecycle kümmern

-> oAuth Token anschauen

-> was ist wenn in der Zwischenzeit Rollen ändern
-> sind CommonModules in Jobs involviert? Wawi muss sich um Tokens kümmern in dem
Kontext von zeitgetriggered Dingen



bei UI: Authentication Header im http request
Refresh: JavaScript-API


öffentlicher / privater schlüssel

- mit privatem Schlüssel kann man signieren,
- und mit dem öffentlichen Schlüssel des Gegenübers kann ich was verschlüsseln, was nur Gegenüber lesen kann oder Signatur prüfen.

Zertifikat = öffentlicher Schlüssel + Metainfos
verschiedene Arten von Zerts (TLS, andere Zertifikate erstellen)



Aus dem KeyStore das Zertifikat exportieren und in einen neuen Truststore importieren
- weil dann die Möglichkeit besteht, den KeyStore besonders zu sichern
- spätestens dann, wenn alle Arbeitsplätze verwendet werden (nicht nur ein Server) kann dann das Zertifikat

-> AUSTAUSCHEN DES ZERTIFIKATS



keytool -genkeypair -alias commonmodule -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore commonmodule.p12 -validity 3650


openssl req -x509 -out localhost.crt -keyout localhost.key \
-newkey rsa:2048 -nodes -sha256 \
-subj '/CN=localhost' -extensions EXT -config <( \
printf "[dn]\nCN=localhost\n[req]\ndistinguished_name = dn\n[EXT]\nsubjectAltName=DNS:localhost\nkeyUsage=digitalSignature\nextendedKeyUsage=serverAuth")
