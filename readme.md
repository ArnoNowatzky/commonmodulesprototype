
This is a complete prototype for handling common modules in *WawiNeu*

# Containment
The following issues should be validated with this prototype:
- **Central module with REST**  
- **Central module with UI**
- **Runtime exectuable jar**
- **Runtime docker**  
- **Autogenerate api client JAVA**
- Autogenerate api client C#
- Central module with Event based communication  
 

- Autogenerate api client C
- Resiliencestrategies
  
- Metrics central module 
- Logging central module (Tracking)
- Security with https and SingleSignOn
- Autogenerate documentation
- postgres database
- Runtime kubernetes (e.g. K3s)
- Integration into Backup / Recovery
- Synchronize different datamodels
- Sonarqube, check security automated
- Ui Integration after WAWI (Polymer, WebComponents...)
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




# Important architectural decisions



dotnet Framework

->dotnet Core
