package com.jedco.jedcoinspectionspring.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map requests for /emergency/** to the corresponding static files
        registry.addResourceHandler("/inspection/**")
                .addResourceLocations("classpath:/static/inspection/");

        // Map requests for /cms_lab/** to the corresponding static files
        registry.addResourceHandler("/inspection_sales/**")
                .addResourceLocations("classpath:/static/inspection_sales/");

        // Map requests for /sales/** to the corresponding static files
        registry.addResourceHandler("/inspection_legal/**")
                .addResourceLocations("classpath:/static/inspection_legal/");

    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/JedcoInspection/rest", c -> c.isAnnotationPresent(RestController.class));
    }
}