package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, которые содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = (p) -> p.getName().contains(key);
        Predicate<Person> checkPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> checkSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> checkAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = checkName.or(checkPhone).or(checkSurname).or(checkAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
