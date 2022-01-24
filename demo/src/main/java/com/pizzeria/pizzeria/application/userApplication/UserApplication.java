package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import reactor.core.publisher.Mono;

public interface UserApplication {
    Mono<UserOutDto> add(CreateUserDto createUserDto);
    Mono<Boolean> login(LoginUserDto loginUserDto);
    Mono<UserDto> get(String email);
    Mono<Void> update(UUID id, CreateUserDto createUserDto);
}