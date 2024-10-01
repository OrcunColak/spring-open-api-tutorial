package com.colak.springtutorial.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// springdoc.title=Application demo
// springdoc.version=1.0.0-RC
@Configuration
@OpenAPIDefinition
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Hello Service Api Doc")
                .version("1.0.0")
                .description("HTTP APIs to test Open API.")
                .contact(getContact())
                .termsOfService("http://swagger.io/terms/")
                .license(getLicense());
    }

    private Contact getContact () {
        return new Contact().name("Orçun Çolak");
    }

    private License getLicense() {
        return new License().name("Apache 2.0").url("http://springdoc.org");
    }
}
