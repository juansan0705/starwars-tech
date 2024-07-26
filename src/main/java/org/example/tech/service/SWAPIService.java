package org.example.tech.service;

import org.example.tech.model.People;
import org.example.tech.model.response.PeopleResponse;
import org.example.tech.model.Starship;
import org.example.tech.model.response.StarshipResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class SWAPIService {
    private final RestTemplate restTemplate;

    public SWAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<People> getAllPeople() {
        String url = "https://swapi.dev/api/people/";
        PeopleResponse response = restTemplate.getForObject(url, PeopleResponse.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }

    public List<Starship> getAllStarships() {
        String url = "https://swapi.dev/api/starships/";
        StarshipResponse response = restTemplate.getForObject(url, StarshipResponse.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }
}