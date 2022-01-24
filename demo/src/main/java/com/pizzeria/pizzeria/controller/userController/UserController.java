package com.pizzeria.pizzeria.controller.userController;

import java.util.UUID;

import javax.validation.Valid;

import com.pizzeria.pizzeria.application.userApplication.CreateUserDto;
import com.pizzeria.pizzeria.application.userApplication.LoginUserDto;
import com.pizzeria.pizzeria.application.userApplication.UserApplication;
import com.pizzeria.pizzeria.application.userApplication.UserDto;
import com.pizzeria.pizzeria.application.userApplication.UserOutDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
public class UserController {
    private final UserApplication userApplication;

    @Autowired
    public UserController(final UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/register/{email}")
    public Mono<UserDto> read(@PathVariable String email) {
        return userApplication.get(email);
    }

    @CrossOrigin( origins = "http://localhost:4200/")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/register" )
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserOutDto> create(@Valid @RequestBody CreateUserDto createUserDto) {
        return this.userApplication.add(createUserDto);
    }

    @CrossOrigin( origins = "http://localhost:4200/")
    @PostMapping(path = "/login" )
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Boolean> login(@Valid @RequestBody LoginUserDto loginUserDto) {
      return this.userApplication.login(loginUserDto);
    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/register/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> update(@PathVariable UUID id, @RequestBody CreateUserDto UserDtoIn) {
        return userApplication.update(id, UserDtoIn);
    }
}
