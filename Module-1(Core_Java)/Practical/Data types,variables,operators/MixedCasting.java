public class MixedCasting {
    public static void main(String[] args)
     {    
        implicitCasting();
        explicitCasting();
    }
    public static void implicitCasting()
    {
        byte byteValue = 10;
        int intValue = byteValue; // Implicit casting from byte to int
        System.out.println("Integer value: " + intValue);

        double doubleValue = intValue; // Implicit casting from int to double
        System.out.println("Double value: " + doubleValue);

    }
    public static void explicitCasting()
    {   
        double doubleValue = 10.00;
        int anotherIntValue = (int) doubleValue; // Explicit casting from double to int
        System.out.println("Integer value after casting: " + anotherIntValue);

        byte anotherByteValue = (byte) anotherIntValue; // Explicit casting from int to byte
        System.out.println("Byte value after casting: " + anotherByteValue);
    }
}
