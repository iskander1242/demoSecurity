# report-system

## Requirements

For building and running the application you need:

- [JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


## Database
Report-system uses a PostgreSQL database.

Datasource settings stored in `application.yml`.

To run PostgreSQL with  [Docker](https://www.docker.com/):

```shell
docker-compose up
```


## Running the application locally

Execute the `main` method in the `ru.tecforce.minobr.report.demo.DemoReportApplication` class from your IDE.

or

Run with the Spring Boot Maven plugin:

```shell
mvn spring-boot:run
```


##  Building the application

```shell
mvn clean install
```


## Running tests

```shell
mvn clean test
```

## Open Api
http://localhost:8080/swagger-ui/index.html
http://localhost:8080/v3/api-docs

https://www.bezkoder.com/spring-boot-swagger-3/