package com.micah.springapi.model;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
// Model for a group of multiple Mortys, max 6
// Can be less but not 0
@Getter
@Setter
@Entity
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Morty> mortys;

    public List<Morty> getMortys() {
    return mortys;
    }
    public void setMortys(List<Morty> mortys) {
    this.mortys = mortys;
        
    }
}