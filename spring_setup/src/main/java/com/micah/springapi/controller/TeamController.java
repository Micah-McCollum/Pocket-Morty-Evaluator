package com.micah.springapi.controller;

import org.springframework.web.bind.annotation.*;

import com.micah.springapi.model.Team;
import com.micah.springapi.service.TeamService;
// Controller for a team of Morty characters
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }
}