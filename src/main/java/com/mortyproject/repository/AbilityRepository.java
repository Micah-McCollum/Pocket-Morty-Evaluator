package com.mortyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortyproject.model.Ability;
// Repository for a specific ability
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    
}
