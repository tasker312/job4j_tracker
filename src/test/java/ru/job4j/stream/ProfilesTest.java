package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void collectDistinctSorted() {
        List<Address> addresses = List.of(
                new Address(
                        "St Petersburg",
                        "Dubrova",
                        10,
                        2
                ),
                new Address(
                        "Moscow",
                        "Lomonosova",
                        2,
                        26
                ),
                new Address(
                        "Moscow",
                        "Lomonosova",
                        2,
                        26
                )
        );
        List<Profile> profiles = new ArrayList<>(List.of(
                new Profile(addresses.get(0)),
                new Profile(addresses.get(1)),
                new Profile(addresses.get(2))
        ));
        List<Address> result = new Profiles().collect(profiles);
        List<Address> exp = List.of(
                new Address(
                        "Moscow",
                        "Lomonosova",
                        2,
                        26
                ),
                new Address(
                        "St Petersburg",
                        "Dubrova",
                        10,
                        2
                )
        );
        assertThat(result, is(exp));
    }
}