package ru.job4j.inheritance;

import java.time.LocalDate;

public class Diagnosis {
    private String diagnosis;
    private LocalDate startDate;
    private LocalDate endDate;
    private String recommendation;
    private Doctor doctor;

    public Diagnosis(String diagnosis, LocalDate startDate, LocalDate endDate,
                     String recommendation, Doctor doctor) {
        this.diagnosis = diagnosis;
        this.startDate = startDate;
        this.endDate = endDate;
        this.recommendation = recommendation;
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
