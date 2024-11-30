package resources;

import users.*;


import java.time.LocalDate;
import exceptions.NoAvailableResourceException;
import interfejses.Rentable;

public class PaperBook extends Book implements Rentable {
    private final int pages;
    private LocalDate dueDate;
    private User user;


    public PaperBook(String title, String publisher, int resourceId, String author, int pages) {
        super(title, publisher, resourceId, author);
        this.pages = pages;
    }

    @Override
    public String getStatus() {
        return user == null ? Status.AVAILABLE.name() : Status.UNAVAILABLE.name();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Pages: " + pages);
    }

    public void rent(User user) throws NoAvailableResourceException {
        if (this.user != null) {
            System.out.println("Book is rented");
            throw new NoAvailableResourceException("PaperBook is already rented");

        }
        this.user = user;
        LocalDate rentDate = LocalDate.now();
        this.dueDate = user instanceof Student ? rentDate.plusMonths(1) : rentDate.plusMonths(3);
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
