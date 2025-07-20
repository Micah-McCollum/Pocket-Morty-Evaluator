package com.micah.springapi.model;

import jakarta.persistence.*;

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