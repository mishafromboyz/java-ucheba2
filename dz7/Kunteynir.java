package dz7;

import java.util.Arrays;
import java.util.Vector;

public class Kunteynir
{
    public Vector<Printer> spisok = new Vector<Printer>();

    public void sendId(Printer sender, String text, int receiverId)
    {
        sender.send(text, spisok.elementAt(receiverId));
    }
    public void sendEmail(Printer sender, String text, String receiverEmail)
    {
        for (Printer p : spisok)
        {
            if(p.getEmail().equals(receiverEmail))
            {
                System.out.println("200");
                p.send(text, p);
                return;
            }
        }
        System.out.println("404");
    }

    public void sendIP(Printer sender, String text, int[] receiverIp)
    {
        for (Printer p : spisok)
        {
            if(Arrays.equals(p.getIp(), receiverIp))
            {
                System.out.println("200");
                p.send(text, p);
                return;
            }
            else
                System.out.println(Arrays.toString(receiverIp) + " != " + Arrays.toString(p.getIp()));
        }
        System.out.println("404");
    }


}
