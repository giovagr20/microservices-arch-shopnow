package com.shop.now.ms.feignclient;

import com.shop.now.ms.configurations.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users", url = "${external.user.controller}", configuration = FeignConfiguration.class)
public interface UserClient {
    @GetMapping()
    ResponseEntity<Boolean> getUserMessage();
}
