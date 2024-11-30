package testing;

import resources.*;
import users.*;

import exceptions.NoAvailableResourceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RentableTest {
    private User user;
    private PaperBook book1;
    @BeforeEach
    void setUp() {
        user = new Student("Jan", "Kowalski", 1, "Matematyki i Infromatyki", "matematyka");
        book1 = new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);
    }

    @Test
    public void testRentSuccessfully() {
        assertDoesNotThrow(() -> book1.rent(user), "Renting the book should not throw an exception");

        assertEquals(user, book1.getUser(), "The book should be rented to the correct user");

        assertNotNull(book1.getDueDate(), "The due date should be set after renting the book");
        assertEquals(LocalDate.now().plusMonths(1), book1.getDueDate(), "The due date for a student should be 1 month from now");
    }

    @Test
    public void testRentAlreadyRentedBook() {
        assertDoesNotThrow(() -> book1.rent(user), "Renting the book the first time should not throw an exception");

        NoAvailableResourceException exception = assertThrows(NoAvailableResourceException.class, () -> book1.rent(user),
                "Renting an already rented book should throw NoAvailableResourceException");

        assertEquals("PaperBook is already rented", exception.getMessage(), "The exception message should be correct");
    }
}
