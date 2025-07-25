package com.micah.springapi.dto;

import lombok.*;

@Getter
@Setter
public class MortyResponse {
    private Long id;
    private MortyStatBlockDTO stats;
    private boolean collected;

}