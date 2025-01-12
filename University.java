package twentyfour.fall.oop.group2.final_java_project;

import java.io.Serializable;

public class University implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private String name;
    private String country;
    private int ranking;
    private String faculties;
    private int lorRequired;
    private int sopRequired;
    private boolean researchProposalRequired;
    private double minimumCgpa;
    private double minimumIelts;
    private double minimumToefl;
    private int minimumGreOrGmat;
    private int minimumEducationYears;

    public University(String name, String country, int ranking, String faculties, int lorRequired,
                      int sopRequired, boolean researchProposalRequired, double minimumCgpa,
                      double minimumIelts, double minimumToefl, int minimumGreOrGmat,
                      int minimumEducationYears) {
        this.name = name;
        this.country = country;
        this.ranking = ranking;
        this.faculties = faculties;
        this.lorRequired = lorRequired;
        this.sopRequired = sopRequired;
        this.researchProposalRequired = researchProposalRequired;
        this.minimumCgpa = minimumCgpa;
        this.minimumIelts = minimumIelts;
        this.minimumToefl = minimumToefl;
        this.minimumGreOrGmat = minimumGreOrGmat;
        this.minimumEducationYears = minimumEducationYears;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getFaculties() {
        return faculties;
    }

    public void setFaculties(String faculties) {
        this.faculties = faculties;
    }

    public int getLorRequired() {
        return lorRequired;
    }

    public void setLorRequired(int lorRequired) {
        this.lorRequired = lorRequired;
    }

    public int getSopRequired() {
        return sopRequired;
    }

    public void setSopRequired(int sopRequired) {
        this.sopRequired = sopRequired;
    }

    public boolean isResearchProposalRequired() {
        return researchProposalRequired;
    }

    public void setResearchProposalRequired(boolean researchProposalRequired) {
        this.researchProposalRequired = researchProposalRequired;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public double getMinimumIelts() {
        return minimumIelts;
    }

    public void setMinimumIelts(double minimumIelts) {
        this.minimumIelts = minimumIelts;
    }

    public double getMinimumToefl() {
        return minimumToefl;
    }

    public void setMinimumToefl(double minimumToefl) {
        this.minimumToefl = minimumToefl;
    }

    public int getMinimumGreOrGmat() {
        return minimumGreOrGmat;
    }

    public void setMinimumGreOrGmat(int minimumGreOrGmat) {
        this.minimumGreOrGmat = minimumGreOrGmat;
    }

    public int getMinimumEducationYears() {
        return minimumEducationYears;
    }

    public void setMinimumEducationYears(int minimumEducationYears) {
        this.minimumEducationYears = minimumEducationYears;
    }
}
