public class ConstructorDemo {
    // Attributes
    private String name;
    private int age;

    // Default constructor
    public ConstructorDemo() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with one parameter
    public ConstructorDemo(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor with two parameters
    public ConstructorDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method to test the constructors
    public static void main(String[] args) {
        ConstructorDemo ConstructorDemo1 = new ConstructorDemo();
        ConstructorDemo ConstructorDemo2 = new ConstructorDemo("John Doe");
        ConstructorDemo ConstructorDemo3 = new ConstructorDemo("Jane Doe", 22);

       ConstructorDemo1.displayDetails();
       ConstructorDemo2.displayDetails();
       ConstructorDemo3.displayDetails();
    }
}
