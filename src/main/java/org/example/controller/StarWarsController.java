package org.example.controller;

import org.example.model.People;
import org.example.model.Starship;
import org.example.service.SWAPIService;
import org.example.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/star-wars")
public class StarWarsController {

    private final SWAPIService swapiService;
    private final SortingService<People> peopleSortingService;
    private final SortingService<Starship> starshipSortingService;

    @Autowired
    public StarWarsController(SWAPIService swapiService, SortingService<People> peopleSortingService, SortingService<Starship> starshipSortingService) {
        this.swapiService = swapiService;
        this.peopleSortingService = peopleSortingService;
        this.starshipSortingService = starshipSortingService;
    }

    @GetMapping("/people")
    public List<People> getPeople(@RequestParam(required = false) String sortBy, @RequestParam(required = false) boolean ascending) {
        List<People> people = swapiService.getAllPeople();
        if ("name".equalsIgnoreCase(sortBy)) {
            return peopleSortingService.sortByName(people, ascending);
        } else if ("created".equalsIgnoreCase(sortBy)) {
            return peopleSortingService.sortByCreated(people, ascending);
        }
        return people;
    }

    @GetMapping("/starships")
    public List<Starship> getStarships(@RequestParam(required = false) String sortBy, @RequestParam(required = false) boolean ascending) {
        List<Starship> starships = swapiService.getAllStarships();
        if ("name".equalsIgnoreCase(sortBy)) {
            return starshipSortingService.sortByName(starships, ascending);
        } else if ("created".equalsIgnoreCase(sortBy)) {
            return starshipSortingService.sortByCreated(starships, ascending);
        }
        return starships;
    }
}