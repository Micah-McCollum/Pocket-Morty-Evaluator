package com.micah.springapi.dto;

import java.util.List;

/**
 * DTO returned when retrieving a full Morty team.
 * Includes team ID, name, and the full MortyResponse objects
 * for each member of the team.
 */
public class TeamResponse {
    private Long id;
    private String name;
    private List<MortyResponse> mortys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MortyResponse> getMortys() {
        return mortys;
    }

    public void setMortys(List<MortyResponse> mortys) {
        this.mortys = mortys;
    }
}