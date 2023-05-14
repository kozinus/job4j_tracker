package ru.job4j.bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковских переводов
 * @author Kkozi
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет список ArrayList по ключю класса User,
     * Если такого ключа не найдено
     * @param user пользователь, который добавляется в качестве ключа
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * Метод удаляет пару User - LinkedList<account> по строке passport
     * @param passport строка для поиска пользователя
     * @return Возвращает, удалось ли найти и удалить пользователя
     */

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }
    /**
     * Метод находит список по строке и добавляет в него счёт
     * @param passport строка для поиска пользователя
     * @param account нужно добавить в список счетов
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }
    /**
     * Метод находит пользователя по строке
     * @param passport строка для поиска пользователя
     */

    public User findByPassport(String passport) {
        return (users.keySet()).stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }
    /**
     * Метод удаляет пару User - LinkedList<account> по строке passport
     * @param passport строка для поиска пользователя
     * @param requisite Строка для поиска счёта у пользователя
     * @return Возвращает найденный счёт или null
     */

    public Account findByRequisite(String passport, String requisite) {
        return users.getOrDefault(findByPassport(passport), new ArrayList<>()).stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst()
                .orElse(null);
    }
    /**
     * Метод находит счёт-отправитель и счёт-получатель.
     * Операция проводится, если найдены отправитель и получатель
     * и у отправителя хватает средств.
     * @param srcPassport строка для поиска пользователя-отправителя
     * @param srcRequisite Строка для поиска счёта-отправителя
     * @param destPassport строка для поиска пользователя-получателя
     * @param destRequisite строка для поиска счёта-получателя
     * @param amount значение перевода
     * @return успешность перевода
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if ((srcAccount != null) && (destAccount != null)
                && (srcAccount.getBalance() - amount >= 0.0)) {
            double balance = srcAccount.getBalance();
            srcAccount.setBalance(balance - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
    /**
     * Метод находит список счетов по ключу и возвращает его
     * @param user ключ для получения списка счетов
     * @return список счетов пользователя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}