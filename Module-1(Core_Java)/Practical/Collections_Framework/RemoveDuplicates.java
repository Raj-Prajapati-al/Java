// 2. Implement a program using HashSet to remove duplicate elements from a list.
package Module_1.Collections_Framework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates 
{
    public static void main(String[] args) 
    {
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("Apple");
        listWithDuplicates.add("Banana");
        listWithDuplicates.add("Apple");
        listWithDuplicates.add("Cherry");
        listWithDuplicates.add("Banana");

        System.out.println("List with duplicates: " + listWithDuplicates);

        // Removing duplicates using HashSet
        HashSet<String> set = new HashSet<>(listWithDuplicates);
        List<String> listWithoutDuplicates = new ArrayList<>(set);

        System.out.println("List without duplicates: " + listWithoutDuplicates);
    }
}
