public class MethodOverloading {
    // Overloaded methods for addition with different data types

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method to add two floats
    public float add(float a, float b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MethodOverloading calculator = new MethodOverloading();

        System.out.println("Addition of two integers: " + calculator.add(10, 20));
        System.out.println("Addition of two doubles: " + calculator.add(10.5, 20.5));
        System.out.println("Addition of two floats: " + calculator.add(10.5f, 20.5f));
        System.out.println("Addition of three integers: " + calculator.add(10, 20, 30));
    }
}
