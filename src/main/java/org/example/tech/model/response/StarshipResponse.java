package org.example.tech.model.response;

import org.example.tech.model.Starship;

import java.util.List;

public class StarshipResponse {
    private List<Starship> results;

    public List<Starship> getResults() {
        return results;
    }

    public void setResults(List<Starship> results) {
        this.results = results;
    }
}