package dz8;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String op;
        double a, b;

        while (true)
        {
            System.out.print("enter operation (enter exit to quit)\n");
            op = in.next();

            if (op.equals("exit"))
            {
                return;
            }

            System.out.print("enter numbers:\n");
            try
            {
                a = Double.parseDouble(in.next());
                b = Double.parseDouble(in.next());
                System.out.print("reached the end of try block\n");
            }
            catch (NumberFormatException e)
            {
                System.out.print(e + ", most likely caused by invalid input\n");
                continue;
            }

            Double res = 0.0;
            switch (op)
            {
                case ("add"):
                {
                    res = a+b;
                    System.out.println(res);
                    break;
                }
                case ("sub"):
                {
                    res = a-b;
                    System.out.println(res);
                    break;
                }
                case ("mul"):
                {
                    res = a*b;
                    System.out.println(res);
                    break;
                }
                case ("div"):
                {
                    if(b == 0)
                    {
                        if(a==0)
                        {
                            System.out.println("indeterminateable");
                            continue;
                        }
                        if(a>0)
                        {
                            res = Double.POSITIVE_INFINITY;
                        }
                        if (a<0)
                        {
                            res = Double.NEGATIVE_INFINITY;
                        }
                    }
                    else
                        res = a/b;

                    System.out.println(res);
                    break;
                }
            }
        }
    }
}
