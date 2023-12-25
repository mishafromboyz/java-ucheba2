package ATM;

import java.util.AbstractMap;
import java.util.Scanner;


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
        Account acc = null;
        Scanner scan = new Scanner(System.in);
        String buffer = new String();

        a.book.createAcc("stas", "stas123", "123");
        acc = a.book.getAcc("stas123");

        System.out.println("print exit to quit");
        while(true)
        {
            System.out.println("__________\nenter command:");
            buffer = scan.nextLine();
            switch (buffer)
            {
                case "exit":
                    return;

                case "help":
                {
                    System.out.println("OPTIONS:" +
                            "\n\tcreate account" +
                            "\n\tlog in" +
                            "\n\tdeposit money" +
                            "\n\twithdraw money" +
                            "\n\tsend money" +
                            "\n\tprint balance" +
                            "\n\tprint history");
                    break;
                }

                case "create account":
                {
                    System.out.println("enter login:");
                    String accLogin = scan.next();

                    System.out.println("enter password:");
                    String accPassword = scan.next();

                    System.out.println("enter name:");
                    String accname = scan.next();

                    a.book.createAcc(accname, accLogin, accPassword);
                    acc = a.book.getAcc(accLogin);
                    a.book.logOn(accLogin, accPassword);
                    break;
                }

                case "log in":
                {
                    if (acc != null)
                    {
                        acc.logOff();
                    }

                    System.out.println("enter login");
                    String login = scan.nextLine();

                    a.book.logOn(login, null);
                    break;
                }

                case "deposit money":
                {
                    if (acc == null)
                    {
                        System.out.println("log in your account");
                        break;
                    }

                    System.out.println("enter amount and currency:");
                    Double amount = Double.parseDouble(scan.next());
                    String currency = scan.next();
                    a.deposit(amount, Currency.valueOf(currency), acc);
                    break;
                }

                case "withdraw money":
                {
                    if (acc == null)
                    {
                        System.out.println("log in your account");
                        break;
                    }

                    System.out.println("enter amount and currency:");
                    Double amount = Double.parseDouble(scan.next());
                    String currency = scan.next();
                    a.withdraw(amount, Currency.valueOf(currency), acc);
                    break;
                }

                case "send money":
                {
                    if (acc == null)
                    {
                        System.out.println("log in your account");
                        break;
                    }

                    System.out.println("enter receiver:");
                    String receiver = scan.nextLine();

                    System.out.println("enter amount and currency:");
                    Double amount = Double.parseDouble(scan.next());
                    String currency = scan.next();

                    a.book.sendMoney(acc, receiver, new AbstractMap.SimpleEntry<>(Currency.valueOf(currency), amount));
                }

                case "print balance":
                {
                    if (acc == null)
                    {
                        System.out.println("log in your account");
                        break;
                    }

                    acc.printBalance();
                    break;
                }

                case "print history":
                {
                    if (acc == null)
                    {
                        System.out.println("log in your account");
                        break;
                    }

                    acc.getHistory();
                    break;
                }
            }
        }
    }
}
