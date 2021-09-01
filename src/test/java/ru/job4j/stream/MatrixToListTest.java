package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void integerToList() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> list = new MatrixToList().matrixToList(matrix);
        List<Integer> exp = List.of(1, 2, 3, 4);
        assertThat(list, is(exp));
    }

    @Test
    public void intToList() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> list = new MatrixToList().matrixToList(matrix);
        List<Integer> exp = List.of(1, 2, 3, 4);
        assertThat(list, is(exp));
    }
}