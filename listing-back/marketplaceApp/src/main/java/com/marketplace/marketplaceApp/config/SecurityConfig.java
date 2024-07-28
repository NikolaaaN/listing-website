package com.marketplace.marketplaceApp.config;

//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import java.io.IOException;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .requestMatchers("/user/register").permitAll() // Allow access to the registration endpoint
//                .anyRequest().authenticated() // Protect other endpoints
//                .and()
//                .formLogin().disable() // Disable the default login form
//                .httpBasic().disable() // Disable basic authentication
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Use stateless session management
//
//    }
//
//
//
//
//}