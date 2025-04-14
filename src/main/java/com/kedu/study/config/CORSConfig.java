package com.kedu.study.config;


@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override	
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("*");

    }

}
