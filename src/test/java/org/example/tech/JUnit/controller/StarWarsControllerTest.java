package org.example.tech.JUnit.controller;

import org.example.tech.controller.StarWarsController;
import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.example.tech.service.SortingService;
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

    @MockBean
    private SortingService<People> peopleSortingService;

    @MockBean
    private SortingService<Starship> starshipSortingService;

    @Test
    void testGetPeople() throws Exception {
        when(swapiService.getAllPeople()).thenReturn(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male")));

        mockMvc.perform(get("/api/v1/star-wars/people"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    void testGetStarships() throws Exception {
        when(swapiService.getAllStarships()).thenReturn(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation")));

        mockMvc.perform(get("/api/v1/star-wars/starships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("X-wing"));
    }
}
