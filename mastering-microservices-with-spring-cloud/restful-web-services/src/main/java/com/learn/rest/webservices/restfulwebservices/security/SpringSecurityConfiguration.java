package com.learn.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        All requests should be authenticated.
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//        A Web page to be shown if the request is not authenticated.
        http.httpBasic(Customizer.withDefaults());
//        Disable CSRF for functioning of PUT, POST
        http.csrf().disable();
        return http.build();
    }
}
