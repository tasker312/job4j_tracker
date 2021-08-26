package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] arr : list) {
            for (int cur : arr) {
                rsl.add(cur);
            }
        }
        return rsl;
    }
}
