import java.util.*;
public class Library {
    String Address;
    ArrayList<Book> Book = new ArrayList<Book>();

    // Add the missing implementation to this class
    public Library(String Address) {
        this.Address = Address;
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");

    }
    public void printAddress() {
        System.out.println(this.Address);
    }

    public void addBook(Book Book) {
        this.Book.add(Book);
    }

    public void borrowBook(String title) {
        for(Book Books : this.Book) {
            if(title.equalsIgnoreCase(Books.getTitle())) {
                if(Books.borrowed) {
                    System.out.println("Sorry this book is already borrowed.");
                        return;
                } else {
                    Books.borrowed();
                    System.out.println("You successfully borrowed " + title);
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

        public void printAvailableBooks() {
            for(Book Books : this.Book) {
                if(!Books.borrowed) {
                    System.out.println(Books.title);
                }
            }
            if(this.Book.isEmpty()) {
                System.out.println("No book in catalog");
            }
        }
        public void returnBook(String title) {
            for(Book Books : this.Book) {
                if(title.equalsIgnoreCase(Books.getTitle())) {
                    if(Books.borrowed) {
                        Books.returned();
                        System.out.println("You successfully returned " + title);
                        return;
                    } else {
                        System.out.println("Nobody borrowed \\" + title +  "\\yet");
                    }
                }
            }
        }
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 

