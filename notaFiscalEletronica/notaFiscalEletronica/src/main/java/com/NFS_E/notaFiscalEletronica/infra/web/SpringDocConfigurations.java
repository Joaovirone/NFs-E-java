package com.NFS_E.notaFiscalEletronica.infra.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {
    
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("bearer-key",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
                        .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
            
            .info(new Info()
                .title("API de Nota Fiscal Eletrônica")
                .description("API REST para emissão, autorização e cancelamento de Notas Fiscais Eletrônicas")
                .contact(new Contact()
                    .name("Joãovirone Backend")
                    .email("jovmamikl@gmail.com")));

    }
}
