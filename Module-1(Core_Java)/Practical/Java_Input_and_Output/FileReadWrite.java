//3.Create a program that reads from one file and writes the content to another file.
package Module_1.Java_Input_and_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite 
{
    public static void main(String[] args) 
    {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) 
            {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("File read and write completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
