package exp8;
import java.util.Scanner;

class WordThread implements Runnable {
    private String text;

    public WordThread(String text) {
        this.text = text;
    }

    public void run() {
        String[] words = text.split("\\s+");
        for (String word : words) {
            System.out.println("Word Thread: " + word);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class VowelThread implements Runnable {
    private String text;

    public VowelThread(String text) {
        this.text = text;
    }

    public void run() {
        for (char c : text.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                System.out.println("Vowel Thread: " + c);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class EXP8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph: ");
        String paragraph = sc.nextLine();

        Thread t1 = new Thread(new WordThread(paragraph));
        Thread t2 = new Thread(new VowelThread(paragraph));

        t1.start();
        t2.start();
    }
}
