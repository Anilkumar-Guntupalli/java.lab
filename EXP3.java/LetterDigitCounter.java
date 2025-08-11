package exp3;

import java.util.Scanner;

public class LetterDigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        int letterCount = 0, digitCount = 0;

        for (char ch : sentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
        }

        System.out.println("Letters: " + letterCount);
        System.out.println("Digits: " + digitCount);

        sc.close();
    }
}
