package exp1;

import java.util.Scanner;
public class game{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberToGuess = 42; 
        int guess;
        System.out.println("Guess a number between 1 and 100:");
        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            if (guess > numberToGuess) {
                System.out.println("Too High");
            } else if (guess < numberToGuess) {
                System.out.println("Too Low");
            } else {
                System.out.println("Correct Guess!");
                break;
            }
        }
    }
}

