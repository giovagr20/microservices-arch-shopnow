package com.shop.now.ms.repositories;

import com.shop.now.ms.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM users WHERE users.email = ?1", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
}
