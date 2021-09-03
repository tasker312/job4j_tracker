package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return;
        }
        List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
    }

    /**
     * Метод позволяет найти счет по его паспорту и реквизитам счета
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета
     * @return счет, если пользователь с таким счетом существует, иначе null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        return users.get(user.get()).stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty() || destAccount.isEmpty()
                || srcAccount.get().getBalance() < amount) {
            return false;
        }
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return true;
    }
}
