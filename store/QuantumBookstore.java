package store;

import java.util.List;

import books.Book;
import books.EBook;
import interfaces.Sendable;

public class QuantumBookstore {
    private Inventory inventory;

    public QuantumBookstore() {
        this.inventory = new Inventory();
    }


    public void addBook(Book book) {
        inventory.addBook(book);
    }




    public void removeBooks(int maxYears, int currentYear) {
        List<Book> outdatedBooks = inventory.removeBooks(maxYears, currentYear);
        if (outdatedBooks.isEmpty()) {
            System.out.println("Quantum book store: No outdated books found.");
            return;
        }
        for (Book book : outdatedBooks) {
            System.out.println("Quantum book store: Removed outdated book - " + book.getTitle());
        }
    }

    public double buy(String isbn, int quantity, String email, String address) {
        Book book = inventory.getByIsbn(isbn);
        if (book == null) {
            System.out.println("Quantum book store: Book not found.");
            return 0.0;
        }

        if (!book.isAvailable()) {
            System.out.println("Quantum book store: Book not available.");
            return 0.0;
        }

        book.sell(quantity);
        double paidAmount = book.getPrice() * quantity;

        if (book instanceof Sendable) {
            Sendable sendable = (Sendable) book;
            String contact = (book instanceof EBook) ? email : address;
            sendable.send(contact);
        }

        System.out.println("Quantum book store: Book purchased successfully.");
        System.out.println("Quantum book store: Amount paid = " + paidAmount);
        return paidAmount;
    }
}
