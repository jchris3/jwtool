package com.pooltpv.api.jwtpool.controller;

import com.pooltpv.api.jwtpool.Repository.UsersRepository;
import com.pooltpv.api.jwtpool.model.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
public class HomeController {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public HomeController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/")
    public String home(Principal principal){

        UUID id = UUID.randomUUID();
        //this.usersRepository.save(new Users(id,"majohnc",passwordEncoder.encode("chris"),true));
        return "Hello, "+ principal.getName();
    }

    @PostMapping(path = "/users",consumes="application/json")
    public Users home(@RequestParam(value="username")  String username, @RequestParam(value="password")  String password){
        UUID id = UUID.randomUUID();
        Users user = new Users(id,username,passwordEncoder.encode(password),true);
        return this.usersRepository.save(user);
    }
}
