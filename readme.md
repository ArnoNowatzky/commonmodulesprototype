
This is a complete prototype for handling common modules in *WawiNeu*

# Initially build and run the prototype
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

# Central module with REST
The subproject 'commonModuleService' provides a customerservice with a REST api. 
It uses the [openapi spec](api/src/main/api/service/service.yaml) to define the API. 
The module itself is uploaded to mavenlocal (~/.m2/repository/de/noventi/cm/commonModuleService/)
to be installable in the further prototype

# Central module with UI
The subproject 'commonModuleUi' provides a customerservice with a REST api and an angular app to administrate customers.
It uses the [openapi spec](api/src/main/api/service/service.yaml) to define the API
The module itself is uploaded to mavenlocal (~/.m2/repository/de/noventi/cm/commonModuleUi/) 
to be installable in the further prototype. 

# Central module with Event based communication 
(Active MQ https://medium.com/@mailshine/activemq-getting-started-with-springboot-a0c3c960356e)

# Runtime exectuable jar
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

# Runtime docker
The subproject 'commonModuleRuntime' provides a small runtime which enables starting independent services.
1. In subproject clients/java call `docker-compose up`. This starts a postgres database, an acivemq broker,
   a keycloak and other things important for running the prototype. This must only be done once.
2. In another tab of your terminal call `./gradlew :commonModuleRuntime:bootRun` to start the runtime itself.
3. In a third tab of your terminal start call `./gradlew :clients:java:run` to start the small java client.
4. In the client step to tab 'Admin' and select 'docker' in the combobox.
5. Install all modules by clicking button *Install all modules*. This installs everything under _clients/java/build/example/jar_
6. Start all modules by clicking button *Start all modules*
7. When clicking on button *Get status* you see the state of the installed modules.
8. You can start/stop one dedicated service by clicking button *Stop/Start* in the list.

# Autogenerate documentation of common module
After initially build the project you only have to call 
```
./gradlew :api:serve
``` 
and your browser is opened with the generated documentation.
This should show the possibility to automatically generate api documentation from spec and can be used for both 
common modules and point of sale documentation.

# Native browser component
# Security with https and jwt

#Collect operatingsystem infos 
On http://vpcmawinta01-x.intra.vsa.de:5601 we have established a ELK Stack where you can see environment infos 
which are collected by the prototype. (username: elastic, password: changeme)
The elasticsearch is accessible via://vpcmawinta01-x.intra.vsa.de:9200/
Data is stored on vpcmawinta01-x.intra.vsa.de:9200/wawi/cm/hardware
You can get an overview here: http://vpcmawinta01-x.intra.vsa.de:5601/app/discover

(MetricBeat:     http://vpcmawinta01-x.intra.vsa.de:5601/app/home#/tutorial/systemMetrics)

# Datacenter components on vpcmawinta01-x
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
- First usage of windows: is java allowed?

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




















