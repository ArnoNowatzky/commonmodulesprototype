#Docker
- Create docker network to be reused in services: https://tjtelan.com/blog/how-to-link-multiple-docker-compose-via-network/

#Keycloak
Keycloak: http://localhost:8080/auth (cm/cm)

KeyCloak for C#: https://www.youtube.com/watch?v=k_iwekNh-_A
KeyCloak for WPF: https://stackoverflow.com/questions/63044966/keycloak-in-c-sharp-wpf-application-how-can-i-access-the-roles-of-a-given-user
https://login-master.com/blog/keycloak-net-adapter-in-microsoft-visual-studio-nutzen/
https://dzone.com/articles/adding-authentication-to-a-native-desktop-c-app-wi


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


## Ressourcen
- Runtime benötigt 120MB RAM
- UI benötigt 258MB
- Service benötigt 448MB

-----
dotnet Framework

->dotnet Core

