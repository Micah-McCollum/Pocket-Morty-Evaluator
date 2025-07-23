package com.micah.springapi.model;
import lombok.*;
import jakarta.persistence.*;

// Model for a Morty character
@Getter
@Setter
@Entity
public class Morty {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MortyStatBlock stats;

}