package com.micah.springapi.spring_setup;

import com.micah.springapi.dto.TeamRequest;
import com.micah.springapi.repository.MortyRepository;
import com.micah.springapi.repository.TeamRepository;
import com.micah.springapi.service.TeamService;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamServiceTest {

    TeamRepository teamRepository = mock(TeamRepository.class);
    MortyRepository mortyRepository = mock(MortyRepository.class);
    TeamService teamService = new TeamService(teamRepository, mortyRepository);

    @Test
    void createTeam_shouldThrowIfMoreThanSixMortys() {
        TeamRequest request = new TeamRequest();
        request.setName("OP Team");
        request.setMortyIds(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));

        assertThrows(IllegalArgumentException.class, () -> teamService.createTeam(request));
    }

    @Test
    void createTeam_shouldThrowIfMortyNotFound() {
        TeamRequest request = new TeamRequest();
        request.setName("Test");
        request.setMortyIds(List.of(1L));
        when(mortyRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> teamService.createTeam(request));
    }
}