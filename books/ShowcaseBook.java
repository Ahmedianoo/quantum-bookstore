package books;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }


    @Override
    public void sell(int quantity) {
        throw new IllegalStateException("You can't buy a showcase book.");
    }

}
