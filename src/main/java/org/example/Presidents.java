package org.example;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Presidents {

    int id;
    String name;
    String lastname;
    int age;
    int management_time;

    public Presidents(String name, String lastname, int age, int management_time) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.management_time = management_time;
    }
}


