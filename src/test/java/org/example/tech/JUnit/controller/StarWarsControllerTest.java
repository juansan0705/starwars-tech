package org.example.tech.JUnit.controller;

import org.example.tech.controller.StarWarsController;
import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StarWarsController.class)
public class StarWarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SWAPIService swapiService;


    @Test
    void testGetPeople() throws Exception {
        when(swapiService.getAllPeople("name", true)).thenReturn(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male", "2023-10-01T00:00:00Z")));

        mockMvc.perform(get("/api/v1/star-wars/people?sortBy=name&ascending=true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(jsonPath("$[0].created").value("2023-10-01T00:00:00Z"));
    }

    @Test
    void testGetStarships() throws Exception {
        when(swapiService.getAllStarships("name", true)).thenReturn(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation", "2023-10-01T00:00:00Z")));

        mockMvc.perform(get("/api/v1/star-wars/starships?sortBy=name&ascending=true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("X-wing"))
                .andExpect(jsonPath("$[0].created").value("2023-10-01T00:00:00Z"));
    }
}