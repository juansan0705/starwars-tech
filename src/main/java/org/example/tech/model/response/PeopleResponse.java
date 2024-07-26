package org.example.tech.model.response;

import org.example.tech.model.People;

import java.util.List;

public class PeopleResponse {
    private List<People> results;

    public List<People> getResults() {
        return results;
    }

    public void setResults(List<People> results) {
        this.results = results;
    }
}