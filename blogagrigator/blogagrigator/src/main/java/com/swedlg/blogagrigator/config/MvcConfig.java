package com.swedlg.blogagrigator.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");

        registry.addResourceHandler("/newest_blogs/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/newest_blogs/img/**")
                .addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/newest_blogs/js/**")
                .addResourceLocations("classpath:/static/js/");
    }
}
