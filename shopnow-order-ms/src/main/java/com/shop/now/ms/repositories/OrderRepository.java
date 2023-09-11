package com.shop.now.ms.repositories;

import com.shop.now.ms.models.entities.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}
