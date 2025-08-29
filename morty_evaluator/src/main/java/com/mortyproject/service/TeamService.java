package com.mortyproject.service;

import com.micah.springapi.dto.*;
import com.micah.springapi.model.Morty;
import com.micah.springapi.model.Team;
import com.micah.springapi.repository.MortyRepository;
import com.micah.springapi.repository.TeamRepository;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Service layer for managing teams of Mortys.
 * Handles team creation, member validation, and DTO transformation.
 */
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final MortyRepository mortyRepository;

    public TeamService(TeamRepository teamRepository, MortyRepository mortyRepository) {
        this.teamRepository = teamRepository;
        this.mortyRepository = mortyRepository;
    }

    // Create and store a new Morty team using validated Morty IDs
    // Includes duplicate checking, size limits, and existence validation
    public TeamResponse createTeam(TeamRequest request) {
        List<Morty> mortys = request.getMortyIds().stream()
            .distinct()
            .map(id -> mortyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Morty not found with ID: " + id)))
            .collect(Collectors.toList());
        // Team size validation: 1–6 Mortys per team
        if(mortys.size() == 0 || mortys.size() > 6) {
            throw new IllegalArgumentException("Team must have between 1 and 6 Mortys.");
        }

        Team team = new Team();
        team.setName(request.getName());
        team.setMortys(mortys);

        Team saved = teamRepository.save(team);
        return toTeamResponse(saved);
    }

    // Fetches a previously saved team and return as DTO
    public TeamResponse getTeam(Long id) {
        Team team = teamRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + id));
        return toTeamResponse(team);
    }

    // Mapping each of the Mortys the DTO
    private TeamResponse toTeamResponse(Team team) {
        TeamResponse response = new TeamResponse();
        response.setId(team.getId());
        response.setName(team.getName());

        List<MortyResponse> mortyResponses = team.getMortys().stream()
            .map(this::toMortyResponse)
            .collect(Collectors.toList());

        response.setMortys(mortyResponses);
        return response;
    }
    
    // Mapping a Team model to TeamResponse DTO
    // Uses embedded statblock
    private MortyResponse toMortyResponse(Morty morty) {
        MortyResponse response = new MortyResponse();
        response.setId(morty.getId());
        response.setCollected(morty.getStats().isCollected());

        MortyStatBlockDTO statsDto = new MortyStatBlockDTO();
        statsDto.setName(morty.getStats().getName());
        statsDto.setType(morty.getStats().getType());
        statsDto.setRarity(morty.getStats().getRarity());
        statsDto.setLevel(morty.getStats().getLevel());
        statsDto.setHp(morty.getStats().getHp());
        statsDto.setAttack(morty.getStats().getAttack());
        statsDto.setDefense(morty.getStats().getDefense());
        statsDto.setSpeed(morty.getStats().getSpeed());
        statsDto.setCollected(morty.getStats().isCollected());

        response.setStats(statsDto);
        return response;
    }

    public TeamEvaluationResponse evaluateTeamTypes(Long teamId) {
    Team team = teamRepository.findById(teamId)
        .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));

    Map<String, Integer> typeCounts = new HashMap<>();
    typeCounts.put("ROCK", 0);
    typeCounts.put("PAPER", 0);
    typeCounts.put("SCISSORS", 0);
    typeCounts.put("NORMAL", 0);

    for (Morty morty : team.getMortys()) {
        String type = morty.getStats().getType().toUpperCase();
        if (typeCounts.containsKey(type)) {
            typeCounts.put(type, typeCounts.get(type) + 1);
        }
    }

    // Recommend the least represented combat type (ignore NORMAL)
    String recommendation = typeCounts.entrySet().stream()
        .filter(e -> !e.getKey().equals("NORMAL"))
        .min(Map.Entry.comparingByValue())
        .map(e -> "Add more " + e.getKey() + " types for better type balance.")
        .orElse("Team is well-balanced.");

    TeamEvaluationResponse response = new TeamEvaluationResponse();
    response.setTypeCounts(typeCounts);
    response.setRecommendation(recommendation);
    return response;
}

}