import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendToFileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask the user for input
            System.out.print("Enter a string to append to the file: ");
            String userInput = scanner.nextLine();

            // Specify the file name and path here
            File myFile = new File("newfile.txt");

            // Create a FileWriter in append mode
            FileWriter writer = new FileWriter(myFile, true);

            // Append the string provided by the user to the file
            writer.write(userInput + "\n"); // Adding a newline for separation

            // Always close the writer to release the resources
            writer.close();

            System.out.println("Successfully appended the string to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
