package com.jedco.jedcoinspectionspring.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
//@OpenAPIDefinition(info=@Info(title="JEDCO Power Juba",
//        description = "REST API For JEDCO Middleware Webservice",
//        version = "2.0", contact = @Contact(name = "",email = "support@jedcopower.com")
//))
@OpenAPIDefinition(info = @Info())
public class OpenApiConfiguration {
}
