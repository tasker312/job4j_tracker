package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы
 * @author Tasker
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение списка пользователей осуществляется в HashMap<User, ArrayList<Account>>
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить нового пользователя банковскую систему
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить новый счет пользователю банковской системы,
     * если пользователь существует, а его счета с такими реквизитами не существует
     * @param passport паспорт пользователя
     * @param account счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод позволяет найти пользователя в банковской системе по его паспорту
     * @param passport паспорт пользователя
     * @return возвращает пользователя, если пользователь с таким паспортом
     * существует в системе, иначе null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет найти счет по его паспорту и реквизитам счета
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета
     * @return счет, если пользователь с таким счетом существует, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        for (Account account : users.get(user)) {
            if (requisite.equals(account.getRequisite())) {
                return account;
            }
        }
        return null;
    }

    /**
     * Метод позволяет выполнить операцию перевода с одного счета на другой
     * @param srcPassport паспорт пользователя (источник)
     * @param srcRequisite реквизиты счета пользователя (источник)
     * @param destPassport паспорт пользователя (назначение)
     * @param destRequisite реквизиты счета пользователя (назначение)
     * @param amount сумма для перевода
     * @return true, если счета существуют и на счете источнике находится достаточная
     * сумма для перевода; false в других случаях
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null
                || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }
}
