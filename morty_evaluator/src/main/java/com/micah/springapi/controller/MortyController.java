package com.micah.springapi.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.micah.springapi.dto.MortyRequest;
import com.micah.springapi.dto.MortyResponse;

import com.micah.springapi.service.MortyService;

/**
 * REST controller for managing individual Morty characters.
 * Supports full CRUD operations using MortyService.
 */
@RestController
@RequestMapping("/api/mortys")
public class MortyController {

    private final MortyService mortyService;

    public MortyController(MortyService mortyService) {
        this.mortyService = mortyService;
    }

    /**
     * Creates a new Morty from the provided request payload.
     * @param request DTO containing stat block data
     * @return MortyResponse with persisted data
     */
    @PostMapping
    public MortyResponse create(@Validated @RequestBody MortyRequest request) {
        return mortyService.createMorty(request);
    }

    /**
     * Retrieves all Mortys in the database.
     * @return list of MortyResponse objects
     */
    @GetMapping
    public List<MortyResponse> getAll() {
        return mortyService.getAllMortys();
    }

    /**
     * Retrieves a specific Morty by ID.
     * @param id the Morty's unique ID
     * @return MortyResponse object
     */
    @GetMapping("/{id}")
    public MortyResponse getById(@PathVariable Long id) {
        return mortyService.getMortyById(id);
    }

    /**
     * Updates an existing Morty with new stat values.
     * @param id Morty's ID
     * @param request updated stat block
     * @return updated MortyResponse
     */
    @PutMapping("/{id}")
    public MortyResponse updateMorty(@Validated @PathVariable Long id, @RequestBody MortyRequest request) {
        return mortyService.updateMorty(id, request);
    }

    /**
     * Deletes a Morty from the database by ID.
     * @param id the Morty's ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mortyService.deleteMorty(id);
    }
}