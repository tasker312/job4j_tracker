package ru.job4j.oop;

public class Garage {
    public static void main(String[] args) {
        Vehicle[] arr = {new Airplane(), new Train(), new Airplane(), new Bus(), new Bus()};
        for (Vehicle vehicle : arr) {
            vehicle.move();
        }
    }
}
