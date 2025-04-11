package com.kedu.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
<<<<<<< HEAD


=======
>>>>>>> 37ec926a90b5c8b92c1029962849171c43d74104

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOriginPatterns("*")
            .allowedMethods("*")
            .allowedHeaders("*");
<<<<<<< HEAD

=======
>>>>>>> 37ec926a90b5c8b92c1029962849171c43d74104
    }
}
