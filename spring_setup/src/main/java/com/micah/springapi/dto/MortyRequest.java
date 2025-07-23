package com.micah.springapi.dto;

import lombok.*;

@Getter
@Setter
public class MortyRequest {
    private MortyStatBlockDTO stats;
    private boolean collected;

    
}