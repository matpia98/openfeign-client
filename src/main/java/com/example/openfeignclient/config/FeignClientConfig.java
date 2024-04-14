package com.example.openfeignclient.config;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
