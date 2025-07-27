package com.micah.springapi.controller;

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

// Rest APIs for specific abilities
@RestController
@RequestMapping("/api/abilities")
public class AbilityController {

    private final AbilityRepository abilityRepository;

    public AbilityController(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @GetMapping
    public List<Ability> getAll() {
        return abilityRepository.findAll();
    }

    @PostMapping
    public Ability create(@Validated @RequestBody Ability ability) {
        return abilityRepository.save(ability);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        abilityRepository.deleteById(id);
    }
}