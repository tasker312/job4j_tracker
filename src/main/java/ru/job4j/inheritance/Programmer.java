package ru.job4j.inheritance;

import java.time.LocalDate;

public class Programmer extends Engineer {
    private String language;
    private Skill skill;

    public Programmer(String name, String surname, String education,
                      LocalDate birthday, String language, Skill skill) {
        super(name, surname, education, birthday);
        this.language = language;
        this.skill = skill;
    }

    public String getLanguage() {
        return language;
    }

    public Skill getSkill() {
        return skill;
    }
}
