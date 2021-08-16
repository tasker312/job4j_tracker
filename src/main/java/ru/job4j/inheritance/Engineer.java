package ru.job4j.inheritance;

import java.time.LocalDate;

public class Engineer extends Profession {
    public Engineer(String name, String surname, String education, LocalDate birthday) {
        super(name, surname, education, birthday);
    }
}
