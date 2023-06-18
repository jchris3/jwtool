package com.pooltpv.api.jwtpool.Repository;

import com.pooltpv.api.jwtpool.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsersRepository extends CrudRepository<Users, UUID> {
}
