package org.example.tech.JUnit.controller;

import org.example.tech.controller.StarWarsController;
import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class StarWarsControllerTest {

    @Mock
    private SWAPIService swapiService;

    @InjectMocks
    private StarWarsController starWarsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPeople() {
        when(swapiService.getAllPeople("name", true)).thenReturn(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male", "2023-10-01T00:00:00Z")));

        List<People> people = starWarsController.getPeople("name", true);
        assertEquals(1, people.size());
        assertEquals("Luke Skywalker", people.get(0).getName());
        assertEquals("2023-10-01T00:00:00Z", people.get(0).getCreated());
    }

    @Test
    void testGetStarships() {
        when(swapiService.getAllStarships("name", true)).thenReturn(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation", "2023-10-01T00:00:00Z")));

        List<Starship> starships = starWarsController.getStarships("name", true);
        assertEquals(1, starships.size());
        assertEquals("X-wing", starships.get(0).getName());
        assertEquals("2023-10-01T00:00:00Z", starships.get(0).getCreated());
    }

    @Test
    void testGetPeopleFailure() {
        when(swapiService.getAllPeople("name", true)).thenThrow(new IllegalArgumentException("Invalid request"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            starWarsController.getPeople("name", true);
        });

        assertEquals("Invalid request", exception.getMessage());
    }
}