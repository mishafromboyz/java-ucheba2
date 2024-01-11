package ATM;

import java.util.AbstractMap;
import java.util.HashMap;
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
        final Account[] acc = {null};
        Scanner scan = new Scanner(System.in);
        String buffer = new String();

        a.book.createAcc("stas", "stas123", "123");
        acc[0] = a.book.getAcc("stas123");

        HashMap<String, Operation> inputMapping = new HashMap<>();
        inputMapping.put("help", new Operation() {
            @Override
            public void operate() {
                System.out.println("OPTIONS:" +
                        "\n\tcreate account" +
                        "\n\tlog in" +
                        "\n\tdeposit money" +
                        "\n\twithdraw money" +
                        "\n\tsend money" +
                        "\n\tprint balance" +
                        "\n\tprint history" +
                        "\n\texit");
            }
        });
        inputMapping.put("create account", new Operation() {
            @Override
            public void operate() {
                System.out.println("enter login:");
                String accLogin = scan.nextLine();

                System.out.println("enter password:");
                String accPassword = scan.nextLine();

                System.out.println("enter name:");
                String accname = scan.nextLine();

                a.book.createAcc(accname, accLogin, accPassword);
                acc[0] = a.book.getAcc(accLogin);
                a.book.logOn(accLogin, accPassword);
            }
        });

        inputMapping.put("log in", new Operation() {
            @Override
            public void operate() {
                if (acc[0] != null)
                {
                    acc[0].logOff();
                }

                System.out.println("enter login");
                String login = scan.nextLine();

                a.book.logOn(login, null);
            }
        });

        inputMapping.put("deposit money", new Operation() {
            @Override
            public void operate() {
                if (acc[0] == null)
                {
                    System.out.println("log in your account");
                    return;
                }

                System.out.println("enter amount and currency:");
                Double amount = Double.parseDouble(scan.next());
                String currency = scan.next();
                a.deposit(amount, Currency.valueOf(currency), acc[0]);
            }
        });

        inputMapping.put("withdraw money", new Operation() {
            @Override
            public void operate() {
                if (acc[0] == null)
                {
                    System.out.println("log in your account");
                    return;
                }

                System.out.println("enter amount and currency:");
                Double amount = Double.parseDouble(scan.next());
                String currency = scan.next();
                a.withdraw(amount, Currency.valueOf(currency), acc[0]);
            }
        });
        inputMapping.put("send money", new Operation() {
            @Override
            public void operate() {
                if (acc[0] == null)
                {
                    System.out.println("log in your account");
                    return;
                }

                System.out.println("enter receiver:");
                String receiver = scan.nextLine();

                System.out.println("enter amount and currency:");
                Double amount = Double.parseDouble(scan.next());
                String currency = scan.next();

                a.book.sendMoney(acc[0], receiver, new AbstractMap.SimpleEntry<>(Currency.valueOf(currency), amount));
            }

        });
        inputMapping.put("print balance", new Operation() {
            @Override
            public void operate() {
                if (acc[0] == null)
                {
                    System.out.println("log in your account");
                    return;
                }

                acc[0].printBalance();
            }
        });

        inputMapping.put("print history", new Operation() {
            @Override
            public void operate() {
                if (acc[0] == null)
                {
                    System.out.println("log in your account");
                    return;
                }
                acc[0].getHistory();
            }
        });


        System.out.println("print help for list of commands");
        while (true) {
            System.out.println("__________\nenter command:");
            buffer = scan.nextLine();
            if (buffer.equals("exit"))
                break;
            try {
                inputMapping.get(buffer).operate();
            }
            catch (NullPointerException e)
            {
                System.out.println("command not in table");
            }
        }
    }
}
