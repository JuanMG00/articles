package com.radax.products.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods(HttpMethod.GET.toString(), HttpMethod.POST.toString(),
                        HttpMethod.PUT.toString(), HttpMethod.DELETE.toString(), HttpMethod.PATCH.toString())
                .allowedOrigins("*");
    }

}
