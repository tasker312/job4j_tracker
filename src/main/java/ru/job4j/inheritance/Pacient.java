package ru.job4j.inheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pacient {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private boolean isMan;
    private String address;
    private String number;
    private List<Diagnosis> diagnoses;

    public Pacient(int id, String name, String surname, LocalDate birthday,
                   boolean isMan, String address, String number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.isMan = isMan;
        this.address = address;
        this.number = number;
        diagnoses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isMan() {
        return isMan;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void addDiagnosis(Diagnosis diagnosis) {
        diagnoses.add(diagnosis);
    }
}
