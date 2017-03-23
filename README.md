# cereebro-samples

Project home : http://cereebro.io

The following samples are Spring Boot applications. 
They are up and running on Heroku.

## Spring Boot samples

### cereebro-sample-boot-snitch

Simple Spring Boot application with only a Snitch endpoint that reveals the application's dependencies.

### cereebro-sample-boot-server

Plain Spring Boot Cereebro server that targets a static list of snitches, 
including a couple files on the classpath, and the previous application.

## Spring Cloud Netflix samples

### cereebro-sample-cloud-netflix-server-eureka-addon

Cereebro Server as a Eureka Server extension.

### cereebro-sample-cloud-netflix-server-eureka-client

Standalone Cereebro Server that acts as a Eureka Client, 
consuming the Eureka Server's API.

### cereebro-sample-cloud-netflix-server-eureka-app1

Spring Cloud application shipping the Cereebro Snitch.

### cereebro-sample-cloud-netflix-server-eureka-app2

Spring Cloud application shipping the Cereebro Snitch,  
it has a dependency on the previous application.
