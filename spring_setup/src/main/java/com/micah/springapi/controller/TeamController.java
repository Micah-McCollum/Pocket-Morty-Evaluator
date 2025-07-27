package com.micah.springapi.controller;

import com.micah.springapi.dto.TeamRequest;
import com.micah.springapi.dto.TeamResponse;
import com.micah.springapi.service.TeamService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// REST API controller for creating and retrieving Morty teams
// Handles the validation and business logic for TeamService
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public TeamResponse createTeam(@Validated @RequestBody TeamRequest request) {
        return teamService.createTeam(request);
    }

    @GetMapping("/{id}")
    public TeamResponse getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }
}