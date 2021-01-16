package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    final private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User rslUsr = findByPassport(passport);
        boolean rslAcc = users.get(rslUsr).contains(account);
        if (rslUsr != null && !rslAcc) {
            users.get(rslUsr).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User keyUsr : users.keySet()) {
            if (keyUsr.getPassport().equals(passport)) {
                rsl = keyUsr;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = new ArrayList<>();
        Account acc = null;
        User usr = findByPassport(passport);
        if (usr != null) {
            accounts = users.get(usr);
        }
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                acc = account;
                break;
            }
        }
        return acc;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDst = findByRequisite(destPassport, destRequisite);
        if (accSrc != null && accDst != null && accSrc.getBalance() >= amount) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDst.setBalance(accDst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}