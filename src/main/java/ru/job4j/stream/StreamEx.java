package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -3, 1, 6, -1, 2);
        List<Integer> filteredList = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
