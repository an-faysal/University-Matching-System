package twentyfour.fall.oop.group2.final_java_project;

import java.util.ArrayList;
import java.util.List;

public class UniversityMatcher {
    private Database database;

    public UniversityMatcher(Database database) {
        this.database = database;
    }

    /**
     * Finds matching universities based on the student's profile.
     *
     * @param student The student whose profile is used for matching.
     * @return A list of universities that match the student's profile.
     */
    public List<University> findMatchingUniversities(Student student) {
        List<University> matchingUniversities = new ArrayList<>();
        StudentProfile profile = student.getProfile();

        if (profile == null) {
            System.out.println("Student profile is not set. Please create a profile first.");
            return matchingUniversities;
        }

        for (University university : database.getAllUniversities()) {
            if (isEligible(profile, university)) {
                matchingUniversities.add(university);
            }
        }

        return matchingUniversities;
    }

    /**
     * Checks if a student profile meets the university's requirements.
     *
     * @param profile   The student's profile.
     * @param university The university to check eligibility for.
     * @return True if the student is eligible for the university, false otherwise.
     */
    private boolean isEligible(StudentProfile profile, University university) {
        if (!profile.getPreferredCountry().equalsIgnoreCase(university.getCountry())) {
            return false; // Country mismatch
        }
        if (profile.getCgpa() < university.getMinimumCgpa()) {
            return false; // CGPA requirement not met
        }
        if (profile.getIelts() < university.getMinimumIelts()) {
            return false; // IELTS requirement not met
        }
        if (profile.getToefl() < university.getMinimumToefl()) {
            return false; // TOEFL requirement not met
        }
        if (profile.getGreOrGmat() < university.getMinimumGreOrGmat()) {
            return false; // GRE/GMAT requirement not met
        }
        if (profile.getPublications() < 1 && university.isResearchProposalRequired()) {
            return false; // Research proposal required but no publications
        }

        return true; // All requirements met
    }
}
