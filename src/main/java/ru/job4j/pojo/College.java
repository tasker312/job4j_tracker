package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setMiddleName("Petrovich");
        student.setLastName("Petrov");
        student.setGroup("B350mv");
        student.setReceptionDate(LocalDate.now());
        System.out.format("Имя: %s%nФамилия: %s%nОтчество: %s%n№Группы: %s%nДата поступления: %s%n",
                student.getFirstName(), student.getLastName(), student.getMiddleName(),
                student.getGroup(), student.getReceptionDate());
    }
}
