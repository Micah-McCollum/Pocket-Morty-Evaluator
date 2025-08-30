package com.mortyproject;

import com.mortyproject.dto.MortyRequest;
import com.mortyproject.dto.MortyStatBlockDTO;
import com.mortyproject.model.Morty;
import com.mortyproject.model.MortyStatBlock;
import com.mortyproject.repository.MortyRepository;
import com.mortyproject.service.MortyService;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MortyServiceTest {

    MortyRepository mortyRepository = mock(MortyRepository.class);
    MortyService mortyService = new MortyService(mortyRepository);

    @Test
    void createMorty_shouldReturnResponseWithSameStats() {
        MortyRequest request = new MortyRequest();
        MortyStatBlockDTO stats = new MortyStatBlockDTO();
        stats.setName("TestMorty");
        stats.setLevel(10);
        stats.setCollected(true);
        request.setStats(stats);

        Morty saved = new Morty();
        saved.setId(1L);

        MortyStatBlock statBlock = new MortyStatBlock();
        statBlock.setName(stats.getName());
        statBlock.setType(stats.getType());
        statBlock.setRarity(stats.getRarity());
        statBlock.setLevel(stats.getLevel());
        statBlock.setHp(stats.getHp());
        statBlock.setAttack(stats.getAttack());
        statBlock.setDefense(stats.getDefense());
        statBlock.setSpeed(stats.getSpeed());
        statBlock.setCollected(stats.isCollected());

        saved.setStats(statBlock);

        when(mortyRepository.save(any())).thenReturn(saved);

        var response = mortyService.createMorty(request);

        assertEquals("TestMorty", response.getStats().getName());
        assertEquals(10, response.getStats().getLevel());
        assertTrue(response.getStats().isCollected());
    }

    @Test
    void getMortyById_shouldThrowIfNotFound() {
        when(mortyRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> mortyService.getMortyById(1L));
    }
}