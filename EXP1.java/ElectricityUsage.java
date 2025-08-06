package exp1;

import java.util.Scanner;
public class ElectricityUsage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] units = new int[12];
        int total = 0;
        for (int i = 0; i < 12; i++) {
            System.out.print("Enter units for month " + (i + 1) + ": ");
            units[i] = scanner.nextInt();
            total += units[i];
        }
        double average = total / 12.0;
        System.out.println("Total units consumed in the year: " + total);
        System.out.println("Average monthly usage: " + average);
        if (average > 500) {
            System.out.println("High Consumption Alert!");
        }
    }
}
