package org.example.tech.service;

import org.example.tech.model.People;
import org.example.tech.model.Starship;

import java.util.List;

public interface SWAPIService {
    List<People> getAllPeople(String sortField, boolean ascending);
    List<Starship> getAllStarships(String sortField, boolean ascending);
}