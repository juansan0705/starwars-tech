package org.example.tech.JUnit.service;

import org.example.tech.model.People;
import org.example.tech.model.response.PeopleResponse;
import org.example.tech.model.Starship;
import org.example.tech.model.response.StarshipResponse;
import org.example.tech.service.SWAPIService;
import org.example.tech.sorting.CreatedSortSpecification;
import org.example.tech.sorting.NameSortSpecification;
import org.example.tech.sorting.util.SortSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SWAPIServiceTest {

    @InjectMocks
    private SWAPIService swapiService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private SortSpecification<People> peopleSortSpecification;

    @Mock
    private SortSpecification<Starship> starshipSortSpecification;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        swapiService = new SWAPIService(restTemplate, List.of(new NameSortSpecification<>(), new CreatedSortSpecification<>()), List.of(new NameSortSpecification<>(), new CreatedSortSpecification<>()));
    }

    @Test
    void testGetAllPeople() {
        PeopleResponse peopleResponse = new PeopleResponse();
        peopleResponse.setResults(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male", "2023-10-01T00:00:00Z")));
        when(restTemplate.getForObject("https://swapi.dev/api/people/", PeopleResponse.class)).thenReturn(peopleResponse);

        List<People> people = swapiService.getAllPeople("name", true);
        assertEquals(1, people.size());
        assertEquals("Luke Skywalker", people.get(0).getName());
    }

    @Test
    void testGetAllStarships() {
        StarshipResponse starshipResponse = new StarshipResponse();
        starshipResponse.setResults(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation", "2023-10-01T00:00:00Z")));
        when(restTemplate.getForObject("https://swapi.dev/api/starships/", StarshipResponse.class)).thenReturn(starshipResponse);

        List<Starship> starships = swapiService.getAllStarships("name", true);
        assertEquals(1, starships.size());
        assertEquals("X-wing", starships.get(0).getName());
    }
}