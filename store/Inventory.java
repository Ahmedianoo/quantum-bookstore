package store;

import books.Book;
import books.PaperBook;

import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

public void addBook(Book book) {
    Book existing = books.get(book.getIsbn());

    if (existing != null && existing instanceof books.PaperBook && book instanceof books.PaperBook) {
        PaperBook oldBook = (PaperBook) existing;
        PaperBook newBook = (PaperBook) book;

        int updatedStock = oldBook.getStock() + newBook.getStock();
        PaperBook combined = new PaperBook(oldBook.getIsbn(), oldBook.getTitle(), oldBook.getYear(), oldBook.getPrice(), oldBook.getAuthor(), updatedStock);
        books.put(book.getIsbn(), combined);
    } else {
        books.put(book.getIsbn(), book);
    }
}


    public Book getByIsbn(String isbn) {
        return books.get(isbn);
    }

    public List<Book> removeBooks(int maxYears, int currentYear) {
        List<Book> outdatedBooks = new ArrayList<>();

        for (Book book : new ArrayList<>(books.values())) {
            int age = currentYear - book.getYear();
            if (age > maxYears) {
                outdatedBooks.add(book);
                books.remove(book.getIsbn());
            }
        }

        return outdatedBooks;
    }

}