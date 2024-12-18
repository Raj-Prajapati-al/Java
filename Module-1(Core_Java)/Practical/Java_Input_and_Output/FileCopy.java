//2.Implement a file copy program using FileInputStream and FileOutputStream.
package Module_1.Java_Input_and_Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy 
{
    public static void main(String[] args) 
    {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) 
        {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) 
            {
                fos.write(buffer, 0, length);
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
