package org.example.tech.view;

import org.example.tech.service.SWAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    private final SWAPIService swapiService;

    @Autowired
    public ViewController(SWAPIService swapiService) {
        this.swapiService = swapiService;
    }

    @GetMapping("/people")
    public String viewPeople(Model model) {
        model.addAttribute("people", swapiService.getAllPeople());
        return "people";
    }

    @GetMapping("/starships")
    public String viewStarships(Model model) {
        model.addAttribute("starships", swapiService.getAllStarships());
        return "starships";
    }
}