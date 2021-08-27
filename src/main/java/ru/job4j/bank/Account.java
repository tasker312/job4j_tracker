package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет
 * @author Tasker
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета
     */
    private String requisite;

    /**
     * Баланс счета
     */
    private double balance;

    /**
     * Метод создает новый счет, принимает на вход его реквизиты и баланс
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет изменить реквизиты счета, принимает на вход новые реквизиты
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет изменить баланс счета, принимает на вход новый баланс
     * @param balance баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнивает счета по их реквизитам
     * @param o реквизит для сравнения
     * @return true, если реквизиты совпадают; false в других случаях
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод позволяет получить хэш код объекта
     * @return хэш код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
