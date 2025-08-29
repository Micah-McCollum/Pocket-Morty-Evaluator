package com.mortyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micah.springapi.model.Morty;
// Repository for an individual Morty
public interface MortyRepository extends JpaRepository<Morty, Long> {
    
}
