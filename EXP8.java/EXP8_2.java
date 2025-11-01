package exp8;
import java.util.Scanner;

//Thread 1: Displays even numbers
class EvenThread extends Thread {
 private int[] numbers;

 public EvenThread(int[] numbers) {
     this.numbers = numbers;
 }

 public void run() {
     for (int num : numbers) {
         if (num % 2 == 0) {
             System.out.println("Even Thread: " + num);
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 System.out.println(e);
             }
         }
     }
 }
}

//Thread 2: Displays odd numbers
class OddThread extends Thread {
 private int[] numbers;

 public OddThread(int[] numbers) {
     this.numbers = numbers;
 }

 public void run() {
     for (int num : numbers) {
         if (num % 2 != 0) {
             System.out.println("Odd Thread: " + num);
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
public class EXP8_2 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int[] numbers = new int[10];

     System.out.println("Enter 10 numbers:");
     for (int i = 0; i < 10; i++) {
         numbers[i] = sc.nextInt();
     }

     EvenThread even = new EvenThread(numbers);
     OddThread odd = new OddThread(numbers);

     even.start();
     odd.start();
}
}

