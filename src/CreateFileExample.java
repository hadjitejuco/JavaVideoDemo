import java.io.File;
import java.io.IOException;

public class CreateFileExample {
    public static void main(String[] args) {
        try {
            // Specify the file name and path here
            File myFile = new File("/Users/hadjitejuco/NetBeansProjects/JavaVideoDemo/newfile.txt");

            // Attempt to create the file
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
