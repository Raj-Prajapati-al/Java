public class Employee {
    private String name;
    private int age;
    private double gpa;
    private String address;

    // Constructor with name and age
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Constructor with name, age, and GPA
    public Employee(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Constructor with name, age, GPA, and address
    public Employee(String name, int age, double gpa, String address) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.address = address;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (gpa != 0) {
            System.out.println("GPA: " + gpa);
        }
        if (address != null) {
            System.out.println("Address: " + address);
        }
    }

    public static void main(String[] args) {
        // Creating and initializing objects using different constructors
        Employee Employee1 = new Employee("John Doe", 20);
        Employee Employee2 = new Employee("Jane Doe", 21, 3.9);
        Employee Employee3 = new Employee("Jim Beam", 22, 3.8, "123 Main St, Springfield");

        Employee1.displayDetails();
        System.out.println();
        Employee2.displayDetails();
        System.out.println();
        Employee3.displayDetails();
    }
}
