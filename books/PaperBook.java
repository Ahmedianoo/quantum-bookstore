package books;

import interfaces.Sendable;
import services.ShippingService;

public class PaperBook extends Book implements Sendable {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }


    public int getStock() { return stock; }

    @Override
    public boolean isAvailable() {

        return stock > 0 ? true : false;
        
    }

    @Override
    public void sell(int quantity) {
        if (quantity > stock) throw new IllegalStateException("Not enough stock for " + title);
        stock -= quantity;
    }

    @Override
    public void send(String address) {
        ShippingService.send(this, address);
    }
}
