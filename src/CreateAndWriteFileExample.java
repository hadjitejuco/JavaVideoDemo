import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateAndWriteFileExample {
    public static void main(String[] args) {
        try {
            // Specify the file name and path here
            File myFile = new File("newfile.txt");

            // Create a FileWriter in append mode (true)
            FileWriter writer = new FileWriter(myFile, true);

            // Write a single character
            writer.write('A');

            // Always close the writer to release the resources
            writer.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
