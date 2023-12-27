import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("/Users/hadjitejuco/NetBeansProjects/JavaVideoDemo/input.txt");
            FileOutputStream out = new FileOutputStream("/Users/hadjitejuco/NetBeansProjects/JavaVideoDemo/output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
