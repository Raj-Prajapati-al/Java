// Superclass
class Animal {
    void makeSound() {
        System.out.println("This animal makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}

// Subclass
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Upcasting
        Animal myCat = new Cat(); // Upcasting

        myDog.makeSound(); // Outputs: Woof
        myCat.makeSound(); // Outputs: Meow
    }
}
