package users;

public class Student extends User {
    private String course;

    public Student(String name, String surname, int idUser, String department, String course) {
        super(name, surname, idUser, department);
        this.course = course;
    }
}

