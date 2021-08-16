package ru.job4j.inheritance;

import java.time.LocalDate;

public class Doctor extends Profession {
    private String licence;

    public Doctor(String name, String surname, String education,
                  LocalDate birthday, String licence) {
        super(name, surname, education, birthday);
        this.licence = licence;
    }

    public String getLicence() {
        return licence;
    }

    public Diagnosis heal(Pacient pacient) {
        return null;
    }
}
