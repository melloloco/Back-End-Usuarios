package com.pizzeria.pizzeria.application;

import reactor.core.publisher.Mono;

public interface Add<T,R> {
    public Mono<R> add(T dto);
}
