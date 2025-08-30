package com.mortyproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mortyproject.dto.*;
import com.mortyproject.model.*;
import com.mortyproject.repository.MortyRepository;

/**
 * Service layer responsible for managing Morty entities.
 * Handles CRUD operations and maps between MortyRequest/MortyResponse DTOs.
 */
@Service
public class MortyService {

    private final MortyRepository mortyRepository;

    public MortyService(MortyRepository mortyRepository) {
        this.mortyRepository = mortyRepository;
    }
    
    /**
     * Creates a new Morty from request data and saves it to the repository.
     */
    public MortyResponse createMorty(MortyRequest request) {
        Morty morty = new Morty();
        MortyStatBlock stats = new MortyStatBlock();
        stats.setCollected(request.getStats().isCollected());

        stats.setName(request.getStats().getName());
        stats.setType(request.getStats().getType());
        stats.setRarity(request.getStats().getRarity());
        stats.setLevel(request.getStats().getLevel());
        stats.setHp(request.getStats().getHp());
        stats.setAttack(request.getStats().getAttack());
        stats.setDefense(request.getStats().getDefense());
        stats.setSpeed(request.getStats().getSpeed());
        morty.setStats(stats);

        Morty saved = mortyRepository.save(morty);
        return toMortyResponse(saved);
    }

    private MortyResponse toMortyResponse(Morty morty) {
        MortyResponse response = new MortyResponse();
        response.setId(morty.getId());
        response.setCollected(morty.getStats().isCollected());

        MortyStatBlockDTO statsDto = new MortyStatBlockDTO();
        statsDto.setName(morty.getStats().getName());
        statsDto.setType(morty.getStats().getType());
        statsDto.setRarity(morty.getStats().getRarity());
        statsDto.setLevel(morty.getStats().getLevel());
        statsDto.setHp(morty.getStats().getHp());
        statsDto.setAttack(morty.getStats().getAttack());
        statsDto.setDefense(morty.getStats().getDefense());
        statsDto.setSpeed(morty.getStats().getSpeed());
        statsDto.setCollected(morty.getStats().isCollected());

        response.setStats(statsDto);
        return response;
    }

    // Search for a Morty by existing id
    public MortyResponse getMortyById(Long id) {
    Morty morty = mortyRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Morty not found with id: " + id));
    return toMortyResponse(morty);
    }

    // Return all of the mortys in a set List (team)
    public List<MortyResponse> getAllMortys() {
    return mortyRepository.findAll().stream()
        .map(this::toMortyResponse)
        .toList();
    }

    // Update an existing Morty after stored
    public MortyResponse updateMorty(Long id, MortyRequest request) {
    Morty morty = mortyRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Morty not found with id: " + id));

    MortyStatBlock stats = new MortyStatBlock();
    stats.setCollected(request.getStats().isCollected());
    stats.setName(request.getStats().getName());
    stats.setType(request.getStats().getType());
    stats.setRarity(request.getStats().getRarity());
    stats.setLevel(request.getStats().getLevel());
    stats.setHp(request.getStats().getHp());
    stats.setAttack(request.getStats().getAttack());
    stats.setDefense(request.getStats().getDefense());
    stats.setSpeed(request.getStats().getSpeed());
    stats.setCollected(morty.getStats().isCollected());

    morty.setStats(stats);
    return toMortyResponse(mortyRepository.save(morty));
    }
    
    // Delete a previously stored Morty
    public void deleteMorty(Long id) {
    if(!mortyRepository.existsById(id)) {
        throw new IllegalArgumentException("Morty not found with id: " + id);
    }
    mortyRepository.deleteById(id);
}

}