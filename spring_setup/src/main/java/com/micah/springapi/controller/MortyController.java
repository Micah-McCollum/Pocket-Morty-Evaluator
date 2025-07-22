package com.micah.springapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micah.springapi.model.Morty;
import com.micah.springapi.repository.MortyRepository;
// REST APIs for each Morty character
@RestController
@RequestMapping("/api/mortys")
public class MortyController {

    private final MortyRepository mortyRepository;

    public MortyController(MortyRepository mortyRepository) {
        this.mortyRepository = mortyRepository;
    }

    @GetMapping
    public List<Morty> getAll() {
        return mortyRepository.findAll();
    }

    @PostMapping
    public Morty create(@RequestBody Morty morty) {
        return mortyRepository.save(morty);
    }

    @GetMapping("/{id}")
    public Morty getById(@PathVariable Long id) {
        return mortyRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mortyRepository.deleteById(id);
    }
}