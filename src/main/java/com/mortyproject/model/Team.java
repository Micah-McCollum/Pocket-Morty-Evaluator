package com.mortyproject.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a team composed of up to six Mortys.
 * Each team has a name and a list of Morty entities.
 * Enforced as a @ManyToMany relation.
 */
@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "team_mortys", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "morty_id"))

    private List<Morty> mortys;

    public List<Morty> getMortys() {
        return mortys;
    }

    public void setMortys(List<Morty> mortys) {
        this.mortys = mortys;

    }
}