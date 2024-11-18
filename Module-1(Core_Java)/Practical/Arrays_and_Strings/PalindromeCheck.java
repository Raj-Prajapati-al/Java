import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String original = scanner.nextLine();

        if (isPalindrome(original)) { // OR  isPalindromeWithStringBuilder(original)
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        
        scanner.close();
    }
    public static boolean isPalindromeWitStringBuilder(String original)
    {   
        // Reverse a String with stringBuilder
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println("Reversed string: " + reversed);
        
        if (original.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isPalindrome(String originalStr) {
        // Reverse the string manually using a loop
        String reversed = "";
        for (int i = originalStr.length() - 1; i >= 0; i--) {
            reversed += originalStr.charAt(i);
        }

        System.out.println("Reversed string: " + reversed);

        // Check if the original string is a palindrome
        if (originalStr.equals(reversed)) {
            return true;
        } 
        return false;
    }

}

   