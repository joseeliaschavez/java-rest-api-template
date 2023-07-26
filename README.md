# java-rest-api-template

A template showcasing best practices for implementing a REST API in Java SpringBoot.

The template showcases building a REST API using the movie industry as the domain.
It stores a small set of movie and actor data in an embedded database and integrates with 
an open movie dataset ([TMDB API](https://developer.themoviedb.org/docs)).

## Architecture

This template uses clean architecture concepts to define package structure and class dependencies. It's enforced 
using [ArchUnit](https://github.com/TNG/ArchUnit-Examples/blob/main/example-junit5/src/test/java/com/tngtech/archunit/exampletest/junit5/OnionArchitectureTest.java) 
via a [unit test](./src/test/java/com/slalombuild/movieman/CleanArchitectureTests.java).

This template attempts to use the [12-Factor App](https://www.redhat.com/architect/12-factor-app) guidelines to model 
a scalable REST API in Java.

### Constructor vs. Field Dependency Injection

There are strong opinions on using constructor injection over field injection. Constructor injection is generally 
considered a better practice for dependency injection, as it makes the dependencies explicit and allows for 
easier testing and immutability.

For this template, we've chosen to use field injection to leverage Lombok's auto constructor generation. We added a 
[config rule](./lombok.config) to tell Lombok to copy desired annotations on the private fields to the constructor 
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
