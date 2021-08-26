package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemCompareTest {
    @Test
    public void sortByIdIncrease() {
        Item item1 = new Item(5, "Item1");
        Item item2 = new Item(10, "Item2");
        Item item3 = new Item(2, "Item3");
        List<Item> items = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortByIdItem());
        assertThat(items, is(Arrays.asList(item3, item1, item2)));
    }

    @Test
    public void sortByIdDecrease() {
        Item item1 = new Item(5, "Item1");
        Item item2 = new Item(10, "Item2");
        Item item3 = new Item(2, "Item3");
        List<Item> items = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortByIdItem().reversed());
        assertThat(items, is(Arrays.asList(item2, item1, item3)));
    }

    @Test
    public void sortByNameIncrease() {
        Item item1 = new Item(5, "Item582");
        Item item2 = new Item(10, "Item212");
        Item item3 = new Item(2, "Item311");
        List<Item> items = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortByNameItem());
        assertThat(items, is(Arrays.asList(item2, item3, item1)));
    }

    @Test
    public void sortByNameDecrease() {
        Item item1 = new Item(5, "Item582");
        Item item2 = new Item(10, "Item212");
        Item item3 = new Item(2, "Item311");
        List<Item> items = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortByNameItem().reversed());
        assertThat(items, is(Arrays.asList(item1, item3, item2)));
    }
}