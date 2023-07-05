# java-rest-api-template

A template showcasing best practices for implementing a REST API in Java SpringBoot.

## Entity Relationships

The entity relationships defined in this sample project are documented in the [erd.mermaid](./documentation/erd.mermaid)
file. 

## Integration Tests

The integration tests are tests configured to run against a Spring container.

The integration tests are configured in the `gradle\integration.gradle` file 
and the source is found in `src/integration/java`.
The tests run using SpringBoot extensions. They run using either `SpringBootTest` or `DataJpaTest`.

To execute the integration tests, run the command

```bash
./gradlew integrationTest
```

## Tech Stack
* Java JDK 17
* SpringBoot

## Developer Experience Tools
* Spotless - Provides linting to the Java source code.
* JaCoCo - Provides test coverage reporting.
* H2 Database - An in-memory database used for testing and local development.
