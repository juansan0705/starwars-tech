package org.example.tech.service;

import org.example.tech.model.People;
import org.example.tech.model.response.PeopleResponse;
import org.example.tech.model.Starship;
import org.example.tech.model.response.StarshipResponse;
import org.example.tech.sorting.CreatedSortSpecification;
import org.example.tech.sorting.NameSortSpecification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class SWAPIServiceImpl implements SWAPIService {
    private final RestTemplate restTemplate;
    private final NameSortSpecification<People> peopleNameSortSpecification;
    private final CreatedSortSpecification<People> peopleCreatedSortSpecification;
    private final NameSortSpecification<Starship> starshipNameSortSpecification;
    private final CreatedSortSpecification<Starship> starshipCreatedSortSpecification;

    public SWAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.peopleNameSortSpecification = new NameSortSpecification<>();
        this.peopleCreatedSortSpecification = new CreatedSortSpecification<>();
        this.starshipNameSortSpecification = new NameSortSpecification<>();
        this.starshipCreatedSortSpecification = new CreatedSortSpecification<>();
    }

    @Override
    public List<People> getAllPeople(String sortField, boolean ascending) {
        String url = "https://swapi.dev/api/people/";
        PeopleResponse response = restTemplate.getForObject(url, PeopleResponse.class);
        List<People> people = response != null ? response.getResults() : Collections.emptyList();
        if ("name".equalsIgnoreCase(sortField)) {
            return peopleNameSortSpecification.sort(people, ascending);
        } else if ("created".equalsIgnoreCase(sortField)) {
            return peopleCreatedSortSpecification.sort(people, ascending);
        }
        return people;
    }

    @Override
    public List<Starship> getAllStarships(String sortField, boolean ascending) {
        String url = "https://swapi.dev/api/starships/";
        StarshipResponse response = restTemplate.getForObject(url, StarshipResponse.class);
        List<Starship> starships = response != null ? response.getResults() : Collections.emptyList();
        if ("name".equalsIgnoreCase(sortField)) {
            return starshipNameSortSpecification.sort(starships, ascending);
        } else if ("created".equalsIgnoreCase(sortField)) {
            return starshipCreatedSortSpecification.sort(starships, ascending);
        }
        return starships;
    }
}