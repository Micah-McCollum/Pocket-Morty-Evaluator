package com.micah.springapi.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.micah.springapi.dto.MortyRequest;
import com.micah.springapi.dto.MortyResponse;

import com.micah.springapi.service.MortyService;

// REST APIs for each Morty character
@RestController
@RequestMapping("/api/mortys")
public class MortyController {

    private final MortyService mortyService;

    public MortyController(MortyService mortyService) {
        this.mortyService = mortyService;
    }

    @PostMapping
    public MortyResponse create(@Validated @RequestBody MortyRequest request) {
        return mortyService.createMorty(request);
    }

     @GetMapping
    public List<MortyResponse> getAll() {
        return mortyService.getAllMortys();
    }

    @GetMapping("/{id}")
    public MortyResponse getById(@PathVariable Long id) {
        return mortyService.getMortyById(id);
    }

    @PutMapping("/{id}")
    public MortyResponse updateMorty(@PathVariable Long id, @RequestBody MortyRequest request) {
        return mortyService.updateMorty(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mortyService.deleteMorty(id);
    }
}