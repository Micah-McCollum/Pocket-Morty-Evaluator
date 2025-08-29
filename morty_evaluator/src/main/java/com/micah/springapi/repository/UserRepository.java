package com.micah.springapi.repository;

import com.micah.springapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository for Users of the app
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}