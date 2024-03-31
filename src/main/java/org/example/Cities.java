package org.example;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cities {
    int id;
    String name;
    int population;
    String square;
    String mayor;

    public Cities(String name, int population, String square, String mayor) {
        this.name = name;
        this.population = population;
        this.square = square;
        this.mayor = mayor;
    }
}
