package resources;

import users.*;
import java.time.LocalDate;
import interfejses.Rentable;
import exceptions.NoAvailableResourceException;

public class Journal extends Resource implements Rentable {
    private final LocalDate publishDate;
    private LocalDate rentDate;
    private LocalDate dueDate;

    private User user;


    public Journal(String title, String publisher, int resourceId, LocalDate publishDate) {
        super(title, publisher, resourceId);
        this.publishDate = publishDate;
    }

    @Override
    public String getStatus() {
        return user == null ? Status.AVAILABLE.name() : Status.UNAVAILABLE.name();
    }

    @Override
    public void print() {
        System.out.println("Journal: " + title + ", published on " + publishDate);
    }

    @Override
    public void rent(User user) throws NoAvailableResourceException {
        if (this.user != null) throw new NoAvailableResourceException("Journal unavailable");
        this.user = user;
        this.rentDate = LocalDate.now();
        this.dueDate = user instanceof Student ? rentDate.plusMonths(1) : rentDate.plusDays(10);
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

