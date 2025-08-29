package com.mortyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micah.springapi.model.MortyAbility;
// REpository for 
public interface MortyAbilityRepository extends JpaRepository<MortyAbility, Long> {
    
}
