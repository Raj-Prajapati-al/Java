// 3. Create a HashMap to Store and Retrieve Key-Value Pairs Using HashMap
package Module_1.Collections_Framework;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo 
{
    public static void main(String[] args) 
    {
        // Create a HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // Add key-value pairs to the HashMap
        hashMap.put("Apple", 3);
        hashMap.put("Banana", 2);
        hashMap.put("Cherry", 5);

        // Retrieve values from the HashMap
        System.out.println("Value for Apple: " + hashMap.get("Apple"));
        System.out.println("Value for Banana: " + hashMap.get("Banana"));

        // Iterate over the HashMap
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
