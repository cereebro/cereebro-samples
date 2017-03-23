# cereebro-samples

Project home : http://cereebro.io

The following samples are Spring Boot applications. 
They are up and running on Heroku.

## Spring Boot samples

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

## Spring Cloud Netflix samples

### cereebro-sample-cloud-netflix-server-eureka-addon

Cereebro Server as a Eureka Server extension.

**TODO : See it deployed**

### cereebro-sample-cloud-netflix-server-eureka-client

Standalone Cereebro Server that acts as a Eureka Client, 
consuming the Eureka Server's API.

**TODO : See it deployed**

### cereebro-sample-cloud-netflix-server-eureka-app1

Spring Cloud application shipping the Cereebro Snitch.

**TODO : See it deployed**

### cereebro-sample-cloud-netflix-server-eureka-app2

Spring Cloud application shipping the Cereebro Snitch,  
it has a dependency on the previous application.

**TODO : See it deployed**
