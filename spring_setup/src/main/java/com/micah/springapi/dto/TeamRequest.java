package com.micah.springapi.dto;

import java.util.List;

// DTO for creating a new Morty team
// Includes the team name and list of Morty IDs (to be resolved in service)
public class TeamRequest {
    private String name;
    private List<Long> mortyIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getMortyIds() {
        return mortyIds;
    }

    public void setMortyIds(List<Long> mortyIds) {
        this.mortyIds = mortyIds;
    }
}