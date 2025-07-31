package com.micah.springapi.controller;

import com.micah.springapi.dto.TeamRequest;
import com.micah.springapi.dto.TeamResponse;
import com.micah.springapi.service.TeamService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Morty Teams.
 * Validates team size and member uniqueness.
 */
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * Creates a new Morty team from a list of Morty IDs.
     * @param request DTO containing team name and Morty ID list
     * @return TeamResponse with saved team info
     */
    @PostMapping
    public TeamResponse createTeam(@Validated @RequestBody TeamRequest request) {
        return teamService.createTeam(request);
    }

    /**
     * Retrieves a team by its ID.
     * @param id the team's ID
     * @return TeamResponse object
     */
    @GetMapping("/{id}")
    public TeamResponse getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }
}