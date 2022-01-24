package com.pizzeria.pizzeria.core.functionalInterfaces;

import reactor.core.publisher.Mono;

public interface FindById<T, ID> {
    Mono<T> findById(ID id);
}
