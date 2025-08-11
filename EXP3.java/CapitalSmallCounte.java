package exp3;
import java.util.ArrayList;
import java.util.Scanner;

public class CapitalSmallCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.println("Enter the paragraph:");
        String paragraph = sc.nextLine();

      
        ArrayList<Character> capitals = new ArrayList<>();
        ArrayList<Character> smalls = new ArrayList<>();

        
        for (char ch : paragraph.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                capitals.add(ch);
            } else if (Character.isLowerCase(ch)) {
                smalls.add(ch);
            }
        }

        System.out.print("Total Capital Letters: " + capitals.size() + " and they are ");
        for (int i = 0; i < capitals.size(); i++) {
            System.out.print(capitals.get(i));
            if (i < capitals.size() - 1) System.out.print(", ");
        }
        System.out.println();

        System.out.print("Total Small Letters: " + smalls.size() + " and they are ");
        for (int i = 0; i < smalls.size(); i++) {
            System.out.print(smalls.get(i));
            if (i < smalls.size() - 1) System.out.print(", ");
        }
        System.out.println();

        sc.close();
    }
}
