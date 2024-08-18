package com.example.repository;

import com.example.entitiy.Auth;

import java.util.Optional;

public interface AuthRepository extends GenericRepository<Auth, Long> {
    Optional<Object> findByUsernameAndPassword(String username, String password);
}
