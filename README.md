# cereebro-samples

Project home : [cereebro.io](http://cereebro.io)

## TL;DR;

See Cereebro in action here : http://sample.cereebro.io


## Running locally

If you want to run the samples locally, you should activate the Spring profile named `local` to target URLs on your machine :

 * From eclipse : add `--spring.profiles.active=local` in _Run configurations... > cereebro-sample-xxx > Arguments > Program arguments_ 
 * Using maven (in the sample project directory) : `mvn spring-boot:run -Dspring.profiles.active=local`
 * Launching a packaged sample : `java -jar cereebro-sample-xxx.jar --spring.profiles.active=local`

## Details

Read [how to get started](http://docs.cereebro.io/Getting-Started) with Cereebro and Spring Cloud Netflix.

![cereebro-eureka-addon-diagram](https://cereebro.github.io/images/cereebro-eureka-addon.png)

This sample is made of 3 main applications :

 * [`cereebro-sample-cloud-netflix-server-eureka-addon`](#cereebro-sample-cloud-netflix-server-eureka-addon) : Cereebro Server + Eureka Server (2-in-1) 
 * [`cereebro-sample-cloud-netflix-server-eureka-app1`](https://cereebro-netflix-app1.herokuapp.com/cereebro/snitch) : Spring Cloud application
 * [`cereebro-sample-cloud-netflix-server-eureka-app2`](https://cereebro-netflix-app2.herokuapp.com/cereebro/snitch) : Another Spring Cloud application with a dependency on the first one

If you don't want to mix-up your Eureka Server with Cereebro, you can check out [`cereebro-sample-cloud-netflix-server-eureka-client`](#cereebro-sample-cloud-netflix-server-eureka-client) which targets the Eureka Server remotely.

### cereebro-sample-cloud-netflix-server-eureka-addon

Cereebro Server as a Eureka Server extension -- 2-in-1.  
You should see app1 and app2 registered as Eureka service instances. 

The Cereebro Snitch for Spring Cloud detects relationship from the application, 
then pushes the information as additional meta-data on the Eureka Server.

When you access the system graph page, the server browses its internal instance registry 
to aggregate all the metadata available (from both app1 and app2).

See it deployed :

 * Eureka Dashboard : https://cereebro-netflix-eureka-server.herokuapp.com/
 * System graph page : https://cereebro-netflix-eureka-server.herokuapp.com/cereebro/system
 * System JSON resource : https://cereebro-netflix-eureka-server.herokuapp.com/cereebro/system.json

### cereebro-sample-cloud-netflix-server-eureka-client

Standalone Cereebro Server that acts as a Eureka Client, 
consuming the Eureka Server API.  

This is an alternative to [2-in-1](#cereebro-sample-cloud-netflix-server-eureka-addon) solution above.   

![cereebro-eureka-client-diagram](https://cereebro.github.io/images/cereebro-eureka.png)

The result is actually the same, the difference being that this standalone Cereebro Server 
has to make a remote call to the Eureka Server HTTP API.  
You can use this strategy if you don't want to mix up your service registry and component graph resolution.

See it deployed : 

 * System graph page : https://cereebro-netflix-eureka-client.herokuapp.com/cereebro/system
 * System JSON resource : https://cereebro-netflix-eureka-client.herokuapp.com/cereebro/system.json
