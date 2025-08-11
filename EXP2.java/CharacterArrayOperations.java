package exp2;
import java.util.*;

public class CharacterArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the characters (space-separated): ");
        String input = sc.nextLine();
        char[] charArray = input.replace(" ", "").toCharArray();

        Set<Character> duplicates = new LinkedHashSet<>();
        Set<Character> seen = new HashSet<>();
        int vowelCount = 0, consonantCount = 0;
        String vowels = "aeiouAEIOU";

        for (char ch : charArray) {
            
            if (!seen.add(ch)) {
                duplicates.add(ch);
            }
           
            if (Character.isLetter(ch)) {
                if (vowels.indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

      
        System.out.print("Duplicate Characters are: ");
        for (char ch : duplicates) {
            System.out.print(ch + ", ");
        }
        System.out.println("\nNumber of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }
}

