package ATM;

import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ATM
    //TODO: multiple currencies + withdrawal/deposit on actual account
{
    private EnumMap<Banknote, Integer> banknotes = new EnumMap<>(Banknote.class);

    public ATM()
    {
        for(Banknote b : Banknote.values())
            banknotes.put(b, 0);
    }

    public void setBanknotes(Banknote b, Integer n)
    {
        this.banknotes.put(b, n);
    }

    public void withdraw(Double amount, Account acc)
    {
        if(amount <= 0)
            return;

        if (!acc.isLoggedOn())
        {
            System.out.println("401");
            return;
        }

        for(Map.Entry<Banknote, Integer> note : banknotes.entrySet())
        {
            while(amount >= note.getKey().getValue() && note.getValue() > 0)
            {
                amount -= note.getKey().getValue();
                note.setValue(note.getValue()-1);
            }
            System.out.println(note.getKey() + " has " + note.getValue() + " notes left");
        }
        System.out.println("sda4a: " + amount);
    }

}
