package dz5;


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
                System.out.println(add(a, b));
                break;
            }
            case ("sub"):
            {
                System.out.println(sub(a, b));
                break;
            }
            case ("mul"):
            {
                System.out.println(mul(a, b));
                break;
            }
            case ("div"):
            {
                System.out.println(div(a, b));
                break;
            }
        }
    }

    public static double add(double a, double b)
    {
        return(a+b);
    }

    public static double add(int a, int b)
    {
        return(a+b);
    }

    public static double sub(int a, int b)
    {
        return(a-b);
    }
    public static double sub(double a, double b)
    {
        return(a-b);
    }

    public static double mul(int a, int b)
    {
        return(a*b);
    }
    public static double mul(double a, double b)
    {
        return(a*b);
    }

    public static double div(double a, double b)
    {
        return(a/b);
    }

    public static double div(int a, int b)
    {
        return(a/b);
    }
}