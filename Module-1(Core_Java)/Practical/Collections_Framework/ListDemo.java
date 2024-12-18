//1.Write a program that demonstrates the use of an ArrayList and LinkedList.
package Module_1.Collections_Framework;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo 
{
    public static void main(String[] args) 
    {
        // ArrayList demonstration
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        // LinkedList demonstration
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Frog");
        System.out.println("LinkedList: " + linkedList);
    }
}

