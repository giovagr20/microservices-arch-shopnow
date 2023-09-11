package com.shop.now.ms.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String idProduct;
    private String productName;
    private String description;
    private String createdAt;
    private String createdBy;
    private String updatedBy;
    private String updatedAt;
}
