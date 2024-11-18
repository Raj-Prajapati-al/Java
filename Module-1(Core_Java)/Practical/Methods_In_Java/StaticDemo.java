public class StaticDemo {
    // Static variable
    static int staticCount = 0;

    // Static method
    public static void incrementCount() {
        staticCount++;
    }

    // Instance method
    public void showCount() {
        System.out.println("Static count: " + staticCount);
    }

    public static void main(String[] args) {
        StaticDemo.incrementCount(); // Call static method without creating an instance
        StaticDemo.incrementCount();

        StaticDemo obj1 = new StaticDemo();
        StaticDemo obj2 = new StaticDemo();

        obj1.showCount(); // Outputs: Static count: 2
        obj2.showCount(); // Outputs: Static count: 2

        StaticDemo.incrementCount();

        obj1.showCount(); // Outputs: Static count: 3
        obj2.showCount(); // Outputs: Static count: 3
    }
}
