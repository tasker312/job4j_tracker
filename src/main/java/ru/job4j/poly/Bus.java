package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет по дороге");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("В автобусе " + amount + " пассажиров");
    }

    @Override
    public double fill(double amount) {
        return amount * 38.95;
    }
}
