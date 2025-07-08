package books;

import interfaces.Sendable;
import services.MailService;

public class EBook extends Book implements Sendable {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    @Override
    public boolean isAvailable() {
        return true; 
    }

    @Override
    public void sell(int quantity) {
       
    }

    @Override
    public void send(String email) {
        MailService.send(this, email);
    }
}
