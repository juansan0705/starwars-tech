package org.example.tech.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class Starship {
    private String name;
    private String model;
    private String manufacturer;

    @JsonCreator
    public Starship(@JsonProperty("name") String name, @JsonProperty("model") String model, @JsonProperty("manufacturer") String manufacturer) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
    }
}