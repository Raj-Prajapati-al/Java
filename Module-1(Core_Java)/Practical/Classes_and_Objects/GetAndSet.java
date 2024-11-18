public class GetAndSet
 {
    // Attributes
    private String name;
    private int age;

    // Default constructor
    public GetAndSet() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with two parameters
    public GetAndSet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method to test the GetAndSet and setters
    public static void main(String[] args) {
        GetAndSet GetAndSet1 = new GetAndSet();
        GetAndSet1.setName("John Doe");
        GetAndSet1.setAge(20);

        GetAndSet1.displayDetails();
    }
}
