package org.example.tech.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class People {
    private String name;
    private String birthYear;
    private String gender;

    @JsonCreator
    public People(@JsonProperty("name") String name, @JsonProperty("birth_year") String birthYear, @JsonProperty("gender") String gender) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
    }
}