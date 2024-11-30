package resources;

import users.User;
import java.time.LocalDate;

public abstract class Resource {
    protected String title;
    protected String publisher;
    protected int resourceId;

    public Resource(String title, String publisher, int resourceId) {
        this.title = title;
        this.publisher = publisher;
        this.resourceId = resourceId;
    }

    public abstract void print();
    public abstract String getStatus();


    public abstract User getUser();
    public abstract LocalDate getDueDate();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return publisher;
    }
}

