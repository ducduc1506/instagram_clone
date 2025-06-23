package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Tắt CSRF (nếu dùng Postman, không có form)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() //  Cho phép tất cả các API
            );
        return http.build();
    }
}
