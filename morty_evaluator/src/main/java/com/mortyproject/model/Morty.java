package com.mortyproject.model;import lombok.*;
import jakarta.persistence.*;

/**
 * Core entity representing a Morty character.
 * Each Morty contains a stat block embedded via @Embeddable class.
 */
@Getter
@Setter
@Entity
public class Morty {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MortyStatBlock stats;

}