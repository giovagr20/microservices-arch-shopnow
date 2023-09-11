package com.shop.now.ms.configurations;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Value("${external.product.controller}")
    private String url;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    okhttp3.Request request = chain.request()
                            .newBuilder()
                            .header("Authorization", Credentials.basic("andrea@gmail.com", "12345"))
                            .build();
                    return chain.proceed(request);
                })
                .build();
    }
}


