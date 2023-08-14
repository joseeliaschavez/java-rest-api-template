package com.slalombuild.movieman.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "MovieMan API",
                description = "A sample application showcasing Java REST API best practices",
                contact = @Contact(email = "jose.chavez@slalom.com"),
                license = @License(name = "Proprietary")
        )
)
public class OpenApiConfig {
}
