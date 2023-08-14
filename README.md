# java-rest-api-template

A template showcasing best practices for implementing a REST API in Java SpringBoot.

The template showcases building a REST API using the movie industry as the domain.
It stores a small set of movie and actor data in an embedded database and integrates with 
an open movie dataset ([TMDB API](https://developer.themoviedb.org/docs)).

## OpenAPI

OpenAPI documentation has been enabled via Spring-Docs. On application startup, you can browse the documentation
by the following links:

OpenAPI 3.0 Spec: http://localhost:8080/v3/api-docs
Swagger UI: http://localhost:8080/swagger-ui/index.html

Note: The dependency `implementation 'org.springdoc:springdoc-openapi-ui:1.7.0'` will also support OpenAPI documentation. But it cannot be mixed with the starter dependency.

## Architecture

This template uses clean architecture concepts to define package structure and class dependencies. It's enforced 
using [ArchUnit](https://github.com/TNG/ArchUnit-Examples/blob/main/example-junit5/src/test/java/com/tngtech/archunit/exampletest/junit5/OnionArchitectureTest.java) 
via a [unit test](./src/test/java/com/slalombuild/movieman/CleanArchitectureTests.java).

This template attempts to use the [12-Factor App](https://www.redhat.com/architect/12-factor-app) guidelines to model 
a scalable REST API in Java. Those guidelines are:

1. One codebase, one application 
2. Dependency management 
3. Design, build, release, and run 
4. Configuration, credentials, and code 
5. Logs 
6. Disposability 
7. Backing services 
8. Environment parity 
9. Administrative processes 
10. Port binding 
11. Stateless processes 
12. Concurrency

There is also the [15-Factor App](https://developer.ibm.com/articles/15-factor-applications/)
guidelines to be considered, which introduces _API First_, _Telemetry_, and _Auth/Authz_ as additional 
factors.

### Constructor vs. Field Dependency Injection

There are strong opinions on using constructor injection over field injection. Constructor injection is generally 
considered a better practice for dependency injection, as it makes the dependencies explicit and allows for 
easier testing and immutability.

For this template, we're using constructor injection by leveraging Lombok's auto constructor generation. We added a 
[config rule](./lombok.config) telling Lombok to copy desired annotations from the private fields to the constructor 
on code generation.

## Entity Relationships

The entity relationships defined in this sample project are documented in [an ERD diagram](./documentation/DatabaseEntityRelationships.md). 

## Integration Tests

The integration tests are tests configured to run against a Spring container.

The integration tests are configured in the `gradle\integration.gradle` file 
and the source is found in `src/integration/java`.
The tests run using SpringBoot extensions. They run using either `SpringBootTest` or `DataJpaTest`.

To execute the integration tests, run the command
```bash
./gradlew integrationTest
```

### Wiremock Usage

Wiremock is mocking TMDB API responses for integration tests. 
- The stub files can be found in `src/integration/resources/wiremock`.
- The test class [MovieControllerIntegrationTests](./src/integration/java/com/slalombuild/movieman/web/MovieControllerIntegrationTests.java)
configures an in-memory Wiremock server using [a JUnit extension](https://wiremock.org/docs/junit-jupiter/#advanced-usage---programmatic).
- Normally, Wiremock looks for stub files in `src/test/resources` but this project has a different directory structure; therefore 
we've overwritten the default path in the extension.

## Tech Stack
* Java JDK 17
* SpringBoot

### Developer Experience Tools
* Spotless - Provides linting to the Java source code.
* JaCoCo - Provides test coverage reporting.
* H2 Database - An in-memory database used for testing and local development.
