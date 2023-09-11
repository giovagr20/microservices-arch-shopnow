package com.shop.now.ms.services;

import com.shop.now.ms.models.dtos.ProductDto;
import com.shop.now.ms.models.entities.ProductEntity;
import com.shop.now.ms.models.mappers.ProductMapper;
import com.shop.now.ms.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<ProductDto> createProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toProductEntity(productDto);
        productEntity.setIdProduct(UUID.randomUUID().toString());
        return Optional.ofNullable(productMapper.toProductDto(productRepository.save(productEntity)));
    }

    @Override
    public Optional<List<ProductDto>> getProducts() {
        return Optional.ofNullable(productMapper.toListProductDto(productRepository.findAll()));
    }

    @Override
    public Optional<ProductDto> getProductByName(String idProduct) {
        return Optional.ofNullable(productMapper.toProductDto(
                productRepository.findByNameProduct(idProduct).orElse(null)));
    }

    @Override
    public Optional<ProductDto> updateProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toProductEntity(productDto);
        return Optional.empty();
    }

    @Override
    public void deleteProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toProductEntity(productDto);
        productRepository.delete(productEntity);
    }
}
