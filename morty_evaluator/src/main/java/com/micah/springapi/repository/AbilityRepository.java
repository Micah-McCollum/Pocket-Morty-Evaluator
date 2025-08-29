package com.micah.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micah.springapi.model.Ability;
// Repository for a specific ability
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    
}
