package com.micah.springapi.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
// Embedded class for a single morty's stats
// Used in Morty entity to encapsulate stats
@Getter
@Setter
@Embeddable
public class MortyStatBlock implements Serializable {
    private boolean collected;
    private String name;
    private String type;
    private String rarity;
    
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
}