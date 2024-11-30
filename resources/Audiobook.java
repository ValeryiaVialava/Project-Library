package resources;

import users.User;

import interfejses.Digital;
import java.time.LocalDate;

public class Audiobook extends Book implements Digital {
    private final int length;
    private int numberOfDownloads;

    public Audiobook(String title, String publisher, int resourceId, String author, int length) {
        super(title, publisher, resourceId, author);
        this.length = length;
        this.numberOfDownloads = 0;
    }

    @Override
    public String getStatus() {
        return Status.DIGITAL.name();
    }


    @Override
    public void print() {
        super.print();
        System.out.println("Length: " + length + " minutes");
    }

    @Override
    public void download() {
        numberOfDownloads++;
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

