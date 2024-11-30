package resources;

import interfejses.Scientific;

public class ScientificBook extends PaperBook implements Scientific {
    private final String domain;

    public ScientificBook(String title, String publisher, int resourceId, String author, int pages, String domain) {
        super(title, publisher, resourceId, author,pages);
        this.domain = domain;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Domain: " + domain);
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

