package ru.job4j.inheritance;

import java.time.LocalDate;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education,
                   LocalDate birthday, String licence) {
        super(name, surname, education, birthday, licence);
    }
}
