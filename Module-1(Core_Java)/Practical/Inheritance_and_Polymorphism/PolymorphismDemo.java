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
        Animal myAnimal;
        
        myAnimal = new Dog(); // Upcasting
        myAnimal.makeSound(); // Outputs: Woof
        
        myAnimal = new Cat(); // Upcasting
        myAnimal.makeSound(); // Outputs: Meow
    }
}
