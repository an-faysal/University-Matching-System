package twentyfour.fall.oop.group2.final_java_project;

import java.util.List;
import java.util.Scanner;

public class UniversityMatchingSystem {
    // Fields
    private Database database;
    private UniversityMatcher matcher;

    // Constructor
    public UniversityMatchingSystem() {
        this.database = new Database();
        this.matcher = new UniversityMatcher(database);
        database.initializeUniversities(); // Preload universities
    }

    // Main method
    public static void main(String[] args) {
        UniversityMatchingSystem system = new UniversityMatchingSystem();
        system.runSystem();
    }

    // Run the system
    public void runSystem() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== University Matching System ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("===============================================");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the University Matching System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Create an account
    private void createAccount(Scanner scanner) {
        System.out.println("\n========== Create Account ==========");
        System.out.print("Are you an Admin or a Student? (A/S): ");
        String userType = scanner.nextLine().trim().toUpperCase();

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password (min 8 characters, include uppercase, lowercase, digit, special char): ");
        String password = scanner.nextLine();

        if (userType.equals("A")) {
            Admin admin = new Admin(firstName, lastName, email, password);
            database.addAdmin(admin);
            System.out.println("Admin account created successfully! Your ID: " + admin.getId());
        } else if (userType.equals("S")) {
            Student student = new Student(firstName, lastName, email, password);
            database.addStudent(student);
            System.out.println("Student account created successfully! Your ID: " + student.getId());
        } else {
            System.out.println("Invalid user type. Please choose either Admin (A) or Student (S).");
        }
    }

    // Login to the system
    private void login(Scanner scanner) {
        System.out.println("\n========== Login ==========");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = findUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            if (user instanceof Admin) {
                adminDashboard((Admin) user, scanner);
            } else if (user instanceof Student) {
                studentDashboard((Student) user, scanner);
            }
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }

    // Find user by email
    private User findUserByEmail(String email) {
        for (Admin admin : database.getAllAdmins()) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return admin;
            }
        }
        for (Student student : database.getAllStudents()) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    // Admin dashboard
    private void adminDashboard(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("\n========== Admin Dashboard ==========");
            System.out.println("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "!");
            System.out.println("1. View All Students");
            System.out.println("2. Send Message to Student");
            System.out.println("3. View Messages");
            System.out.println("4. Logout");
            System.out.println("=======================================");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllStudents();
                    break;
                case 2:
                    sendMessage(admin, scanner);
                    break;
                case 3:
                    viewMessages(admin);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // View all students
    private void viewAllStudents() {
        System.out.println("\n========== All Students ==========");
        for (Student student : database.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstName() + " " + student.getLastName());
        }
    }

    // Student dashboard
    private void studentDashboard(Student student, Scanner scanner) {
        while (true) {
            System.out.println("\n========== Student Dashboard ==========");
            System.out.println("Welcome, " + student.getFirstName() + " " + student.getLastName() + "!");
            System.out.println("1. Create/Update Profile");
            System.out.println("2. View Profile");
            System.out.println("3. Search Universities");
            System.out.println("4. Send Message to Admin");
            System.out.println("5. View Messages");
            System.out.println("6. Logout");
            System.out.println("=======================================");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    student.createOrUpdateProfile();
                    break;
                case 2:
                    student.viewProfile();
                    break;
                case 3:
                    searchUniversities(student);
                    break;
                case 4:
                    sendMessage(student, scanner);
                    break;
                case 5:
                    viewMessages(student);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void searchUniversities(Student student) {
        UniversityMatcher matcher = new UniversityMatcher(database);
        List<University> matchingUniversities = matcher.findMatchingUniversities(student);

        if (matchingUniversities.isEmpty()) {
            System.out.println("\nNo matching universities found for your profile.");
        } else {
            System.out.println("\n--- Matching Universities ---");
            for (University university : matchingUniversities) {
                System.out.println("Name: " + university.getName());
                System.out.println("Country: " + university.getCountry());
                System.out.println("Ranking: " + university.getRanking());
                System.out.println("Minimum CGPA: " + university.getMinimumCgpa());
                System.out.println("Minimum IELTS: " + university.getMinimumIelts());
                System.out.println("Minimum TOEFL: " + university.getMinimumToefl());
                System.out.println("Minimum GRE/GMAT: " + university.getMinimumGreOrGmat());
                System.out.println("Research Proposal Required: " + (university.isResearchProposalRequired() ? "Yes" : "No"));
                System.out.println("Number of LORs Required: " + university.getLorRequired());
                System.out.println("Number of SOPs Required: " + university.getSopRequired());
                System.out.println("------------------------------------------------");
            }
        }
    }


    // Send message
    private void sendMessage(User sender, Scanner scanner) {
        System.out.println("\n========== Send Message ==========");
        System.out.print("Enter Receiver ID: ");
        String receiverId = scanner.nextLine();

        System.out.print("Enter Message: ");
        String content = scanner.nextLine();

        Message message = new Message(sender.getId(), receiverId, content, java.time.LocalDateTime.now());
        database.addMessage(message);
        System.out.println("Message sent successfully!");
    }

    // View messages
    private void viewMessages(User user) {
        System.out.println("\n========== Your Messages ==========");
        List<Message> messages = database.getMessagesForUser(user.getId());
        if (messages.isEmpty()) {
            System.out.println("No messages found.");
        } else {
            for (Message message : messages) {
                System.out.println(message.displayMessage());
            }
        }
    }
}
