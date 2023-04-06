package com.example.jigumproject.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//swagger 명시
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        Info info =new Info()
                .title("네이버지도따릉이 웹 API 명세서")
                .description("jigum 웹 API 명세서")
                .version("1.0.0");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
