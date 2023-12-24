package ATM;

import java.util.*;

public class Account
    //TODO: print acc balance
{
    //private final String login;
    private final String name;
    private final String password;

    /*
    public String getLogin() {
        return login;
    }
    */

    public boolean isLoggedOn() {
        return loggedOn;
    }

    private boolean loggedOn = false;
    private EnumMap<Currency, Double> balance = new EnumMap<>(Currency.class);
    private ArrayList<Transaction> transactionHistory = new ArrayList<>();

    public Account(String name, String password)
    {
        this.name = name;
        //this.login = login;
        this.password = password;
        for(Currency c : Currency.values())
        {
            balance.put(c, 0.0);
        }
    }



    public String getName() {
        return name;
    }

    public void changeBalance(String type, Currency curr, Double amount)
    {
        if(type.equals("withdraw"))
        {
            balance.put(curr, balance.get(curr) - amount);
            return;
        }
        if(type.equals("deposit"))
        {
            balance.put(curr, balance.get(curr) + amount);
            return;
        }
        System.out.println("invalid type in changeBalance()");
    }

    public void getHistory()
    {
        for(Transaction t : transactionHistory)
            System.out.println(t);
    }

    public void addTransaction(Transaction t)
    {
        transactionHistory.add(t);
        //System.out.println(t);
    }

    public void logOn(String password)
    {
        if(password == null)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter password:");
            password = scan.next();
        }
        if (this.password.equals(password))
        {
            loggedOn = true;
            System.out.println("welcome, " + name);
            return;
        }
        else
            System.out.println("wrong password");
    }
}
