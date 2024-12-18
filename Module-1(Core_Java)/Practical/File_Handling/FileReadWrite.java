// 1. Read and Write Content to a File Using FileReader and FileWriter
package Module_1.File_Handling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite 
{
    public static void main(String[] args) 
    {
        String filePath = "example.txt";
        
        // Writing to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello, world!\n");
            writer.write("This is a test file.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Reading from the file
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
