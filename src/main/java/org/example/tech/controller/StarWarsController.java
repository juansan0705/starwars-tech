package org.example.tech.controller;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
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

    @Autowired
    public StarWarsController(SWAPIService swapiService) {
        this.swapiService = swapiService;
    }

    @GetMapping("/people")
    public List<People> getPeople(@RequestParam(required = false) String sortBy, @RequestParam(required = false) boolean ascending) {
        return swapiService.getAllPeople(sortBy, ascending);
    }

    @GetMapping("/starships")
    public List<Starship> getStarships(@RequestParam(required = false) String sortBy, @RequestParam(required = false) boolean ascending) {
        return swapiService.getAllStarships(sortBy, ascending);
    }
}