package org.example.tech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class People {
    private String name;
    private String birthYear;
    private String gender;
}