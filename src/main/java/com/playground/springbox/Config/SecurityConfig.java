package com.playground.springbox.Config;

import com.playground.springbox.Constants.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@SuppressWarnings(AppConstants.UNUSED)
public class SecurityConfig {
    // ToDo: Figure out why this doesn't work with the latest spring version.

    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        // exclude pre-flight response from spring security
        httpSecurity.cors().and().csrf().and().httpBasic().disable();
        
        return httpSecurity.build();
    }
    
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*");
                WebMvcConfigurer.super.addCorsMappings(registry);
            }
        };
    }
}
