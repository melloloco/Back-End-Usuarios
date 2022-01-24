package com.pizzeria.pizzeria.infrastructure.userRepository;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.userDomain.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User, UUID> {

    @Query("SELECT name FROM users WHERE (name LIKE CONCAT('%', :name, '%')) ORDER BY name;")
    Flux<User> findByName(String name);

    @Query("SELECT email FROM users WHERE (email LIKE :email) ORDER BY email;")
    Mono<User> findByEmail(String email);
}
