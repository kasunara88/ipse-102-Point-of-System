package com.ijse.pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
// @EnableWebMvc
@io.swagger.v3.oas.annotations.OpenAPIDefinition
public class SwagerConfigController {

        @Bean
        public OpenAPI openAPI() {
                return new OpenAPI()
                                .info(new Info().title("SpringShop API")
                                                .description("Spring shop application")
                                                .version("v0.0.1")
                                                .contact(new Contact().name("Kasun").email("wmaravinda@gmail.com")
                                                                .url("http://springdoc.org"))
                                                .license(new License().name("Apache 2.0")))
                                .externalDocs(new ExternalDocumentation()
                                                .description("SpringShop Wiki Documentation")
                                                .url("https://springshop.wiki.github.org/docs"));
        }

}
