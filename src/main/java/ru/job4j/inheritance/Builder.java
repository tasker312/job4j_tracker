package ru.job4j.inheritance;

import java.time.LocalDate;

public class Builder extends Engineer {
    private String specialization;

    public Builder(String name, String surname, String education,
                   LocalDate birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public void build() {

    }
}
