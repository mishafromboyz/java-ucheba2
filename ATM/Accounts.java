package ATM;

import java.util.*;

public class Accounts
{
    public HashMap<String, Account> accMap = new HashMap<>();

    public Account getAcc(String login)
    {
        Account acc = accMap.get(login);
        if(acc==null)
        {
            System.out.println("cant find account with login = " + login);
        }
        return(acc);
    }

    public void createAcc(String name, String login, String password)
    {
        Account acc = accMap.putIfAbsent(login, new Account(name, password));
        if(acc != null)
        {
            System.out.println("cant create acc");
        }
    }

    public void sendMoney(String senderLogin, String receiverLogin,
                          AbstractMap.SimpleEntry<Currency, Double> amount)
    {
        Account sender = getAcc(senderLogin);
        if(sender == null)
            return;

        if(!sender.isLoggedOn())
        {
            System.out.println("401 unauthorized");
            return;
        }

        Account receiver = getAcc(receiverLogin);
        if(receiver == null)
            return;

        sender.changeBalance("withdraw", amount.getKey(), amount.getValue());
        sender.addTransaction(new Transaction(sender, receiver, amount));

        receiver.changeBalance("deposit", amount.getKey(), amount.getValue());
        receiver.addTransaction(new Transaction(sender, receiver, amount));

        System.out.println("transaction successful");
    }

    public void logOn(String login, String password)
    {
        if (login == null)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter login:");
            login = scan.next();
        }

        Account acc = getAcc(login);

        if(acc == null)
            return;

        else
            acc.logOn(password);
    }
}
