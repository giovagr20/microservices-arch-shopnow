package com.shop.now.ms.configurations;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfigurationSource;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfiguration implements CorsConfigurationSource {
    @Value(("${cors.url-allowed}"))
    private String url;


    @Override
    public org.springframework.web.cors.CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        return config;
    }

//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
//        final HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, HEAD");
//        response.setHeader("Access-Control-Allow-Headers",
//                "access-control-allow-methods, access-control-allow-origin, X-APP-RELAYSTATE, X-XSRF-TOKEN, Content-Type, Accept, Origin, Cookie, Authorization");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            chain.doFilter(req, res);
//        }
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
}
