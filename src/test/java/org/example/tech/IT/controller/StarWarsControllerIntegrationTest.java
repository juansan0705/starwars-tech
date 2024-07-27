package org.example.tech.IT.controller;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SWAPIService swapiService;

    @Test
    void testGetPeople() throws Exception {
        when(swapiService.getAllPeople("name", true)).thenReturn(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male", "2023-10-01T00:00:00Z")));

        mockMvc.perform(get("/api/v1/star-wars/people?sortBy=name&ascending=true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    void testGetStarships() throws Exception {
        when(swapiService.getAllStarships("name", true)).thenReturn(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation", "2023-10-01T00:00:00Z")));

        mockMvc.perform(get("/api/v1/star-wars/starships?sortBy=name&ascending=true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("X-wing"));
    }
    @Test
    void testGetPeopleFailure() throws Exception {
        when(swapiService.getAllPeople("name", true)).thenReturn(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male", "2023-10-01T00:00:00Z")));

        mockMvc.perform(get("/notvalidurl"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetStarshipsFailure() throws Exception {
        when(swapiService.getAllStarships("name", true)).thenReturn(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation", "2023-10-01T00:00:00Z")));

        mockMvc.perform(get("/notvalidurl"))
                .andExpect(status().isNotFound());
    }
}