
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

- Autogenerate documentation of cm and wawis centralized
- Security with https and SingleSignOn (oAuth2 server)
- Integration into Backup / Recovery
- Metrics central module (Kibana, ElasticSearch)
 

- How to handle orgaunits (service multitenantable machen? <-> wawi ohne tenants)
- cef browser
- Autogenerate api client C
- Resilience
  
- Logging central module (Tracking)

FIRST PROJECT (BETA)

- Runtime kubernetes (e.g. K3s)
- Synchronize different datamodels
- Sonarqube, check security automated
- Ui Integration after WAWI (Polymer, WebComponents...)
- Provide an installer for the runtime

PRODUCTIVE

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

Keycloak: http://localhost:8080/auth 


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
Kubernetes: EFK, Grafana/Prometheus f�r Monitoring


## Event Bus


## Ressourcen 
- Runtime ben�tigt 120MB RAM
- UI ben�tigt 258MB
- Service ben�tigt 448MB

## HTTPS Certificates
Brauchen wir HTTPS?
- lokaler Server nur localhost
- beliebiger Rechner in der Apo
- nach aussen (�ber secured Websocket)




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
 

�ffentlicher / privater schl�ssel

- mit privatem Schl�ssel kann man signieren, 
- und mit dem �ffentlichen Schl�ssel des Gegen�bers kann ich was verschl�sseln, was nur Gegen�ber lesen kann oder Signatur pr�fen.

Zertifikat = �ffentlicher Schl�ssel + Metainfos
verschiedene Arten von Zerts (TLS, andere Zertifikate erstellen)



Aus dem KeyStore das Zertifikat exportieren und in einen neuen Truststore importieren
- weil dann die M�glichkeit besteht, den KeyStore besonders zu sichern
- sp�testens dann, wenn alle Arbeitspl�tze verwendet werden (nicht nur ein Server) kann dann das Zertifikat 

-> AUSTAUSCHEN DES ZERTIFIKATS










