package com.shop.now.ms.models.mappers;

import com.shop.now.ms.models.dtos.ProductDto;
import com.shop.now.ms.models.entities.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    @Mapping(source = "idProduct", target = "idProduct")
    ProductDto toProductDto(ProductEntity productEntity);

    @Mapping(source = "idProduct", target = "idProduct")
    ProductEntity toProductEntity(ProductDto productDto);

    default List<ProductDto> toListProductDto(List<ProductEntity> productEntities) {
        return productEntities
                .stream()
                .map(this::toProductDto)
                .toList();
    }

    default List<ProductEntity> toListProductEntity(List<ProductDto> productDtos) {
        return productDtos
                .stream()
                .map(this::toProductEntity)
                .toList();
    }
}
