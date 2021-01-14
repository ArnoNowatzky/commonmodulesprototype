
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


# Additional infos 
- vpcmawinta01-x.intra.vsa.de contains elk stack that will be provided in Noventi
- Download .net core sdk for macos: https://dotnet.microsoft.com/download/dotnet/thank-you/sdk-5.0.102-macos-x64-installer
- Download .net framework https://support.microsoft.com/en-us/help/4054530/microsoft-net-framework-4-7-2-offline-installer-for-windows

- Build a .net framework in c#: https://www.medo64.com/2019/04/using-visual-studio-code-for-net-framework-projects-in-c-sharp/

https://logz.io/blog/installing-the-elk-stack-on-windows/


# Important architectural decisions

Monitoring: 
Standalone: ELK, Grafana
Kubernetes: EFK, Grafana/Prometheus für Monitoring



dotnet Framework

->dotnet Core
