package org.example;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Countries {
    int id;
    String name;
    String population;
    String square;
    String president;

    public Countries(String name, String population, String square, String president) {
        this.name = name;
        this.population = population;
        this.square = square;
        this.president = president;
    }
}
