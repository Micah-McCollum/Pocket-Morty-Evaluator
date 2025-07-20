package com.micah.springapi.model;

import jakarta.persistence.*;

@Entity
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int cost;
    private String type;
    private int power; 

}
