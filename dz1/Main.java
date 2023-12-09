package dz1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        User user1 = new User();
        Scanner in = new Scanner(System.in);

        System.out.print("enter phone number:");
        user1.setPhone(Long.parseLong(in.nextLine()));

        System.out.print("enter name:");
        user1.setName(in.nextLine());

        System.out.print("enter avg score:");
        //rabota with zapyataya
        String handleComma = in.nextLine();
        if (handleComma.contains(",")) {
            //System.out.print("match");
            handleComma = handleComma.replace(',', '.');
        }
        user1.setScore((Double.parseDouble(handleComma)));


        System.out.print("\nphone = " + user1.getPhone());
        System.out.print("\nname = " + user1.getName());
        System.out.print("\nscore = " + user1.getScore());
    }
}