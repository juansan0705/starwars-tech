package org.example.tech.view;

import org.example.tech.service.SWAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    private final SWAPIService swapiService;

    @Autowired
    public ViewController(SWAPIService swapiService) {
        this.swapiService = swapiService;
    }

    @GetMapping("/people")
    public String viewPeople(Model model,
                             @RequestParam(defaultValue = "name") String sortField,
                             @RequestParam(defaultValue = "asc") String sortOrder) {
        boolean ascending = "asc".equalsIgnoreCase(sortOrder);
        model.addAttribute("people", swapiService.getAllPeople(sortField, ascending));
        return "people";
    }

    @GetMapping("/starships")
    public String viewStarships(Model model,
                                @RequestParam(defaultValue = "name") String sortField,
                                @RequestParam(defaultValue = "asc") String sortOrder) {
        boolean ascending = "asc".equalsIgnoreCase(sortOrder);
        model.addAttribute("starships", swapiService.getAllStarships(sortField, ascending));
        return "starships";
    }
}