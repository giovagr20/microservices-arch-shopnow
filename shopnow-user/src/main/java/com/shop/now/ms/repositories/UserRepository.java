package com.shop.now.ms.repositories;

import com.shop.now.ms.models.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
