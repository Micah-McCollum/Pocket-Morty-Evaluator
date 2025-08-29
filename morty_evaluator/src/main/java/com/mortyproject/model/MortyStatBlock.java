package com.mortyproject.model;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
/**
 * Embedded stat block for a Morty.
 * Stores all relevant numeric and classification attributes.
 * Used inside Morty entity via @Embedded annotation.
 */
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