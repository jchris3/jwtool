package com.pooltpv.api.jwtpool.controller;

import com.pooltpv.api.jwtpool.Repository.UsersRepository;
import com.pooltpv.api.jwtpool.model.Users;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class Initializer implements SmartInitializingSingleton {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public Initializer(UsersRepository usersRepository,PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterSingletonsInstantiated() {
        UUID uuid = UUID.randomUUID();
        //this.usersRepository.save(new Users(uuid,"majohnc",passwordEncoder.encode("chris"),true));
    }
}
