public class Student {
    private String name;
    private int age;

    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating and initializing an object using a parameterized constructor
        Student student1 = new Student("John Doe", 20);
        student1.displayDetails();
    }
}
