package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;

public class Informatics {
    private static List<Computer> computers = new ArrayList<>();

    public static void main(String[] args) {
        Computer computer = new Computer.Builder().buildMotherboard("GIGABYTE")
                .buildCpu(new Cpu.Builder().buildSocket("AM")
                        .buildCache(8192)
                        .buildCores(8)
                        .buildFrequency(3800)
                        .build())
                .buildGraphics("NVIDIA")
                .buildHdd("WD")
                .buildRam(16384)
                .buildPower("CORSAIR")
                .build();
        computers.add(computer);
        computer = new Computer.Builder().buildMotherboard("GIGABYTE")
                .buildCpu(new Cpu.Builder().buildCores(4)
                        .buildSocket("AM4")
                        .build())
                .buildGraphics("NVIDIA")
                .build();
        computers.add(computer);
        computers.forEach(System.out::println);
    }
}
