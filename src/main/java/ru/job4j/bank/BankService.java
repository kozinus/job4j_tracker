package ru.job4j.bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public void addAccount(String passport, Account replaceAccount) {
        boolean rsl = true;
        User user = findByPassport(passport);
        rsl = user != null;
        if (rsl) {
            List<Account> accounts = users.get(findByPassport(passport));
            for (Account account : accounts) {
                if (account.getRequisite().equals(replaceAccount.getRequisite())) {
                    rsl = false;
                    break;
                }
            }
            if (rsl) {
                users.get(findByPassport(passport)).add(replaceAccount);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        User pass = findByPassport(passport);
        if (pass == null) {
            return null;
        }
        for (Account account : users.get(findByPassport(passport))) {
            if (requisite.equals(account.getRequisite())) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if ((srcAccount != null) && (destAccount != null)) {
            double balance = srcAccount.getBalance();
            if (balance - amount >= 0.0) {
                srcAccount.setBalance(balance - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}