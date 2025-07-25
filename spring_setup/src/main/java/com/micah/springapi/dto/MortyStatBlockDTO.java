package com.micah.springapi.dto;
import lombok.*;

// Embedded stat block holding the various attributes for a Morty
@Getter
@Setter
public class MortyStatBlockDTO {
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