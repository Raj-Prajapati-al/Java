// 3. Demonstrate Object Serialization and Deserialization
package Module_1.File_Handling;

import java.io.*;

class Person implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializationExample 
{
    public static void main(String[] args) 
    {
        String filePath = "person.ser";
        
        // Serialize an object
        Person person = new Person("John Doe", 30);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
