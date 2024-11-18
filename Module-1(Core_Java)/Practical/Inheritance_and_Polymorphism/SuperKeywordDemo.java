// Superclass
class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Method to display the name
    void display() {
        System.out.println("Name: " + name);
    }
}

// Subclass
class Dog extends Animal {
    // Constructor
    Dog(String name) {
        super(name); // Call the parent class constructor
    }

    // Overriding the display method
    @Override
    void display() {
        super.display(); // Call the parent class method
        System.out.println("This is a dog.");
    }
}

public class SuperKeywordDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.display(); // Calls the overridden display method from Dog class
    }
}
