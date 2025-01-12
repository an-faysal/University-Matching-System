package twentyfour.fall.oop.group2.final_java_project;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private StudentProfile profile;

    public Student(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, generateStudentId());
        this.profile = null; // Initially, the profile is null
    }

    private static String generateStudentId() {
        int randomNumber = (int) (Math.random() * 900) + 100; // Generates a number between 100 and 999
        return "ST" + randomNumber;
    }

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public void createOrUpdateProfile() {
        Scanner scanner = new Scanner(System.in);

        if (profile == null) {
            System.out.println("\n--- Create Profile ---");
        } else {
            System.out.println("\n--- Update Profile ---");
            System.out.println("Leave a field blank to keep the current value.");
        }

        System.out.print("Graduation Year (e.g., 2023): ");
        String graduationYearInput = scanner.nextLine();
        int graduationYear = (profile != null && graduationYearInput.isBlank())
                ? profile.getGraduationYear()
                : Integer.parseInt(graduationYearInput);

        System.out.print("University Name (e.g., Kyoto University): ");
        String universityName = scanner.nextLine();
        universityName = (profile != null && universityName.isBlank())
                ? profile.getUniversityName()
                : universityName;

        System.out.print("Major (e.g., Computer Science): ");
        String major = scanner.nextLine();
        major = (profile != null && major.isBlank())
                ? profile.getMajor()
                : major;

        System.out.print("CGPA (in percentage, e.g., 85.5, or 'no' if not available): ");
        String cgpaInput = scanner.nextLine();
        double cgpa = (profile != null && cgpaInput.isBlank())
                ? profile.getCgpa()
                : (cgpaInput.equalsIgnoreCase("no") ? 0.0 : Double.parseDouble(cgpaInput));

        System.out.print("IELTS Score (e.g., 7.5, or 'no' if not available): ");
        String ieltsInput = scanner.nextLine();
        double ielts = (profile != null && ieltsInput.isBlank())
                ? profile.getIelts()
                : (ieltsInput.equalsIgnoreCase("no") ? 0.0 : Double.parseDouble(ieltsInput));

        System.out.print("TOEFL Score (e.g., 110, or 'no' if not available): ");
        String toeflInput = scanner.nextLine();
        double toefl = (profile != null && toeflInput.isBlank())
                ? profile.getToefl()
                : (toeflInput.equalsIgnoreCase("no") ? 0.0 : Double.parseDouble(toeflInput));

        System.out.print("GRE/GMAT Score (e.g., 320, or 'no' if not available): ");
        String greOrGmatInput = scanner.nextLine();
        int greOrGmat = (profile != null && greOrGmatInput.isBlank())
                ? profile.getGreOrGmat()
                : (greOrGmatInput.equalsIgnoreCase("no") ? 0 : Integer.parseInt(greOrGmatInput));

        System.out.print("Number of Publications (e.g., 2, or 'no' if not available): ");
        String publicationsInput = scanner.nextLine();
        int publications = (profile != null && publicationsInput.isBlank())
                ? profile.getPublications()
                : (publicationsInput.equalsIgnoreCase("no") ? 0 : Integer.parseInt(publicationsInput));

        System.out.print("Do you have MOI? (Yes/No): ");
        String moiInput = scanner.nextLine();
        boolean hasMoi = (profile != null && moiInput.isBlank())
                ? profile.isHasMoi()
                : moiInput.equalsIgnoreCase("Yes");

        System.out.print("Preferred Country (e.g., Japan, UK, Australia): ");
        String preferredCountry = scanner.nextLine();
        preferredCountry = (profile != null && preferredCountry.isBlank())
                ? profile.getPreferredCountry()
                : preferredCountry;

        this.profile = new StudentProfile(graduationYear, universityName, major, cgpa, ielts, toefl, greOrGmat, publications, hasMoi, preferredCountry);

        System.out.println(profile == null ? "Profile created successfully!" : "Profile updated successfully!");
    }

    public void viewProfile() {
        if (profile == null) {
            System.out.println("No profile found. Please create your profile first.");
            return;
        }

        System.out.println("\n--- Student Profile ---");
        System.out.println("Graduation Year: " + profile.getGraduationYear());
        System.out.println("University Name: " + profile.getUniversityName());
        System.out.println("Major: " + profile.getMajor());
        System.out.println("CGPA (%): " + profile.getCgpa());
        System.out.println("IELTS Score: " + profile.getIelts());
        System.out.println("TOEFL Score: " + profile.getToefl());
        System.out.println("GRE/GMAT Score: " + profile.getGreOrGmat());
        System.out.println("Number of Publications: " + profile.getPublications());
        System.out.println("MOI (Medium of Instruction): " + (profile.isHasMoi() ? "Yes" : "No"));
        System.out.println("Preferred Country: " + profile.getPreferredCountry());
    }
}
