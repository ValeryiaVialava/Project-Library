package resources;

import java.time.LocalDate;
import interfejses.Scientific;

public class ScientificJournal extends Journal implements Scientific {
    private final String domain;

    public ScientificJournal(String title, String publisher, int resourceId, LocalDate publishDate, String domain) {
        super(title, publisher, resourceId, publishDate);
        this.domain = domain;
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public boolean isTheSameDomain(Scientific other) {
        return this.domain.equals(other.getDomain());
    }
}