package testing;

import interfejses.Scientific;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class IsTheSameTest {
    private Resource[] resources;

    @BeforeEach
    void setUp() {
        resources = new Resource[]{
                new PaperBook("Pan Tadeusz", "GREG", 1, "Adam Mickiewicz", 334),
                new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer", 5, "Jarosław Warylewski", 680, "nieprawo"),
                new PaperBook("Pan Tadeusz", "GREG", 2, "Adam Mickiewicz", 334),
                new ScientificJournal("Państwo i Prawo","Wolters Kluwer",18, LocalDate.of(2024,8,1),"prawo"),
                new ScientificJournal("Państwo i Prawo","Wolters Kluwer",18,LocalDate.of(2024,8,1),"prawo")
        };
    }

    @Test
    public void testIsTheSameBook() {
        assertFalse(areBooksTheSame(resources[0], resources[1]), "Books with different titles/authors should not be the same.");
        assertTrue(areBooksTheSame(resources[0], resources[2]), "Books with the same title/author should be the same.");
    }

    private boolean areBooksTheSame(Resource r1, Resource r2) {
        if (r1 instanceof Book book1 && r2 instanceof Book book2) {
            return book1.getTitle().equals(book2.getTitle()) && book1.getAuthor().equals(book2.getAuthor());
        }
        return false;
    }

    @Test
    public void testIsTheSameDomain() {
        assertFalse(areDomainsTheSame(resources[1], resources[3]), "ScientificBook and ScientificJournal with different domains should not be the same.");
        assertTrue(areDomainsTheSame(resources[3], resources[4]), "ScientificJournal resources with the same domain should be the same.");
    }

    private boolean areDomainsTheSame(Resource r1, Resource r2) {
        if (r1 instanceof Scientific s1 && r2 instanceof Scientific s2) {
            return s1.getDomain().equals(s2.getDomain());
        }
        return false;
    }
}
