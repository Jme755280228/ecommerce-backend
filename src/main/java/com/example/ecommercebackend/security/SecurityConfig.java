package com.example.ecommercebackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF ကို ပိတ်ထားခြင်း
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/jobs/**").permitAll() // /api/jobs အောက်က path အားလုံးကို ဝင်ခွင့်ပြု
                .requestMatchers("/api/applicants/**").permitAll() // /api/applicants အောက်က path အားလုံးကို ဝင်ခွင့်ပြု
                .anyRequest().authenticated() // ကျန်တဲ့ path တွေအတွက် authentication လိုအပ်
            );
        return http.build();
    }
}

