import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        
        // Using equals() method
        if (str1.equals(str2)) {
            System.out.println("The strings are equal using equals().");
        } else {
            System.out.println("The strings are not equal using equals().");
        }
        
        // Using compareTo() method
        int result = str1.compareTo(str2);
        if (result == 0) {
            System.out.println("The strings are equal using compareTo().");
        } else if (result > 0) {
            System.out.println("The first string is greater than the second string using compareTo().");
        } else {
            System.out.println("The first string is less than the second string using compareTo().");
        }
        
        scanner.close();
    }
}
