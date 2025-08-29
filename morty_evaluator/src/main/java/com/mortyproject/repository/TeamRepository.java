package com.mortyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micah.springapi.model.Team;
// Repository for a team of Mortys
public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
