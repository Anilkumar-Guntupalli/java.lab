package exp2;
import java.util.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        char[] small = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] capital = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

    
        System.out.print("Enter the password length: ");
        int length = sc.nextInt();

        if (length < 3) {
            System.out.println("Password length must be at least 3 to include all types.");
            return;
        }

        Random rand = new Random();
        char[] password = new char[length];

        password[0] = small[rand.nextInt(small.length)];
        password[1] = capital[rand.nextInt(capital.length)];
        password[2] = numbers[rand.nextInt(numbers.length)];

        char[] allChars = new char[small.length + capital.length + numbers.length];
        System.arraycopy(small, 0, allChars, 0, small.length);
        System.arraycopy(capital, 0, allChars, small.length, capital.length);
        System.arraycopy(numbers, 0, allChars, small.length + capital.length, numbers.length);

        for (int i = 3; i < length; i++) {
            password[i] = allChars[rand.nextInt(allChars.length)];
        }

      
        for (int i = 0; i < password.length; i++) {
            int randomIndex = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomIndex];
            password[randomIndex] = temp;
        }

    
        System.out.println("The Generated Password is: " + new String(password));
    }
}
