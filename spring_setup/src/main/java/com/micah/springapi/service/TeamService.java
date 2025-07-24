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
        // Morty team size constraints
        if(team.getMortys().size() > 6) {
            throw new IllegalArgumentException("Team cannot have more than 6 Mortys");
        }

        if(team.getMortys().isEmpty()) {
            throw new IllegalArgumentException("Team must have at least one Morty");
        }

        // Checks that all Morty IDs are unique and exist in the repository using a stream/Map
        for(Morty morty : team.getMortys()) {
            if(morty.getId() == null) {
                throw new IllegalArgumentException("Morty ID cannot be null");
            }
        }
        if(team.getMortys().stream()
                .filter(m -> m.getId() != null)
                .map(Morty::getId)
                .distinct()
                .count() != team.getMortys().stream()
                .filter(m -> m.getId() != null)
                .count()) {
                throw new IllegalArgumentException("All Morty IDs must be unique/individual");
            }
            
        for(Morty morty : team.getMortys()) {
            mortyRepository.findById(morty.getId())
                .orElseThrow(() -> new IllegalArgumentException("Morty not found with ID: " + morty.getId()));
        }

        return teamRepository.save(team);
    }


    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Team not found with ID: " + id));
    }
}