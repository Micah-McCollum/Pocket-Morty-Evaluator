package com.mortyproject.dto;

import lombok.*;

/**
 * DTO returned after creating, retrieving, or updating a Morty.
 * Includes generated ID, stat block, and collection flag.
 */
@Getter
@Setter
public class MortyResponse {
    private Long id;
    private MortyStatBlockDTO stats;
    private boolean collected;

}