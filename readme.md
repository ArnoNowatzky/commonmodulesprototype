
This is a complete prototype for handling common modules with the new architecture in project *WawiNeu*
The underlying architecture concept is located under https://confluence.intra.vsa.de/display/UPA/Common+Modules+-+Architekturkonzept_DRAFT.

# Prerequisites
This projects needs the following things to be installed:

- JDK 11-14 (15 not yet supported to older spring version.... to be done)
- docker
- docker-compose

# APIs
CM WebURI: https://localhost:8002/
CM Rest API (Beispiel):https://localhost:8002/medicationcontainers
NCI Rest API: https://localhost:8001/healthcheck 
WAWI Rest API: https://localhost:8003/pharmacy


# Structure of project
The prototype contains of the following parts:
* *api*: API definitions from CM side
* *wawis*: Default client implementation side of WAWI. They do not contain the complete target technology stack,
  but the stack, which can be provided without having the WAWI. They are divided into client and server part and contain
  all interface types: outgoing REST, incoming REST, event based communication and integration by embedded browser
* *commonModuleBase*: Basic implementations which can be used in all common modules
* *commonModuleExample*: Example common module containing REST API, Event implementation and a browser component,
  which can be used in embedded browser to be shown
* *commonModuleHelloWorld*: A simple hello world common module to check the base resource needs without any techstack
* *commonModuleNCI*: initial implementation of the NCI, containing the cm side of installation,
  databasehandling, the event broker and REST API to start/stop common modules as executable jar,
  as dockerimage
* *datacenter*: contains all components, which are located in datacenter
* *documentation*: the architecture concept doctoolchain (to be done)
* *keystore*: keys/certificates for https
* *template*: templating for new cm projects (to be done)

# Datacenter components at vpcmawinta01-x
This vm is a CentOS7 VM and contains all datacenter components of the new architecture of the common modules.
If you don't have access on this machine send your public key to thomas.wieschke or markus.oley and we install it.
Following commands were executed:
* export http_proxy=http://proxy.vsa.de:8080 -> ~/.bashrc
* proxy=http://proxy.vsa.de:8080 -> /etc/yum.conf
* Anleitung https://docs.docker.com/engine/install/centos/
* mkdir /etc/systemd/system/docker.service.d
* [Service]
  Environment="http_proxy=http://proxy.vsa.de:8080"
  Environment="https_proxy=http://proxy.vsa.de:8080"
  Environment="no_proxy=vsa.de" ->   /etc/systemd/system/docker.service.d/service-overrides.conf
* sudo curl -L "https://github.com/docker/compose/releases/download/1.29.0/docker-compose-Linux-x86_64" --proxy http://proxy.vsa.de:8080 -o /usr/local/bin/docker-compose
* sudo yum install git
* sudo systemctl start docker
* sudo systemctl enable docker
* cd /work
* git clone https://stash.intra.vsa.de/scm/aup/commonmodulesprototype.git

In `/work/commonmodulesprototype` this git repository is cloned.`

In directory `datacenter` all the components which are hosted in datacenter are contained.
They can be started by stepping to subdirectory and call
```
docker-compose up -d
```

# Prototype in Action

## Preconfigurations
To avoid anonymous pull of docker hub images configure your personal dockerhub credentials to 
`~/.gradle/gradle.properties` like

```
cm.docker.user=[USER]
cm.docker.pwd=[PWD]
```

## Initially build and run the prototype
You can build the project by calling
```
 ./gradlew build 
```
in the root project. Afterwards you can start
```
 ./gradlew bootRun 
```
in commonModuleNCI to start the common modules runtime

and
```
 ./gradlew run 
```
in one of the client projects (client/java....) to start the client, which tests the integration

## Using the prototype in context of development
For development it is convenient to start all components of the prototype as automatically as possible. 
You can do the following steps to start it. I recommed you to use 4 different terminals to handle the different
services: 

1. In subproject 'commonModuleNCI' call 'docker-compose up' to start both local postgres database and activemq broker
2. In another terminal call './gradlew :commonModuleNCI:bootRun' to start the NCI 
3. In another terminal call './gradlew :commonModuleExample:bootRun' to start the example common module. 
   You can see the ui of the example CM in your browser at https://localhost:8002/
4. In another terminal call './gradlew :wawis:java:server:bootRun' to start the server part of the java WAWI dummy
5. In another terminall call './gradlew :wawis:java:client:run' to start the client part of the java WAWI dummy
 
Example URLs for accessing REST API see in chapter APIs
If you want to see outgoing REST API switch to Tab 'Service'
If you want to see the UI of the CM in client with embedded browser of the language itself (e.g. JavaFX) switch to Tab 'UI' and click 'Reload'
Showing REST-API Call from CM to WAWI does not work in this context, but works in Chrome.
If you want to see the UI of the CM in client with JCEF switch to Tab 'UICEF'. TODO
If you want to see Events switch to Tab 'Event' 

TODO: Currently we are using a self signed certificates. If you get an error in chrome type thisisunsafe o bypass the message:
https://stackoverflow.com/questions/35274659/when-you-use-badidea-or-thisisunsafe-to-bypass-a-chrome-certificate-hsts-err

## Using the prototype in context of production (showcase) - NOT YET DONE
If you want to simulate the prototype in context of production, that means that e.g. the client shall trigger the 
NCI to be updated and shall start and stop the common modules, the postgres db and so on, this is also possible. 
You can do the following steps to start it: 

1. In subproject 'commonModuleNCI' call './gradlew bootRun' to start the NCI
2. In subproject 'wawis/java/server' call './gradlew bootRun' to start the server part of the WAWI dummy
3. In subproject 'wawis/java/client' call './gradlew run' to start the client part of the WAWI dummy
4. Step to mask 'Admin' and trigger button "Install all modules" to install the common modules automatically
4. Step to mask 'Admin' and trigger button "Start all modules" to start the common modules automatically

## Autogenerate documentation of common module
After initially build the project you only have to call 
```
./gradlew :api:serve
``` 
and your browser is opened with the generated documentation.
This should show the possibility to automatically generate api documentation from spec and can be used for both 
common modules and point of sale documentation.

## Native browser component
to be done

## Security with https and jwt
to be done

##Collect operatingsystem infos 
On http://vpcmawinta01-x.intra.vsa.de:5601 we have established a ELK Stack where you can see environment infos 
which are collected by the prototype. (username: elastic, password: changeme)
The elasticsearch is accessible via://vpcmawinta01-x.intra.vsa.de:9200/
Data is stored on vpcmawinta01-x.intra.vsa.de:9200/wawi/cm/hardware
You can get an overview here: http://vpcmawinta01-x.intra.vsa.de:5601/app/discover

(MetricBeat:     http://vpcmawinta01-x.intra.vsa.de:5601/app/home#/tutorial/systemMetrics)
























