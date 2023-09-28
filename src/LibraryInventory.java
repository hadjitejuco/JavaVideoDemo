import java.util.Scanner;

class Book {
    private String title;
    private boolean isAvailable;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    public void checkIn() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + " (Available: " + isAvailable + ")";
    }
}

public class LibraryInventory {
    private String libraryName;
    private Book[] books;

    public LibraryInventory(String libraryName) {
        this.libraryName = libraryName;
        this.books = new Book[0];
    }

    public void addBook(String title) {
        Book newBook = new Book(title);
        Book[] newBooks = new Book[books.length + 1];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[books.length] = newBook;
        books = newBooks;
    }

     public void deleteBook(int index) {
        if (index < 0 || index >= books.length) {
            System.out.println("Invalid index.");
            return;
        }
        if (!books[index].isAvailable()) {
            System.out.println("Cannot delete a book that's checked out.");
            return;
        }
        Book[] newBooks = new Book[books.length - 1];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (i == index) continue;
            newBooks[j++] = books[i];
        }
        books = newBooks;
    }

    public void modifyBook(int index, String newTitle) {
        if (index < 0 || index >= books.length) {
            System.out.println("Invalid index.");
            return;
        }
        if (!books[index].isAvailable()) {
            System.out.println("Cannot modify a book that's checked out.");
            return;
        }
        books[index].setTitle(newTitle);
    }

    public Book[] getBooks() {
        return books.clone();
    }

    public void displayTotalBooks() {
        int totalAvailable = 0;
        int totalCheckedOut = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                totalAvailable++;
            } else {
                totalCheckedOut++;
            }
        }

        System.out.println("Total books: " + books.length);
        System.out.println("Available books: " + totalAvailable);
        System.out.println("Checked out books: " + totalCheckedOut);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter library name: ");
        String name = scanner.nextLine();

        LibraryInventory inventory = new LibraryInventory(name);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add book");
            System.out.println("2. Display books");
            System.out.println("3. Check total books");
            System.out.println("4. Check out book");
            System.out.println("5. Check in book");
            System.out.println("6. Delete book");
            System.out.println("7. Modify book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String book = scanner.nextLine();
                    inventory.addBook(book);
                    break;

                case 2:
                    System.out.println("Books in " + name + ":");
                    int index = 0;
                    for (Book b : inventory.getBooks()) {
                        System.out.println(index++ + ". " + b);
                    }
                    break;

                case 3:
                    inventory.displayTotalBooks();
                    break;

                case 4:
                    System.out.print("Enter the index of the book to check out: ");
                    int checkoutIndex = scanner.nextInt();
                    if (checkoutIndex >= 0 && checkoutIndex < inventory.getBooks().length) {
                        inventory.getBooks()[checkoutIndex].checkOut();
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the index of the book to check in: ");
                    int checkinIndex = scanner.nextInt();
                    if (checkinIndex >= 0 && checkinIndex < inventory.getBooks().length) {
                        inventory.getBooks()[checkinIndex].checkIn();
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 6:
                    System.out.print("Enter the index of the book to delete: ");
                    int deleteIndex = scanner.nextInt();
                    inventory.deleteBook(deleteIndex);
                    break;
                case 7:
                    System.out.print("Enter the index of the book to modify: ");
                    int modifyIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter the new book title: ");
                    String modifyBook = scanner.nextLine();
                    inventory.modifyBook(modifyIndex, modifyBook);
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            
            }
        }
    }
}
