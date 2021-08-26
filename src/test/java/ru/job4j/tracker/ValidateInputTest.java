package ru.job4j.tracker;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new LinkedList<>(List.of("one", "1"))
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new LinkedList<>(List.of("1"))
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new LinkedList<>(List.of("1", "2", "3"))
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] inputArray = new int[]{
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:")
        };
        assertThat(inputArray, is(new int[]{1, 2, 3}));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new LinkedList<>(List.of("-1"))
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}