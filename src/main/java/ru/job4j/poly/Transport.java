package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int amount);

    double fill(double amount);
}
