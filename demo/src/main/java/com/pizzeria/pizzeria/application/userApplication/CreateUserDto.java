package com.pizzeria.pizzeria.application.userApplication;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.pizzeria.pizzeria.domain.userDomain.Rol;

import org.springframework.validation.annotation.Validated;

@Validated
public @Getter @Setter class CreateUserDto {
    @NotBlank @Size(min=1, max=20)
    private String name;
    @NotBlank @Size(min=1, max=20)
    private String lastName;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min=8, max=16)
    private String password;
    private String provider;
    private Rol rol = Rol.USER;
    private String type;
    private String accessToken;
}