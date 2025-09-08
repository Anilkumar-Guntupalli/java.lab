package CakeShop;
import java.util.Scanner;


class Cake {
 protected String name;
 protected String flavor;
 protected double price;

 public Cake(String name, String flavor, double price) {
     this.name = name;
     this.flavor = flavor;
     this.price = price;
 }

 public void calculatePrice() {
     System.out.println("Base Price of Cake: " + price);
 }
}

class OrderCake extends Cake {
 private double weight; 

 public OrderCake(String name, String flavor, double price, double weight) {
     super(name, flavor, price);
     this.weight = weight;
 }

 
 public void calculatePrice() {
     double total = price * weight;
     System.out.println("OrderCake Price (price * weight): " + total);
 }
}


class ReadyMadeCake extends Cake {
 private int quantity;

 public ReadyMadeCake(String name, String flavor, double price, int quantity) {
     super(name, flavor, price);
     this.quantity = quantity;
 }


 public void calculatePrice() {
     double total = price * quantity;
     System.out.println("ReadyMadeCake Price (price * quantity): " + total);
 }
}


public class CakeShop {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Cake cake = null;

     System.out.println("Choose Cake Type:");
     System.out.println("1. OrderCake");
     System.out.println("2. ReadyMadeCake");
     int choice = sc.nextInt();
     sc.nextLine();

     System.out.print("Enter Cake Name: ");
     String name = sc.nextLine();
     System.out.print("Enter Flavor: ");
     String flavor = sc.nextLine();
     System.out.print("Enter Base Price: ");
     double price = sc.nextDouble();

     if (choice == 1) {
         System.out.print("Enter Weight (kg): ");
         double weight = sc.nextDouble();
         cake = new OrderCake(name, flavor, price, weight);
     } else if (choice == 2) {
         System.out.print("Enter Quantity: ");
         int quantity = sc.nextInt();
         cake = new ReadyMadeCake(name, flavor, price, quantity);
     } else {
         System.out.println("Invalid choice!");
         System.exit(0);
     }

     int option;
     do {
         System.out.println("\n--- Cake Menu ---");
         System.out.println("1. Calculate Price");
         System.out.println("2. Exit");
         System.out.print("Enter choice: ");
         option = sc.nextInt();

         switch (option) {
             case 1:
                 cake.calculatePrice();
                 break;
             case 2:
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid option!");
         }
     } while (option != 2);

     sc.close();
 }
}

