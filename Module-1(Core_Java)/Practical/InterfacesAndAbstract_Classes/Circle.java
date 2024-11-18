// Abstract class
abstract class Shape {
    abstract void draw();
    abstract double area();
}

// Subclass
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a circle.");
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.draw();
        System.out.println("Area of the circle: " + circle.area());
    }
}
