package com.example.ecommercebackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // /api/ အောက်မှာရှိတဲ့ APIs တွေ အားလုံးကို ခွင့်ပြု
                .allowedOrigins("http://localhost:8081") // Frontend ရဲ့ URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // အသုံးပြုခွင့်ပေးမယ့် HTTP Methods တွေ
                .allowCredentials(true);
    }
}

