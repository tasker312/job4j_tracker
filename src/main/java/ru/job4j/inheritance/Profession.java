package ru.job4j.inheritance;

import java.time.LocalDate;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;

    public Profession(String name, String surname, String education, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
