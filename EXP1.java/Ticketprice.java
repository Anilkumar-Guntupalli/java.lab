package exp1;

import java.util.Scanner;
public class Ticketprice{

    public static void main(String[] args) {
        double price = 200;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");

        int age = input.nextInt();

        input.nextLine();

        System.out.print("Enter day of booking (Mon/Tue/Wed/Thu/Fri/Sat/Sun): ");

        String day = input.nextLine();

        double discount = 0;

        if (age < 5) {

            discount = 100; 

        } else if (age >= 5 && age <= 18) {

            discount = 40;

        } else if (age > 60) {

            discount = 30;

        }



        if ((day.equalsIgnoreCase("Mon") || day.equalsIgnoreCase("Tue") ||

             day.equalsIgnoreCase("Wed") || day.equalsIgnoreCase("Thu") ||

             day.equalsIgnoreCase("Fri")) && discount < 100) {

            discount += 10;

        }

        double finalPrice = price * (1 - discount / 100);

        System.out.println("You got a discount of " + discount + "%.");

        System.out.println("Final ticket price: ₹" + finalPrice);



        input.close();

    }

}