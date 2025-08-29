package com.mortyproject.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micah.springapi.model.Ability;
import com.micah.springapi.repository.AbilityRepository;

import java.util.List;

/**
 * REST controller for managing Morty Abilities.
 * Currently unused in evaluation logic but supports basic CRUD operations.
 */
@RestController
@RequestMapping("/api/abilities")
public class AbilityController {

    private final AbilityRepository abilityRepository;

    public AbilityController(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    /**
     * Retrieves all stored abilities.
     * @return list of Ability objects
     */
    @GetMapping
    public List<Ability> getAll() {
        return abilityRepository.findAll();
    }

    /**
     * Creates a new Ability.
     * @param ability the Ability object to create
     * @return the saved Ability
     */
    @PostMapping
    public Ability create(@Validated @RequestBody Ability ability) {
        return abilityRepository.save(ability);
    }

    /**
     * Deletes an Ability by its ID.
     * @param id the ID of the Ability to delete
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        abilityRepository.deleteById(id);
    }
}