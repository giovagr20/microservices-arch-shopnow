package com.shop.now.ms.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI productsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Products MS")
                        .description("Endpoints description products")
                        .version("1.0.0"));
    }
}
