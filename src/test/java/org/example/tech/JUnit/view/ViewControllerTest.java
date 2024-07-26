package org.example.tech.JUnit.view;

import org.example.tech.service.SWAPIService;
import org.example.tech.view.ViewController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewControllerTest {

    @InjectMocks
    private ViewController viewController;

    @Mock
    private SWAPIService swapiService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testViewPeople() {
        when(swapiService.getAllPeople()).thenReturn(Collections.emptyList());

        String viewName = viewController.viewPeople(model);
        assertEquals("people-view", viewName);
        verify(model, times(1)).addAttribute(eq("people"), any());
    }

    @Test
    void testViewStarships() {
        when(swapiService.getAllStarships()).thenReturn(Collections.emptyList());

        String viewName = viewController.viewStarships(model);
        assertEquals("starships-view", viewName);
        verify(model, times(1)).addAttribute(eq("starships"), any());
    }
}