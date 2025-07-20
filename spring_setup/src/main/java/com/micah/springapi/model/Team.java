package com.micah.springapi.model;

import jakarta.persistence.*;
import java.util.List;
// Model for a group of multiple Mortys, max 6
// Can be less but not 0
@Entity
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Morty> mortys; 
}