import java.util.Scanner;

public class MaxOfThree {

    // Method to find the maximum of three numbers
    public static int findMax(int num1, int num2, int num3) {
        int max = num1; // Assume num1 is the largest initially

        if (num2 > max) {
            max = num2;
        }

        if (num3 > max) {
            max = num3;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        int max = findMax(num1, num2, num3);
        System.out.println("The maximum of the three numbers is: " + max);

        scanner.close();
    }
}
