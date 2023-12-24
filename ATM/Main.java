package ATM;

import java.sql.SQLOutput;
import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.Map;


public class Main
{
    public static void main(String[] args)
    {
        Accounts book = new Accounts();
        book.createAcc("stas", "stas123", "123");
        book.createAcc("vlad", "vlad123", "123");

        book.logOn("stas123", "123");

        book.sendMoney("stas123", "vlad123", new AbstractMap.SimpleEntry<Currency, Double>(Currency.USD, 10.0));
        Account acc = book.getAcc("stas123");
        acc.getHistory();


        ATM a = new ATM();
        a.setBanknotes(Banknote.thousand, 10);
        a.setBanknotes(Banknote.hundred, 5);
        a.setBanknotes(Banknote.fifty, 2);
        a.setBanknotes(Banknote.ten, 1);

        a.withdraw(1625.0, acc);

        a.withdraw(900.0, acc);
    }
}
