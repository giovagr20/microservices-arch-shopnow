package com.shop.now.ms.repositories;

import com.shop.now.ms.models.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    @Query("{ 'idProduct' : ?0 }")
    Optional<ProductEntity> findByNameProduct(String idProduct);
}
