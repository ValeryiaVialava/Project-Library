package testing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.*;
import users.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;



public class UserTest {
    private User user;
    private Resource[] resources;
    @BeforeEach
    void setUp() {
        user =new Student("Jan","Kowalski",1,"Matematyki i Infromatyki","matematyka");
        resources = new Resource[]{
                new PaperBook("Pan Tadeusz", "GREG", 1, "Adam Mickiewicz", 334),
                new Journal("Książki","Wyborcza",13, LocalDate.of(2024,9,1))
        };
        PaperBook b1=(PaperBook)resources[0];
        Journal b2=(Journal)resources[1];
        b1.rent(user);
        b2.rent(user);

        b1.setDueDate(LocalDate.now().minusDays(5));
        b2.setDueDate(LocalDate.now().minusDays(3));
    }

    @Test
    public void testNumberOfResources(){
        int count = user.numberOfResources(resources);
        assertEquals(2, count, "User should have 2 rented resources.");
    }

    @Test
    public void testGetFee(){
        int totalFee = user.getFee(resources);
        assertEquals(8, totalFee, "Total fee should be 8 (5 + 3 days overdue).");
    }

}
