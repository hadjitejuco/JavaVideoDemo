import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    // Constructor
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
}

public class OOP1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Book[] books = new Book[2];
        
        for(int i = 0; i < books.length; i++) {
            System.out.print("Enter title for book " + (i+1) + ": ");
            String title = scanner.nextLine();
            
            System.out.print("Enter author for book " + (i+1) + ": ");
            String author = scanner.nextLine();

            System.out.print("Enter price for book " + (i+1) + ": ");
            double price = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            
            books[i] = new Book(title, author, price);
        }
        
        System.out.println("\nBooks in the store:");
        for(Book book : books) {
            book.displayInfo();
        }
        
        scanner.close();
    }
}
