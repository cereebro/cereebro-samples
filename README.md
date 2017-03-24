# cereebro-samples

Project home : http://cereebro.io

The following samples are Spring Boot applications, you can see them deployed on Heroku if you don't want to check out the code.

If you want to run them locally, you should activate the Spring profile named `local` to target URLs on your machine :

 * From eclipse : add `--spring.profiles.active=local` in _Run configurations... > cereebro-sample-xxx > Arguments > Program arguments_ 
 * Using maven (in the sample project directory) : `mvn spring-boot:run -Dspring.profiles.active=local`
 * Launching a packaged sample : `java -jar cereebro-sample-xxx.jar --spring.profiles.active=local`

## Spring Cloud Netflix samples

Read [how to get started](https://github.com/cereebro/cereebro/wiki/Using-Cereebro-with-Spring-Cloud-Netflix-and-the-Eureka-Server) with Cereebro and Spring Cloud Netflix.

![cereebro-spring-cloud-netflix-component-diagram](https://cereebro.github.io/images/cereebro-eureka.png)

### cereebro-sample-cloud-netflix-server-eureka-app1

Spring Cloud application shipping the Cereebro Snitch.

 * Snitch endpoint : https://cereebro-netflix-app1.herokuapp.com/cereebro/snitch

### cereebro-sample-cloud-netflix-server-eureka-app2

Spring Cloud application shipping the Cereebro Snitch.    
It has a dependency on the previous application through a `@FeignClient` bean.

* Snitch endpoint : https://cereebro-netflix-app2.herokuapp.com/cereebro/snitch

### cereebro-sample-cloud-netflix-server-eureka-addon

Cereebro Server as a Eureka Server extension -- 2-in-1 server.  
You should see [app1](#cereebro-sample-cloud-netflix-server-eureka-app2) and 
[app2](#cereebro-sample-cloud-netflix-server-eureka-app2) 
registered as Eureka service instances. 

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
The result is actually the same, the difference being that this standalone Cereebro Server 
has to make a remote call to the Eureka Server HTTP API.  
You can use this strategy if you don't want to mix up your service registry and component graph resolution.

See it deployed : 

 * System graph page : https://cereebro-netflix-eureka-client.herokuapp.com/cereebro/system
 * System JSON resource : https://cereebro-netflix-eureka-client.herokuapp.com/cereebro/system.json

## Spring Boot samples

Using Spring Boot only, the Cereebro Server has to hold a list of every Snitch endpoint in the system.  
When a user opens the `/cereebro/system` page, the server accesses each `Snitch` to reconstitute the whole graph. 
Because we don't handle security at the moment, the `/cereebro/snitch` endpoint on each web application has to be 
accessible by the Cereebro Server without any authentication mechanism.  

![cereebro-spring-boot-component-diagram](https://cereebro.github.io/images/cereebro-boot.png)

See the [Spring Cloud Netflix samples](#spring-cloud-netflix-samples) for a more powerful way to use Cereebro.

### cereebro-sample-boot-snitch

Simple Spring Boot application with only a Snitch endpoint that reveals the application's dependencies.

See it deployed :

 * Snitch endpoint : https://cereebro-sample-boot-snitch.herokuapp.com/cereebro/snitch

### cereebro-sample-boot-server

Plain Spring Boot Cereebro server that targets a static list of snitches, 
including a couple files on the classpath, and the previous application.

It will aggregate the results of :

 * [classpath:snitches/spiderman.json](cereebro-sample-boot-server/src/main/resources/snitches/spiderman.json)
 * [classpath:snitches/xmen.json](cereebro-sample-boot-server/src/main/resources/snitches/xmen.json)
 * `cereebro-sample-boot-snitch`'s [Snitch endpoint](https://cereebro-sample-boot-snitch.herokuapp.com/cereebro/snitch)

See it deployed :

 * System graph page : https://cereebro-sample-boot-server.herokuapp.com/cereebro/system
 * System JSON resource : https://cereebro-sample-boot-server.herokuapp.com/cereebro/system.json
