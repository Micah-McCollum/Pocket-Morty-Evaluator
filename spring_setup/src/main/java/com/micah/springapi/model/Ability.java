package com.micah.springapi.model;

import jakarta.persistence.*;
/**
 * Represents a combat or support ability in the game.
 * Currently not used in stat evaluation but may be used
 * in future logic for team recommendations or battle outcomes.
 */
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
