package com.micah.springapi.dto;

import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

// Embedded stat block holding the various attributes for a Morty
@Getter
@Setter
public class MortyStatBlockDTO {
    private boolean collected;

    @NotBlank
    private String name;
    private String type;
    private String rarity;

    @Min(1)
    @Max(100)
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int speed;

}