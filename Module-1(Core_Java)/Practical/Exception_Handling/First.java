// Write a program to demonstrate exception handling using try-catch-finally. 

public class First {
    public static void main(String[] args) {
        int numOne = 10;
        int numTwo = 0;
        int result = 0;

        try 
        {
            result = numOne / numTwo;  // This line will throw an ArithmeticException
            System.out.println("Result is: " + result);
        } 
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        } 
        finally {
            System.out.println("Finally block is executed.");
        }
    }
}
