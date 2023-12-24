package ATM;

import java.util.AbstractMap;


public class Main
    //TODO: Main - inf loop
    //      project - clean code
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

        Accounts book = new Accounts();
        book.createAcc("stas", "stas123", "123");
        book.createAcc("vlad", "vlad123", "123");

        book.logOn("stas123", "123");

        book.sendMoney("stas123", "vlad123", new AbstractMap.SimpleEntry<Currency, Double>(Currency.USD, 10.0));
        Account acc = book.getAcc("stas123");
        acc.printBalance();
        System.out.println("--------------------------------");
        acc.getHistory();


        ATM a = new ATM();
        a.setBanknotes(Currency.USD, Banknote.thousand, 10);
        a.setBanknotes(Currency.USD, Banknote.hundred, 5);
        a.setBanknotes(Currency.USD, Banknote.fifty, 2);
        a.setBanknotes(Currency.USD ,Banknote.ten, 1);

        acc.printBalance();
        a.withdraw(1625.0, Currency.USD, acc);
        acc.printBalance();
        a.withdraw(1625.0, Currency.RUB, acc);
        acc.printBalance();

        //a.withdraw(900.0, Currency.GBP, acc);

        //acc.getHistory();
    }
}
