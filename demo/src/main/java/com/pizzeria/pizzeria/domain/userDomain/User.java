package com.pizzeria.pizzeria.domain.userDomain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.pizzeria.pizzeria.core.EntityBase;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("users")
public @Getter @Setter class User extends EntityBase {
    @Column
    @NotBlank
    @Size(max = 15)
    private String name;
    @Column
    @NotBlank
    @Size(max = 15)
    private String lastName;
    @Column
    @NotBlank
    @Size(max = 16)
    private String email;
    @Column
    @NotBlank
    private String password;
    @Column
    @NotBlank
    private Rol rol = Rol.USER;
    @Column
    @NotBlank
    private String provider;
    @Column
    @NotBlank
    private String generatedSalt;
}
