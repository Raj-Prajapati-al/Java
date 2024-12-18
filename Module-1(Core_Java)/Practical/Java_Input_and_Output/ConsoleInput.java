// 1. Read Input from the Console Using Scanner
package Module_1.Java_Input_and_Output;
import java.util.Scanner;

public class ConsoleInput 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Hello, " + name + "! You are " + age + " years old.");
        
        scanner.close();
    }
}
