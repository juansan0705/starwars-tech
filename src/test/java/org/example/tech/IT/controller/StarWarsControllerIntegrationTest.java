package org.example.tech.IT.controller;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StarWarsControllerIntegrationTest {

    private static final int PORT = 6969;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getPeople() {
        ResponseEntity<List<People>> response = restTemplate.exchange(
                "http://localhost:" + PORT + "/api/v1/star-wars/people",
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
                "http://localhost:" + PORT + "/api/v1/star-wars/starships",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Starship>>() {}
        );
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();
    }
}