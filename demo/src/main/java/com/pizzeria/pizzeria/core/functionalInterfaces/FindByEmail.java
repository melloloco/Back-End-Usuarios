package com.pizzeria.pizzeria.core.functionalInterfaces;

import reactor.core.publisher.Mono;

public interface FindByEmail<T, String> {
    Mono<T> findByEmail(String email);
}
