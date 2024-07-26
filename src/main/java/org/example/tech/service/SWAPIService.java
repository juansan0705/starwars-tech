package org.example.tech.service;

import org.example.tech.model.People;
import org.example.tech.model.response.PeopleResponse;
import org.example.tech.model.Starship;
import org.example.tech.model.response.StarshipResponse;
import org.example.tech.sorting.util.SortSpecification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class SWAPIService {
    private final RestTemplate restTemplate;
    private final List<SortSpecification<People>> sortSpecifications;
    private final List<SortSpecification<Starship>> starshipSortSpecifications;

    public SWAPIService(RestTemplate restTemplate, List<SortSpecification<People>> sortSpecifications, List<SortSpecification<Starship>> starshipSortSpecifications) {
        this.restTemplate = restTemplate;
        this.sortSpecifications = sortSpecifications != null ? sortSpecifications : Collections.emptyList();
        this.starshipSortSpecifications = starshipSortSpecifications != null ? starshipSortSpecifications : Collections.emptyList();
    }

    public List<People> getAllPeople(String sortField, boolean ascending) {
        String url = "https://swapi.dev/api/people/";
        PeopleResponse response = restTemplate.getForObject(url, PeopleResponse.class);
        List<People> people = response != null ? response.getResults() : Collections.emptyList();
        for (SortSpecification<People> spec : sortSpecifications) {
            if (spec.getClass().getSimpleName().toLowerCase().contains(sortField.toLowerCase())) {
                return spec.sort(people, ascending);
            }
        }
        return people;
    }

    public List<Starship> getAllStarships(String sortField, boolean ascending) {
        String url = "https://swapi.dev/api/starships/";
        StarshipResponse response = restTemplate.getForObject(url, StarshipResponse.class);
        List<Starship> starships = response != null ? response.getResults() : Collections.emptyList();
        for (SortSpecification<Starship> spec : starshipSortSpecifications) {
            if (spec.getClass().getSimpleName().toLowerCase().contains(sortField.toLowerCase())) {
                return spec.sort(starships, ascending);
            }
        }
        return starships;
    }
}