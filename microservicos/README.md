# Backend

This is a Spring Boot project microservices.

## Compile and package

Being Maven centric, you can compile and package it without tests using 
```
mvn clean compile -DskipTests
```
Once you have your jar file, you can run it.

## Run it

To run it you can execute the Spring Boot maven target.
You can execute docker-compose too. 
```
mvn spring-boot:run
docker-compose up 
```

