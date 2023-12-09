package dz2;

import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //double x, y, z;
        System.out.print("enter numbers (enter char to stop):\n");

        Vector<Double> params = new Vector<Double>();
        String input = in.nextLine();
        String[] temp = input.split(" ");
        for(String a : temp)
        {
            params.add(Double.parseDouble(a));
        }

        System.out.print("avg = " + average(params));
    }

    public static double average(Vector<Double> params)
    {
        double res = 0;
        for (double a : params)
        {
            res += a;
        }
        return(res/params.size());
    }
}
