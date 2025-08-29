package com.micah.springapi.dto;

import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

/**
 * Embedded DTO representing the core stat block of a Morty.
 * Used inside both MortyRequest and MortyResponse.
 */
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