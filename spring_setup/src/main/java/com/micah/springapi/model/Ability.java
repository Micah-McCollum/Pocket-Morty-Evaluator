package com.micah.springapi.model;

import jakarta.persistence.*;
// Ability currently not factored into evaluation, for future use in team recomendation etc
@Entity
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int cost;
    private String type;
    private int power; 

}
