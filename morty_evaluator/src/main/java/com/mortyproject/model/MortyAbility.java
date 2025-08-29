package com.mortyproject.model;
import jakarta.persistence.*;
/**
 * Join entity linking Mortys with their Abilities.
 * Supports a many-to-one relationship for each side,
 * allowing future extension for Mortys with multiple skills.
 */
@Entity
public class MortyAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Morty morty;

    @ManyToOne
    private Ability ability;
}