// Implement multiple catch blocks for different types of exceptions.  
public class Second 
{
    @SuppressWarnings("null")
    public static void main(String[] args) 
    {
        String name = null;
        int[] arr = new int[4];
        int numOne = 10;
        int numTwo = 0;
        int result = 0;

        try {
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println("Value at index 4: " + arr[4]);
            // This will throw NullPointerException
            System.out.println("Name length: " + name.length());
            // This will throw ArithmeticException
            result = numOne / numTwo;
            System.out.println("Result is: " + result);
        } catch (NullPointerException e) {
            System.out.println("String is null: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block is executed.");
        }
    }
}
