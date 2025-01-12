package twentyfour.fall.oop.group2.final_java_project;

public class Admin extends User {
    private static final long serialVersionUID = 1L;

    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, generateAdminId());
    }

    private static String generateAdminId() {
        int randomNumber = (int) (Math.random() * 900) + 100; // Generates a number between 100 and 999
        return "AD" + randomNumber;
    }
}
