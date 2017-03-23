# cereebro-samples

Project home : http://cereebro.io

The following samples are Spring Boot applications, you can see them deployed on Heroku if you don't want to check out the code.

If you want to run them locally, you should activate the Spring profile named `local` to target URLs on your machine :

 * From eclipse : add `--spring.profiles.active=local` in _Run configurations... > cereebro-sample-xxx > Arguments > Program arguments_ 
 * Using maven (in the sample project directory) : `mvn spring-boot:run -Dspring.profiles.active=local`
 * Launching a packaged sample : `java -jar cereebro-sample-xxx.jar --spring.profiles.active=local`

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

## Spring Boot samples

Using Spring Boot only, the Cereebro Server has to hold a list of every Snitch endpoint in the system.  
When a user opens the `/cereebro/system` page, the server accesses each `Snitch` to reconstitute the whole graph. 
Because we don't handle security at the moment, the `/cereebro/snitch` endpoint on each web application has to be 
accessible by the Cereebro Server without any authentication mechanism.  

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
