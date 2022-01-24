package com.pizzeria.pizzeria.core;

import java.util.Set;
import java.util.UUID;

import javax.persistence.MappedSuperclass;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.pizzeria.pizzeria.core.exceptions.BadRequestException;
import com.pizzeria.pizzeria.core.functionalInterfaces.FindBy;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@MappedSuperclass
public @Getter @Setter abstract class EntityBase implements Persistable<UUID> {
    @Id
    @Column
    private UUID id;
    @Transient
    private boolean isThisNew = false;
    @Override
    public boolean isNew(){
        return this.isThisNew;
    }
    private void validate(){
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<EntityBase>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            BadRequestException badRequestException = new BadRequestException();
            for(ConstraintViolation<EntityBase> violation : violations){
                badRequestException.addException(violation.getPropertyPath().toString(), violation.getMessage());
            }
            //throw badRequestException;
        }
    }
    public <COLUMN, ENTITY> Mono<Void> validate(FindBy<COLUMN, ENTITY> findBy, COLUMN dataToSearch){
        this.validate();
        return findBy.find(dataToSearch)
            .flatMap(foundEntity -> {
                System.out.println("Entra -- encontrado --");
                BadRequestException badRequestException = new BadRequestException();
                badRequestException.addException(dataToSearch.toString(), dataToSearch + " is duplicated.");
                return Flux.error(badRequestException);
            }).then();
    }
    @Override
    public boolean equals (Object obj) {

        if (!(obj instanceof EntityBase)){
            return false;
        }

        EntityBase tmpEntity = (EntityBase) obj;

        return this.id.equals(tmpEntity.id);
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
}
