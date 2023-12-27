import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OverwriteFileFromUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask the user for input
            System.out.print("Enter a character to write to the file: ");
            char userChar = scanner.nextLine().charAt(0);

            // Specify the file name and path here
            File myFile = new File("newfile.txt");

            // Create a FileWriter without append mode (default behavior is to overwrite)
            FileWriter writer = new FileWriter(myFile);

            // Write the character provided by the user
            writer.write(userChar);

            // Always close the writer to release the resources
            writer.close();

            System.out.println("Successfully wrote the character to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
