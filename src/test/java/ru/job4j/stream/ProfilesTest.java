package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collect() {
        Profile profile = new Profile(new Address(
                "Moscow",
                "Lomonosova",
                2,
                26
        ));
        List<Address> result = new Profiles().collect(List.of(profile));
        assertThat(result, is(List.of(
                new Address(
                        "Moscow",
                        "Lomonosova",
                        2,
                        26
                )
        )));
    }
}