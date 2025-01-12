package twentyfour.fall.oop.group2.final_java_project;

import java.io.Serializable;

public class StudentProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    private int graduationYear;
    private String universityName;
    private String major;
    private double cgpa;
    private double ielts;
    private double toefl;
    private int greOrGmat;
    private int publications;
    private boolean hasMoi;
    private String preferredCountry;

    public StudentProfile(int graduationYear, String universityName, String major, double cgpa, double ielts, double toefl,
                          int greOrGmat, int publications, boolean hasMoi, String preferredCountry) {
        this.graduationYear = graduationYear;
        this.universityName = universityName;
        this.major = major;
        this.cgpa = cgpa;
        this.ielts = ielts;
        this.toefl = toefl;
        this.greOrGmat = greOrGmat;
        this.publications = publications;
        this.hasMoi = hasMoi;
        this.preferredCountry = preferredCountry;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getIelts() {
        return ielts;
    }

    public void setIelts(double ielts) {
        this.ielts = ielts;
    }

    public double getToefl() {
        return toefl;
    }

    public void setToefl(double toefl) {
        this.toefl = toefl;
    }

    public int getGreOrGmat() {
        return greOrGmat;
    }

    public void setGreOrGmat(int greOrGmat) {
        this.greOrGmat = greOrGmat;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public boolean isHasMoi() {
        return hasMoi;
    }

    public void setHasMoi(boolean hasMoi) {
        this.hasMoi = hasMoi;
    }

    public String getPreferredCountry() {
        return preferredCountry;
    }

    public void setPreferredCountry(String preferredCountry) {
        this.preferredCountry = preferredCountry;
    }
}
