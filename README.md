# java-rest-api-template

A template showcasing best practices for implementing a REST API in Java SpringBoot.

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
* Spotless
* JaCoCo
* H2 Database
