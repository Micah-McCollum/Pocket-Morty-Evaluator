package com.micah.springapi.model;

import jakarta.persistence.*;

// Model for a Morty character
@Entity
public class Morty {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private MortyStatBlock stats; 

    private String name;
    private String type; 
    private String rarity; 
    
    private int level;
    private int hp;   
    private int attack;
    private int defense;
    private int speed;
}

