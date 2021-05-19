
This is a complete prototype for handling common modules with the new architecture in project *WawiNeu*
The underlying architecture concept is located under https://confluence.intra.vsa.de/display/UPA/Common+Modules+-+Architekturkonzept_DRAFT.

# Prerequisites
This projects needs the following things to be installed:

- JDK 11
- docker
- docker-compose

# Structure
The prototype contains of the following parts:
* *api*: API definitions from CM side
* *clients*: Default client implementation side of WAWI. They do not contain the complete target technology stack,
  but the stack, which can be provided without having the WAWI
* *commonModuleBase*: Basic implementations which can be used in all common modules
* *commonModuleExample*: Example common module containing REST API, Event implementation and a browser component,
  which can be used in embedded browser to be shown
* *commonModuleHelloWorld*: A simple hello world common module to check the base resource needs without any techstack
* *commonModuleRuntime*: initial implementation of the NCI, containing the cm side of installation,
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

#TODOS
- Browser JCEF -> C# OK, Java TODO      **!!!!**
- Runtime spring boot native images
- Runtime application server (Grundrauschen groß, alle gleiche Versionen, Deploymentmonolith)
- Integration into Backup / Recovery
- Autogenerate api client C
- Logging central module (Tracing)   -> https://www.jaegertracing.io/ Konzept
- Runtime kubernetes (e.g. K3s)
- Sonarqube, check security automated
- Provide an installer for the runtime
- First usage of windows: question: is java allowed?

# Prototype in Action

## Initially build and run the prototype
You can build the project by calling
```
 ./gradlew build 
```
in the root project. Afterwards you can start
```
 ./gradlew bootRun 
```
in commonModuleRuntime to start the common modules runtime

and
```
 ./gradlew run 
```
in one of the client projects (client/java....) to start the client, which tests the integration

## Runtime exectuable jar
The subproject 'commonModuleRuntime' provides a small runtime which enables starting independent services.
1. In subproject clients/java call `docker-compose up`. This starts a postgres database, an acivemq broker, 
   a keycloak and other things important for running the prototype. This must only be done once.
2. In another tab of your terminal call `./gradlew :commonModuleRuntime:bootRun` to start the runtime itself. 
3. In a third tab of your terminal start call `./gradlew :clients:java:run` to start the small java client.
4. In the client step to tab 'Admin' and select 'jar' in the combobox. 
5. Install all modules by clicking button *Install all modules*. This installs everything under _clients/java/build/example/jar_
6. Start all modules by clicking button *Start all modules*
7. When clicking on button *Get status* you see the state of the installed modules. 
8. You can start/stop one dedicated service by clicking button *Stop/Start* in the list.

## Runtime docker
The subproject 'commonModuleRuntime' provides a small runtime which enables starting independent services.
1. In subproject clients/java call `docker-compose up`. This starts a postgres database, an acivemq broker,
   a keycloak and other things important for running the prototype. This must only be done once.
2. In another tab of your terminal call `./gradlew :commonModuleRuntime:bootRun` to start the runtime itself.
3. In a third tab of your terminal start call `./gradlew :clients:java:run` to start the small java client.
4. In the client step to tab 'Admin' and select 'docker' in the combobox.
5. Install all modules by clicking button *Install all modules*. This installs everything under _clients/java/build/example/jar_
6. Start all modules by clicking bu tton *Start all modules*
7. When clicking on button *Get status* you see the state of the installed modules.
8. You can start/stop one dedicated service by clicking button *Stop/Start* in the list.

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
























