package com.mortyproject.dto;

import lombok.*;

/**
 * DTO used for creating or updating a Morty.
 * Wraps a MortyStatBlockDTO and collection status.
 */
@Getter
@Setter
public class MortyRequest {
    private MortyStatBlockDTO stats;
    private boolean collected;

    
}