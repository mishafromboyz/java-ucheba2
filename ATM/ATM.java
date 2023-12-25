package ATM;

import java.util.*;

public class ATM
    //TODO: multiple currencies + withdrawal/deposit on actual account - done
    //      Deposit banknotes, randomly discard bad banknotes - done
    //      Trade currency
{
    private Account owner = new Account("GOV", "12345");

    //TODO: private book, add methods to control book
    public Accounts book = new Accounts();

    private EnumMap<Currency, EnumMap<Banknote, Integer>> banknotes = new EnumMap<>(Currency.class);

    public ATM()
    {
        for(Currency c : Currency.values())
        {
            banknotes.put(c, new EnumMap<Banknote, Integer>(Banknote.class));
            EnumMap<Banknote, Integer> bnknts = banknotes.get(c);
            for(Banknote b : Banknote.values())
                bnknts.put(b, 0);
        }
    }

    public void withdraw(Double amount, Currency curr, Account acc)
    {
        if(amount <= 0)
            return;

        if (!acc.isLoggedOn())
        {
            System.out.println("401");
            return;
        }

        Double oldAmount = amount;

        EnumMap<Banknote, Integer> bnknts = banknotes.get(curr);

        for(Map.Entry<Banknote, Integer> note : bnknts.entrySet())
        {
            while(amount >= note.getKey().getValue() && note.getValue() > 0)
            {
                amount -= note.getKey().getValue();
                note.setValue(note.getValue()-1);
            }
        }
        System.out.println("sda4a: " + amount);

        oldAmount -= amount;
        acc.changeBalance("withdraw", curr, oldAmount);
        acc.addTransaction(new Transaction(acc, owner, new AbstractMap.SimpleEntry<Currency, Double>(curr, oldAmount)));
    }

    public void deposit(Double amount, Currency curr, Account acc)
    {
        if (amount <= 0)
            return;

        double oldAmount = amount;
        EnumMap<Banknote, Integer> bnknts = banknotes.get(curr);
        double rng;

        for (Map.Entry<Banknote, Integer> note : bnknts.entrySet())
        {
            while(amount >= note.getKey().getValue())
            {
                rng = Math.random();
                if(rng<0.5)
                {
                    System.out.println("couldnt read bill...");
                    continue;
                }
                amount -= note.getKey().getValue();
                note.setValue(note.getValue()+1);
            }
        }
        System.out.println("sda4a: " + amount);

        oldAmount -= amount;
        acc.changeBalance("deposit", curr, oldAmount);
        acc.addTransaction(new Transaction(acc, owner, new AbstractMap.SimpleEntry<Currency, Double>(curr, oldAmount)));
    }

    public EnumMap<Currency, EnumMap<Banknote, Integer>> getBanknotes()
    {
        return banknotes;
    }

    public void setBanknotes(Currency c, Banknote b, Integer num)
    {
        EnumMap<Banknote, Integer> bnknts = banknotes.get(c);
        bnknts.put(b, num);
    }
}
