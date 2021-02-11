
This is a complete prototype for handling common modules in *WawiNeu*

# Containment
The following issues should be validated with this prototype:
- **Central module with REST**  
- **Central module with UI**
- **Runtime exectuable jar**
- **Runtime docker**  
- **Autogenerate api client JAVA**
- **Autogenerate api client C#**
- **postgres database**
- **Central module with Event based communication (Active MQ https://medium.com/@mailshine/activemq-getting-started-with-springboot-a0c3c960356e)**
- **Autogenerate documentation of cm and wawis centralized**
- **Native browser component**
- **Security with https and jwt**
  
- Browser JCEF -> C# OK, Java TODO      **!!!!**


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
    
  
# Optional
- Metrics central module (Kibana, ElasticSearch)
- Runtime spring boot native images 
- Runtime application server (Grundrauschen groß, alle gleiche Versionen, Deploymentmonolith)
- Integration into Backup / Recovery
- Autogenerate api client C
- Logging central module (Tracing)   -> https://www.jaegertracing.io/ Konzept
- Runtime kubernetes (e.g. K3s)     
- Sonarqube, check security automated
- Provide an installer for the runtime 


# Use the prototype 
You can setup the project by calling 
```
 ./gradlew build 
```
in the root project. This triggers all the builds in the different subprojects in the right order. 

Afterwards you can start 
```
 ./gradlew bootRun 
```
in commonModuleRuntime to start the common modules runtime

and
```
 ./gradlew run 
```
in one of the client projects (client/java....) to start the client, which tests the integration


# Ports and adresses

Keycloak: http://localhost:8080/auth (cm/cm)

KeyCloak for C#: https://www.youtube.com/watch?v=k_iwekNh-_A
KeyCloak for WPF: https://stackoverflow.com/questions/63044966/keycloak-in-c-sharp-wpf-application-how-can-i-access-the-roles-of-a-given-user
https://login-master.com/blog/keycloak-net-adapter-in-microsoft-visual-studio-nutzen/
https://dzone.com/articles/adding-authentication-to-a-native-desktop-c-app-wi


# The prototype and the reality
This prototype should validate the architecture against all existing WAWI systems.

**AwintaOne**
- Frontend written in C# 
- Backend written in CacheDB

**Infopharm**
- Written in C, C++, C#, 
- Tobias Essig mentioned that only C# is relevant for this scenario

**Jump**
- Frontend and backend written in Java

**Pharmasoft**
- T.B.D

**Prokas**
- T.B.D


# Additional infos 
- vpcmawinta01-x.intra.vsa.de contains elk stack that will be provided in Noventi
- Download .net core sdk for macos: https://dotnet.microsoft.com/download/dotnet/thank-you/sdk-5.0.102-macos-x64-installer
- Download .net framework https://support.microsoft.com/en-us/help/4054530/microsoft-net-framework-4-7-2-offline-installer-for-windows

- Build a .net framework in c#: https://www.medo64.com/2019/04/using-visual-studio-code-for-net-framework-projects-in-c-sharp/

- ELK: https://logz.io/blog/installing-the-elk-stack-on-windows/
- ActiveMQ Springboot: https://medium.com/@mailshine/activemq-getting-started-with-springboot-a0c3c960356e


# Important architectural decisions

## Monitoring 
Standalone: ELK, Grafana
Kubernetes: EFK, Grafana/Prometheus für Monitoring


## Event Bus


## Ressourcen 
- Runtime benötigt 120MB RAM
- UI benötigt 258MB
- Service benötigt 448MB

## HTTPS Certificates
Brauchen wir HTTPS?
- lokaler Server nur localhost
- beliebiger Rechner in der Apo
- nach aussen (über secured Websocket)




keytool -genkeypair -alias commonmodule -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore commonmodule.p12 -validity 3650


openssl req -x509 -out localhost.crt -keyout localhost.key \
-newkey rsa:2048 -nodes -sha256 \
-subj '/CN=localhost' -extensions EXT -config <( \
printf "[dn]\nCN=localhost\n[req]\ndistinguished_name = dn\n[EXT]\nsubjectAltName=DNS:localhost\nkeyUsage=digitalSignature\nextendedKeyUsage=serverAuth")

-----
dotnet Framework

->dotnet Core

# vpcmawinta01-x
sudo yum install docker
sudo yum install docker-compose
sudo yum install git

#TODOs 
- First usage of windows: is java allowed?
- Create docker network to be reused in services: https://tjtelan.com/blog/how-to-link-multiple-docker-compose-via-network/


#Security
 

öffentlicher / privater schlüssel

- mit privatem Schlüssel kann man signieren, 
- und mit dem öffentlichen Schlüssel des Gegenübers kann ich was verschlüsseln, was nur Gegenüber lesen kann oder Signatur prüfen.

Zertifikat = öffentlicher Schlüssel + Metainfos
verschiedene Arten von Zerts (TLS, andere Zertifikate erstellen)



Aus dem KeyStore das Zertifikat exportieren und in einen neuen Truststore importieren
- weil dann die Möglichkeit besteht, den KeyStore besonders zu sichern
- spätestens dann, wenn alle Arbeitsplätze verwendet werden (nicht nur ein Server) kann dann das Zertifikat 

-> AUSTAUSCHEN DES ZERTIFIKATS










