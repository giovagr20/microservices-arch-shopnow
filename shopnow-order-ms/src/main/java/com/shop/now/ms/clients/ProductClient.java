package com.shop.now.ms.clients;

import com.shop.now.ms.configurations.FeignConfiguration;
import com.shop.now.ms.models.dtos.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${external.product.controller}", name = "product"
, configuration = FeignConfiguration.class)
public interface ProductClient {
    @GetMapping("{idProduct}")
    ResponseEntity<Object> getProductById(@PathVariable("idProduct") String idProduct);
}
