package com.rpcwebservice.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    @Value("${marianvf.openapi.dev-url}")
    private String devUrl;

    /*@Value("${bezkoder.openapi.prod-url}")
    private String prodUrl;*/

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("URL del servidor en ambiente de desarrollo");

        /*Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");
        */
        Contact contact = new Contact();
        contact.setEmail("marianovf19@outlook.com");
        contact.setName("MarianoV");
        contact.setUrl("https://www.linkedin.com/in/mariano-vergara-54874b1a8");

        Info info = new Info()
                .title("WebService Registro Centro Pymes API ")
                .version("1.0")
                .contact(contact)
                .description("Esta api expone los endpoints utilizados para manejar los datos del Registro Publico de Comercio.");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
