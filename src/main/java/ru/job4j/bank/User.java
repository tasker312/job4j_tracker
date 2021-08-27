package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя
 * @author Tasker
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя
     */
    private String passport;

    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Метод создает нового пользователя, принимает на вход его паспорт и имя
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспорт пользователя
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет изменить паспорт пользователя, принимает на вход новый паспорт
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет изменить имя пользователя, принимает на вход новое имя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнивает пользователей по их паспортам
     * @param o пользователь для сравнения
     * @return true, если паспорта совпадают; false в других случаях
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод позволяет получить хэш код объекта
     * @return хэш код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
