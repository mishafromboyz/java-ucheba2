package dz4;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("enter operation:");
        String buffer = in.nextLine();

        System.out.println("enter numbers:");
        double a = Double.parseDouble(in.next());
        double b = Double.parseDouble(in.next());

        switch (buffer)
        {
            case ("add"):
            {
                System.out.println(a+b);
                break;
            }
            case ("sub"):
            {
                System.out.println(a-b);
                break;
            }
            case ("mul"):
            {
                System.out.println(a*b);
                break;
            }
            case ("div"):
            {
                System.out.println(a/b);
                break;
            }
        }
    }
}