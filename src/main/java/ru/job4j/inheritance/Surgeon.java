package ru.job4j.inheritance;

import java.time.LocalDate;

public class Surgeon extends Doctor {
    private String specialization;

    public Surgeon(String name, String surname, String education,
                   LocalDate birthday, String licence, String specialization) {
        super(name, surname, education, birthday, licence);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void operate(Pacient pacient) {

    }
}
