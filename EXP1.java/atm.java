package exp1;

import java.util.Scanner;
public class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000;
        int choice;
        while (true) {
            System.out.println("1.Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Balance: ₹" + balance);
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double deposit = sc.nextDouble();
                balance += deposit;
                System.out.println("Deposited ₹" + deposit);
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double withdraw = sc.nextDouble();
                if (withdraw <= balance) {
                    balance -= withdraw;
                    System.out.println("Withdrawn ₹" + withdraw);
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else if (choice == 4) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}