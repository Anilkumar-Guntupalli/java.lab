package exp8;
import java.util.Scanner;

//Thread 1: Displays multiplication table
class TableThread extends Thread {
 private int number;

 public TableThread(int number) {
     this.number = number;
 }

 public void run() {
     for (int i = 1; i <= 10; i++) {
         System.out.println("Table Thread: " + number + " x " + i + " = " + (number * i));
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             System.out.println(e);
         }
     }
 }
}

//Thread 2: Displays all factors of the number
class DivisorThread extends Thread {
 private int number;

 public DivisorThread(int number) {
     this.number = number;
 }

 public void run() {
     System.out.println("Divisors of " + number + ":");
     for (int i = 1; i <= number; i++) {
         if (number % i == 0) {
             System.out.println("Divisor Thread: " + i);
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 System.out.println(e);
             }
         }
     }
 }
}

//Main class
public class EXP8_3 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter a number: ");
     int num = sc.nextInt();

     TableThread t1 = new TableThread(num);
     DivisorThread t2 = new DivisorThread(num);

     t1.start();
     t2.start();
 }
}

