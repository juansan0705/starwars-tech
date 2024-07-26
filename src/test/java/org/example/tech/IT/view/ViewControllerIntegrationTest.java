package org.example.tech.IT.view;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.service.SWAPIService;
import org.example.tech.view.ViewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ViewController.class)
class ViewControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SWAPIService swapiService;

    @Test
    void testViewPeople() throws Exception {
        when(swapiService.getAllPeople()).thenReturn(Collections.singletonList(new People("Luke Skywalker", "19BBY", "male")));

        mockMvc.perform(get("/people"))
                .andExpect(status().isOk())
                .andExpect(view().name("people"))
                .andExpect(model().attributeExists("people"));
    }

    @Test
    void testViewStarships() throws Exception {
        when(swapiService.getAllStarships()).thenReturn(Collections.singletonList(new Starship("X-wing", "T-65 X-wing", "Incom Corporation")));

        mockMvc.perform(get("/starships"))
                .andExpect(status().isOk())
                .andExpect(view().name("starships"))
                .andExpect(model().attributeExists("starships"));
    }
}