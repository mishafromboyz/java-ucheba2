package ATM;

import java.util.AbstractMap;


public class Main
    //TODO: Main - inf loop
    //      project - clean code
    //      maybe ATM should have book
{
    public static void main(String[] args)
    {
        /**
         * Функционал:
         *      Accounts: создать акк, достать акк из мапы,  переслать деньги между аккаунтами, первая часть авторизации,
         *      Account: вторая часть авторизации, изменить баланс, вывести баланс, добавить транзакцию в историю, вывести историю
         *      ATM: ввести банкноты (пока только инкассатором), снять наличные.
         *      \n
         * Есть поддержка разных валют
         */
        ATM a = new ATM();

        a.setBanknotes(Currency.USD, Banknote.thousand, 10);
        a.setBanknotes(Currency.USD, Banknote.hundred, 5);
        a.setBanknotes(Currency.USD, Banknote.fifty, 2);
        a.setBanknotes(Currency.USD ,Banknote.ten, 1);

        a.book.createAcc("stas", "stas123", "123");
        a.book.createAcc("vlad", "vlad123", "123");

        a.book.sendMoney("stas123", "vlad123", new AbstractMap.SimpleEntry<Currency, Double>(Currency.USD, 10.0));
        a.book.logOn("stas123", "123");
        a.book.sendMoney("stas123", "vlad123", new AbstractMap.SimpleEntry<Currency, Double>(Currency.USD, 10.0));
        Account acc = a.book.getAcc("stas123");
        acc.printBalance();

        a.deposit(1625.0, Currency.USD, acc);
        a.deposit(1625.0, Currency.RUB, acc);
        acc.printBalance();

        a.withdraw(500.0, Currency.USD, acc);
        a.withdraw(500.0, Currency.RUB, acc);
        acc.printBalance();

        System.out.println(a.getBanknotes());

        System.out.println("--------------------------------");
        acc.getHistory();
    }
}
