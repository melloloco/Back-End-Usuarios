package com.pizzeria.pizzeria.application.userApplication;

import java.util.UUID;

import com.pizzeria.pizzeria.domain.userDomain.Rol;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDto {
    private UUID id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private String provider;
    private Rol rol;
    private String type;
    private String accessToken;
    private String generatedSalt;
}
