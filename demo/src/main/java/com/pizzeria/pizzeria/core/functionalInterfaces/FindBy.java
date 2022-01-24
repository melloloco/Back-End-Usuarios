package com.pizzeria.pizzeria.core.functionalInterfaces;

import reactor.core.publisher.Flux;

public interface FindBy<T, R> {
    Flux<R> find(T data);
}
