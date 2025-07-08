package test;

import books.*;
import store.QuantumBookstore;

public class TestQuantumBookstore {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        Book paperBook = new PaperBook("111", "Java 101", 2019, 100.0, "Khalid", 3);
        Book ebook = new EBook("222", "Python Guide", 2020, 50.0, "Said", "PDF");
        Book showcaseBook = new ShowcaseBook("333", "Ancient Book", 1990, 1000.0, "Unknown");

        store.addBook(paperBook);
        store.addBook(ebook);
        store.addBook(showcaseBook);

        store.buy("111", 2, "ahmed@example.com", "Cairo, Egypt");
        store.buy("222", 1, "nada@example.com", "");
        store.buy("333", 1, "laila@example.com", "");

        store.removeBooks(10, 2025); 
    }
}