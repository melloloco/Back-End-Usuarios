package com.pizzeria.pizzeria.core;

import com.pizzeria.pizzeria.core.exceptions.NotFoundException;
import com.pizzeria.pizzeria.core.functionalInterfaces.FindByEmail;
import com.pizzeria.pizzeria.core.functionalInterfaces.FindById;

import reactor.core.publisher.Mono;

public class ApplicationBase<T, ID> {
    private FindById<T, ID> getById;
    private FindByEmail<T, String> getByEmail;
    protected ApplicationBase(FindById<T, ID> getById, FindByEmail<T, String> getByEmail){
        this.getById = getById;
        this.getByEmail = getByEmail;
    }
    
    protected Mono<T> findById(ID id){
        return this.getById.findById(id).switchIfEmpty(Mono.error(new NotFoundException("There isn't any ingredient with the id: " + id)));
    }
    protected Mono<T> findByEmail(String email){
        return this.getByEmail.findByEmail(email).switchIfEmpty(Mono.error(new NotFoundException("There isn't any user with the email: " + email)));
    }
    protected String serializeObject(T entity, String message) {

        return String.format("%s %s succesfully.", entity.toString(), message);
    }
}
