package ru.job4j.bank;

import ru.job4j.tracker.Output;

import java.util.*;

/**
 * Класс описывает банковский сервис
 * сервис хранит клиентские аккаунты {@link User}, каждый аккаунт может иметь один и более счетов {@link Account}
 *
 * @author FaizievRT
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентских аккаунтов осуществляется в коллекции типа HashMap
     * где ключь это {@link User}, а значение это список счетов(List) {@link Account}
     */
    final private Map<User, List<Account>> users = new HashMap<>();

    /**
     * @param user клиентски аккаунт который хотим добавить в систему, список счетов по началу пустой
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * @param passport паспортные данные клиента(уникальны внутри системы)
     * @param account  банковский счёт {@link Account} для клиента для {@link User}
     */
    public void addAccount(String passport, Account account) {
        User rslUsr = findByPassport(passport).get();
        if (rslUsr != null) {
            boolean rslAcc = users.get(rslUsr).contains(account);
            if (!rslAcc) {
                users.get(rslUsr).add(account);
            }
        }
    }

    /**
     * @param passport паспортные данные для поиска аккаунта
     * @return аккаунт клиента найденные по паспортным данным
     */
    public Optional<User> findByPassport(String passport) {
        return Optional.of(users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst().get());
    }

    /**
     * @param passport  паспортные данные для поиска аккаунта
     * @param requisite реквизиты счета для поиска аккаунта
     * @return счет {@link Account} клиента {@link User}
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var accounts = users.get(findByPassport(passport).get());
        return Optional.of(accounts.stream()
                .filter(s -> s.getRequisite().equals(requisite)).findFirst()).get();
    }

    /**
     * @param srcPassport   паспортные данные отправителя
     * @param srcRequisite  счет отправителя
     * @param destPassport  паспортные данные получателя
     * @param destRequisite счет получателя
     * @param amount        сумма перевода
     * @return true если удалось перевести деньги со счета на счет, false если денег недостаточно или ненайден счет отправителя/получателя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite).get();
        Account accDst = findByRequisite(destPassport, destRequisite).get();
        if (accSrc != null && accDst != null && accSrc.getBalance() >= amount) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDst.setBalance(accDst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}