package org.example;

import org.example.service.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Service service = new Service();

        Countries countries = new Countries("Kyrgyzstan", "6,975млн", "199 900 км²", "Sadyr Japarov");
        Cities cities = new Cities("Bishkek", 976734, "127 км²", " Айбек Джунушалиев ");
        Presidents presidents = new Presidents("Sadyr ", "Japarov", 55, 5);

        service.createTable();
        service.save(countries, presidents, cities);

        List<Object> list = new ArrayList<>(Arrays.asList(countries, cities));
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
