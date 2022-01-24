package com.pizzeria.pizzeria.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserOutDto {
    private String email = "Bearer";
    private String accessToken;
    private String expireSeconds = "3600";
    private String refreshToken;
}
