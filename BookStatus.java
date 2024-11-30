
public class BookStatus {
    private final String bookKey;
    private int available;
    private int unavailable;

    public BookStatus(String bookKey) {
        this.bookKey = bookKey;
        this.available = 0;
        this.unavailable = 0;
    }

    public String getBookKey() {
        return bookKey;
    }

    public int getAvailable() {
        return available;
    }

    public int getUnavailable() {
        return unavailable;
    }

    public void incrementAvailable() {
        available++;
    }

    public void incrementUnavailable() {
        unavailable++;
    }
}