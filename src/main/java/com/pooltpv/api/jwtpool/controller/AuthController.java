package com.pooltpv.api.jwtpool.controller;

import com.pooltpv.api.jwtpool.service.TokenService;
import com.pooltpv.api.jwtpool.model.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private  final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService,AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public ResponseEntity<String> token(@RequestBody LoginRequest userLogin){

       if(userLogin.username()==null| userLogin.password()==null){
           return new ResponseEntity<>("Username and password is required", HttpStatus.UNAUTHORIZED);
       }
        Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(userLogin.username(),userLogin.password())
        );
        return new ResponseEntity<>(tokenService.generaToken(authentication),HttpStatus.OK);
    }
}
