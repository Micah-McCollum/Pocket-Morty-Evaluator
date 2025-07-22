package com.micah.springapi.service;

import org.springframework.stereotype.Service;

import com.micah.springapi.model.Morty;
import com.micah.springapi.model.Team;
import com.micah.springapi.repository.MortyRepository;
import com.micah.springapi.repository.TeamRepository;
// Additional service class handling logic for Morty teams
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final MortyRepository mortyRepository;

    public TeamService(TeamRepository teamRepository, MortyRepository mortyRepository) {
        this.teamRepository = teamRepository;
        this.mortyRepository = mortyRepository;
    }

    public Team createTeam(Team team) {
        if(team.getMortys().size() > 6) {
            throw new IllegalArgumentException("Team cannot have more than 6 Mortys.");
        }

   
        for(Morty morty : team.getMortys()) {
            mortyRepository.findById(morty.getId())
                .orElseThrow(() -> new IllegalArgumentException("Morty not found with ID: " + morty.getId()));
        }

        return teamRepository.save(team);
    }

    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }
}