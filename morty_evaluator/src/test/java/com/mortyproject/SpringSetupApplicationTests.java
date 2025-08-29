package com.micah.springapi.spring_setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micah.springapi.dto.MortyRequest;
import com.micah.springapi.dto.MortyStatBlockDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSetupApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void unauthenticatedUserCannotAccessMortys() throws Exception {
        mockMvc.perform(get("/api/mortys"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void createMortyReturnsCreatedStatusWhenAuthorized() throws Exception {
        MortyRequest request = new MortyRequest();
        MortyStatBlockDTO stats = new MortyStatBlockDTO();
        stats.setCollected(true);
        stats.setName("UnitMorty");
        stats.setType("rock");
        stats.setRarity("common");
        stats.setLevel(5);
        stats.setHp(25);
        stats.setAttack(10);
        stats.setDefense(5);
        stats.setSpeed(8);
        request.setStats(stats);

        mockMvc.perform(post("/api/mortys")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .with(httpBasic("admin", "admin")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stats.name").value("UnitMorty"));
    }

	private static RequestPostProcessor httpBasic(String username, String password) {
        return org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic(username, password);
    }	
} 
