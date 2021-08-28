package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public List<Integer> matrixToList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }

    public List<Integer> matrixToList(int[][] matrix) {
        return Arrays.stream(matrix).
                flatMap(ints -> Arrays.stream(ints).boxed())
                .collect(Collectors.toList());
    }
}
