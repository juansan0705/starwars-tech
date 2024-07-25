package org.example.tech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Starship {
    private String name;
    private String model;
    private String manufacturer;
}