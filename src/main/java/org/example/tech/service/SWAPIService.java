package org.example.tech.service;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SWAPIService {
    private final RestTemplate restTemplate;

    public SWAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<People> getAllPeople() {
        String url = "https://swapi.dev/api/people/";
        People[] people = restTemplate.getForObject(url, People[].class);
        return Arrays.asList(people);
    }

    public List<Starship> getAllStarships() {
        String url = "https://swapi.dev/api/starships/";
        Starship[] starships = restTemplate.getForObject(url, Starship[].class);
        return Arrays.asList(starships);
    }
}