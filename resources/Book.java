package resources;

public abstract class Book extends Resource {
    protected String author;

    public Book(String title, String publisher, int resourceId, String author) {
        super(title, publisher, resourceId);
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println("Book: " + title + " by " + author);
    }

    public boolean isTheSameBook(Book otherBook) {
        return this.title.equals(otherBook.title) && this.author.equals(otherBook.author);
    }
}
