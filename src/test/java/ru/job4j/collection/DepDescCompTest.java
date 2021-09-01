package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class DepDescCompTest {
    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void compareManyDepartments() {
        List<String> departments = new ArrayList<>(
                Arrays.asList(
                        "K1",
                        "K2",
                        "K1/SK1",
                        "K1/SK1/SSK2",
                        "K1/SK1/SSK1",
                        "K2/SK2"
                )
        );
        List<String> exp = new ArrayList<>(
                List.of(
                        "K2",
                        "K2/SK2",
                        "K1",
                        "K1/SK1",
                        "K1/SK1/SSK1",
                        "K1/SK1/SSK2"
                )
        );
        departments.sort(new DepDescComp());
        assertThat(departments, is(exp));
    }

}