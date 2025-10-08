package SmartDeviceStore;
import java.util.Scanner;
import EXP6.Smartphone;
interface Discountable {
	 void applyDiscount(double percentage);
	 double finalPrice();
	}
abstract class Device {
	 int deviceId;
	 String brand;
	 double price;
	 Device(int deviceId, String brand, double price) {
	     this.deviceId = deviceId;
	     this.brand = brand;
	     this.price = price;
	 }
	 public abstract void displayDetails();
}
class Smartphone extends Device implements Discountable {
	 double discountedPrice;
Smartphone(int deviceId, String brand, double price) {
	     super(deviceId, brand, price);
	     this.discountedPrice = price; 
	 }
public void applyDiscount(double percentage) {
    if (percentage > 0 && percentage <= 100) {
        discountedPrice = price - (price * percentage / 100);
        System.out.println("Discount of " + percentage + "% applied successfully!");
    } else {
        System.out.println("Invalid discount percentage!");
    }
}
public double finalPrice() {
    return discountedPrice;
}
public void displayDetails() {
    System.out.println("------ Smartphone Details ------");
    System.out.println("Device ID: " + deviceId);
    System.out.println("Brand : " + brand);
    System.out.println("Original Price: " + price);
    System.out.println("Final Price : " + discountedPrice);
}
}
public class SmartDeviceStore {
	 public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     Smartphone smartphone = null;
	     int choice;
	     do {
	         System.out.println("\n--- Smart Device Store Menu ---");
	         System.out.println("1. Add Smartphone");
	         System.out.println("2. Apply Discount");
	         System.out.println("3. View Device Details");
	         System.out.println("4. Exit");
	         System.out.print("Enter your choice: ");
	         choice = sc.nextInt();
	         switch (choice) {
	         case 1:
                 System.out.print("Enter Device ID: ");
                 int id = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter Brand: ");
                 String brand = sc.nextLine();
                 System.out.print("Enter Price: ");
                 double price = sc.nextDouble();
                 smartphone = new Smartphone(id, brand, price);
                 System.out.println("Smartphone added successfully!");
                 break;
	         case 2:
                 if (smartphone != null) {
                     System.out.print("Enter Discount Percentage: ");
                     double discount = sc.nextDouble();
                     smartphone.applyDiscount(discount);
                 } else {
                     System.out.println("No smartphone found. Please add one first.");
                 }
                 break;
	         case 3 :
	        	 if (smartphone != null) {
	        		 smartphone.displayDetails();
	        	 }
	        	 else {
	        		 System.out.println("No smartphone found. Please add one first.");
	        		 break;
	        	 }
	         case 4:
                 System.out.println("Exiting... Thank you!");
                 break;
             default:
                 System.out.println("Invalid choice! Try again.");
         }
     } while (choice != 4);
     sc.close();
 }

}              
