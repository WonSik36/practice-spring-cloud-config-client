package com.example.configclient;

import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public ApiErrorDecoder apiErrorDecoder() {
        return new ApiErrorDecoder();
    }
}
