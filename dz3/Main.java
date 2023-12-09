package dz3;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String buffer = "";
        System.out.println("enter number to check\nenter exit to quit");
        while(true)
        {
            buffer = in.next();
            if(buffer.equals("exit"))
                return;

            if (buffer.contains(",")) {
                //System.out.print("match");
                buffer = buffer.replace(',', '.');
            }

            System.out.println(fizzBazz(Double.parseDouble(buffer)));
        }
    }
    public static String fizzBazz(double in)
    {
        if (in == 0)
            return(Double.toString(in));

        String ans = "";

        if (in%3 == 0)
            ans += "Fizz";

        if (in%5 == 0)
            ans += "Bazz";

        if (ans.isEmpty())
            return(Double.toString(in));
        else
            return(ans);
    }
}