package org.example.tech.IT.service;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@DirtiesContext
class SWAPIServiceIntegrationTest {

    @Autowired
    private SWAPIService swapiService;

    @Test
    void testGetAllPeople() {
        List<People> people = swapiService.getAllPeople();
        assertNotNull(people);
        assertTrue(people.size() > 0);
    }

    @Test
    void testGetAllStarships() {
        List<Starship> starships = swapiService.getAllStarships();
        assertNotNull(starships);
        assertTrue(starships.size() > 0);
    }
}