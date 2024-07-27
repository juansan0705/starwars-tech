package org.example.tech.IT.service;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SWAPIServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllPeople() {
        ResponseEntity<List<People>> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/star-wars/people?sortBy=name&ascending=true",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<People>>() {}
        );
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();

        assertThat(response.getBody().get(0).getName()).isNotNull();
    }

    @Test
    void testGetAllStarships() {
        ResponseEntity<List<Starship>> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/star-wars/starships?sortBy=name&ascending=true",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Starship>>() {}
        );
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();

        assertThat(response.getBody().get(0).getName()).isNotNull();
    }
}