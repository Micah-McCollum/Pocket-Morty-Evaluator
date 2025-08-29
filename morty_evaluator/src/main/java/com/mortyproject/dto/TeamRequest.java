package com.mortyproject.dto;


import java.util.List;

/**
 * DTO used for creating a new Morty team.
 * Includes team name and a list of Morty IDs to associate with the team.
 */
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