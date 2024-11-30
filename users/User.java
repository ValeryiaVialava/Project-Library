package users;

import interfejses.Rentable;
import resources.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {
    protected String name;
    protected String surname;
    protected int idUser;
    protected String department;

    public User(String name, String surname, int idUser, String department) {
        this.name = name;
        this.surname = surname;
        this.idUser = idUser;
        this.department = department;
    }

    public String getName (){
        return name;
    }

    public String  getSurname (){
        return surname;
    }

    public int getFee(Resource[] resources) {
        int totalFee = 0;

        for (Resource resource : resources) {
            if (resource != null && resource.getUser() == this) {
                long overdueDays = resource.getDueDate().until(LocalDate.now(), ChronoUnit.DAYS);
                if (overdueDays > 0) {
                    totalFee += (int) (overdueDays);
                }
            }
        }
        return totalFee;
    }

    public int numberOfResources(Resource[] resources) {
        int count = 0;
        for (Resource resource : resources) {
            if (resource instanceof Rentable && ((Rentable) resource).getUser() == this) {
                count++;
            }
        }
        return count;
    }

}

