package com.pizzeria.pizzeria.domain.userDomain;

import java.util.UUID;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> add(User user);
    Mono<User> findById(UUID id);
    Flux<User> findByName(String name);
    Mono<User> findByEmail(String email);
    Mono<Void> update(User User);
}
