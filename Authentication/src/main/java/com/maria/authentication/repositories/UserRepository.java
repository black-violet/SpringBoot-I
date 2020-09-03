package com.maria.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maria.authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}