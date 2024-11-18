import java.util.Scanner;

public class MenuDrivenProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Say Hello");
            System.out.println("2. Display Current Time");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hello!");
                    break;
                case 2:
                    System.out.println("Current time: " + java.time.LocalTime.now());
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

            System.out.println(); // Add an empty line for better readability
        }

        scanner.close();
    }
}
