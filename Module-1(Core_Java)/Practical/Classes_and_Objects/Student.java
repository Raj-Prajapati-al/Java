public class Student {
    // Attributes
    private String name;
    private int age;

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Creating an instance of Student and setting attributes
        Student student1 = new Student();
        student1.name = "John Doe";
        student1.age = 20;
        
        // Displaying the details of the student
        student1.displayDetails();
    }
}
