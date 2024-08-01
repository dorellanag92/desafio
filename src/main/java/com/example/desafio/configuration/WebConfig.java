package com.example.desafio.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Se crea esta clase para evitar problemas relacionados con CORS, 
//que estaban apareciendo al momento de seleccionar facultades y departamentos 
@Configuration
@SuppressWarnings("null")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
}