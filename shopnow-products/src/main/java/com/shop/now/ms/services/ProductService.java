package com.shop.now.ms.services;

import com.shop.now.ms.models.dtos.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<ProductDto> createProduct(ProductDto productDto);

    Optional<List<ProductDto>> getProducts();

    Optional<ProductDto> getProductByName(String idProduct);

    Optional<ProductDto> updateProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto);
}
