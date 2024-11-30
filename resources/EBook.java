package resources;

import interfejses.Digital;
import users.User;

import java.time.LocalDate;

public class EBook extends Book implements Digital {
    private final double size;
    private int numberOfDownloads;

    public EBook(String title, String publisher, int resourceId, String author, double size) {
        super(title, publisher, resourceId, author);
        this.size = size;
        this.numberOfDownloads = 0;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Size: " + size + "MB");
    }

    @Override
    public String getStatus() {
        return Status.DIGITAL.name();
    }


    @Override
    public void download() {
        numberOfDownloads++;
    }

    public int getNumberOfDownloads() {
        return numberOfDownloads;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public LocalDate getDueDate() {
        return null;
    }

}
