package com.kedu.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
<<<<<<< HEAD
=======
//
//    private static final String[] allowedOrigins = {
//        "http://localhost:3000",
//        "https://your-production-domain.com"
//    };
>>>>>>> 1b9d9fca489ae22cb6ceab61449142df325ea092

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("*");
<<<<<<< HEAD
=======
//            .allowCredentials(true);
>>>>>>> 1b9d9fca489ae22cb6ceab61449142df325ea092
    }
}
