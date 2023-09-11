package com.shop.now.ms.configurations.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Base64;

public class BasicAuthInterceptor implements RequestInterceptor {
    private final String username;
    private final String password;

    public BasicAuthInterceptor(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public void apply(RequestTemplate template) {
        String credentials = username + ":" + password;
        String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        template.header("Authorization", "Basic " + base64Credentials);
    }
}
