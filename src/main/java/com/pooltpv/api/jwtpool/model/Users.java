package com.pooltpv.api.jwtpool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name="users")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="username",unique = true)
    private String username;
    private String password;
    private boolean enabled;

}
