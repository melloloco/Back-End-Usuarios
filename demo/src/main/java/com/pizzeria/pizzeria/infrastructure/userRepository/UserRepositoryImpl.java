package com.pizzeria.pizzeria.infrastructure.userRepository;


import java.util.UUID;

import com.pizzeria.pizzeria.domain.userDomain.User;
import com.pizzeria.pizzeria.domain.userDomain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private UserR2dbcRepository userR2dbcRepository;
    @Autowired
    public UserRepositoryImpl(final UserR2dbcRepository userR2dbcRepository){
        this.userR2dbcRepository = userR2dbcRepository;
    }
    @Override
    public Mono<User> add(User user) {
        return userR2dbcRepository.save(user);
    }
    @Override
    public Mono<User> findById(UUID id) {
        return userR2dbcRepository.findById(id);
    }
    @Override
    public Mono<Void> update(User user) {
        return userR2dbcRepository.save(user).then();
    }
    @Override
    public Flux<User> findByName(String name) {
        return userR2dbcRepository.findByName(name);
    }
    @Override
    public Mono<User> findByEmail(String email) {
        return userR2dbcRepository.findByEmail(email);
    }
}