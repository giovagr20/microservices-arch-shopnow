package com.shop.now.ms.configurations;

import com.shop.now.ms.configurations.interceptors.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    private final RequestInterceptor interceptor;

    @Autowired
    public InterceptorConfiguration(RequestInterceptor interceptor) {
        this.interceptor = interceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
