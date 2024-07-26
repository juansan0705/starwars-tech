package org.example.tech.IT.controller;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.example.tech.service.SortingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StarWarsControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SWAPIService swapiService;

    @Autowired
    private SortingService<People> peopleSortingService;

    @Autowired
    private SortingService<Starship> starshipSortingService;

    @Test
    public void getPeople() {
        ResponseEntity<List<People>> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/star-wars/people",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<People>>() {}
        );
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void getStarships() {
        ResponseEntity<List<Starship>> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/star-wars/starships",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Starship>>() {}
        );
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();
    }
}