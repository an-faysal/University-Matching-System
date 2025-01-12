package twentyfour.fall.oop.group2.final_java_project;

import java.io.*;
import java.util.*;

public class Database {
    private Map<String, Admin> admins;
    private Map<String, Student> students;
    private List<University> universities;
    private List<Message> messages;

    private static final String DATA_DIRECTORY = "./data";
    private static final String ADMINS_FILE = DATA_DIRECTORY + "/admins.ser";
    private static final String STUDENTS_FILE = DATA_DIRECTORY + "/students.ser";
    private static final String UNIVERSITIES_FILE = DATA_DIRECTORY + "/universities.ser";
    private static final String MESSAGES_FILE = DATA_DIRECTORY + "/messages.ser";

    public Database() {
        ensureDataDirectoryExists();
        this.admins = new HashMap<>();
        this.students = new HashMap<>();
        this.universities = new ArrayList<>();
        this.messages = new ArrayList<>();
        loadData();
        if (universities.isEmpty()) {
            initializeUniversities();
        }
    }

    private void ensureDataDirectoryExists() {
        File dataDir = new File(DATA_DIRECTORY);
        if (!dataDir.exists()) {
            if (dataDir.mkdir()) {
                System.out.println("Data directory created: " + dataDir.getAbsolutePath());
            } else {
                System.out.println("Failed to create data directory. Check permissions.");
            }
        }
    }

    public void saveData() {
        saveToFile(ADMINS_FILE, admins);
        saveToFile(STUDENTS_FILE, students);
        saveToFile(UNIVERSITIES_FILE, universities);
        saveToFile(MESSAGES_FILE, messages);
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        this.admins = (Map<String, Admin>) loadFromFile(ADMINS_FILE, new HashMap<>());
        this.students = (Map<String, Student>) loadFromFile(STUDENTS_FILE, new HashMap<>());
        this.universities = (List<University>) loadFromFile(UNIVERSITIES_FILE, new ArrayList<>());
        this.messages = (List<Message>) loadFromFile(MESSAGES_FILE, new ArrayList<>());
    }

    private void saveToFile(String fileName, Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + fileName);
            e.printStackTrace();
        }
    }

    private Object loadFromFile(String fileName, Object defaultValue) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found or error loading data from: " + fileName);
            return defaultValue;
        }
    }

    public void initializeUniversities() {
        universities.add(new University("The University of Tokyo", "Japan", 1, "Engineering, Science, Business", 2, 1, true, 75.0, 7.0, 100, 0, 16));
        universities.add(new University("Osaka University", "Japan", 6, "Engineering, Business, Arts", 2, 1, true, 70.0, 6.5, 85, 0, 16));
        universities.add(new University("Tokyo Institute of Technology", "Japan", 7, "Engineering, Science", 2, 1, true, 72.0, 6.5, 90, 0, 16));
        universities.add(new University("Kobe University", "Japan", 8, "Business, Engineering", 2, 1, false, 68.0, 6.0, 79, 0, 16));
        universities.add(new University("Hiroshima University", "Japan", 9, "Science, Education", 1, 1, false, 65.0, 6.0, 80, 0, 16));
        universities.add(new University("Kyushu University", "Japan", 10, "Engineering, Science, Business", 2, 1, true, 70.0, 6.5, 85, 0, 16));

        universities.add(new University("University of New South Wales", "Australia", 6, "Engineering, Business, Arts", 2, 1, true, 65.0, 6.5, 80, 0, 16));
        universities.add(new University("University of Western Australia", "Australia", 7, "Science, Business, Medicine", 2, 1, false, 65.0, 6.5, 79, 0, 16));
        universities.add(new University("University of Adelaide", "Australia", 8, "Engineering, Arts, Business", 2, 1, true, 65.0, 6.5, 82, 0, 16));
        universities.add(new University("Curtin University", "Australia", 9, "Engineering, IT", 1, 1, false, 60.0, 6.0, 75, 0, 16));
        universities.add(new University("Macquarie University", "Australia", 10, "Business, Arts", 2, 1, false, 60.0, 6.5, 79, 0, 16));

        universities.add(new University("University of Edinburgh", "UK", 6, "Science, Arts", 2, 1, true, 68.0, 7.0, 100, 0, 16));
        universities.add(new University("University of Manchester", "UK", 7, "Engineering, Business", 2, 1, false, 65.0, 6.5, 92, 0, 16));
        universities.add(new University("King's College London", "UK", 8, "Medicine, Science", 2, 1, true, 67.0, 7.0, 95, 0, 16));
        universities.add(new University("University of Warwick", "UK", 9, "Business, Economics", 2, 1, false, 65.0, 6.5, 90, 0, 16));
        universities.add(new University("University of Glasgow", "UK", 10, "Arts, Business", 2, 1, false, 65.0, 6.5, 88, 0, 16));
        universities.add(new University("The University of Tokyo", "Japan", 1, "Engineering, Science, Business", 2, 1, true, 75.0, 7.0, 100, 0, 16));
        universities.add(new University("Kyoto University", "Japan", 2, "Engineering, Science, Business", 2, 1, true, 75.0, 6.5, 100, 0, 16));
        universities.add(new University("Nagoya University", "Japan", 3, "Engineering, Science, Business", 2, 1, true, 70.0, 6.5, 90, 0, 16));
        universities.add(new University("Hokkaido University", "Japan", 4, "Engineering, Science", 1, 1, false, 70.0, 6.5, 80, 0, 16));
        universities.add(new University("Tohoku University", "Japan", 5, "Engineering, Business", 2, 1, false, 72.0, 6.5, 85, 0, 16));
        universities.add(new University("University of Melbourne", "Australia", 1, "Engineering, Business, Medicine", 2, 1, true, 65.0, 6.5, 79, 0, 16));
        universities.add(new University("University of Sydney", "Australia", 2, "Law, Business, Medicine", 2, 1, true, 65.0, 6.5, 85, 0, 16));
        universities.add(new University("Australian National University", "Australia", 3, "Engineering, Arts, Business", 2, 1, false, 65.0, 6.5, 80, 0, 16));
        universities.add(new University("University of Queensland", "Australia", 4, "Engineering, Science", 2, 1, false, 65.0, 6.5, 87, 0, 16));
        universities.add(new University("Monash University", "Australia", 5, "Business, Science", 2, 1, false, 65.0, 6.5, 79, 0, 16));
        universities.add(new University("University of Cambridge", "UK", 1, "Engineering, Science, Arts", 3, 1, true, 70.0, 7.0, 100, 0, 16));
        universities.add(new University("University of Oxford", "UK", 2, "Science, Arts", 3, 1, true, 70.0, 7.5, 110, 0, 16));
        universities.add(new University("Imperial College London", "UK", 3, "Engineering, Medicine", 2, 1, true, 65.0, 7.0, 92, 0, 16));
        universities.add(new University("London School of Economics", "UK", 4, "Economics, Law", 2, 1, false, 65.0, 7.0, 100, 0, 16));
        universities.add(new University("University College London", "UK", 5, "Arts, Business", 2, 1, true, 65.0, 6.5, 92, 0, 16));
        saveData(); // Save universities to file
    }

    public List<University> getAllUniversities() {
        return universities;
    }

    public void addAdmin(Admin admin) {
        admins.put(admin.getId(), admin);
        saveData();
    }

    public Collection<Admin> getAllAdmins() {
        return admins.values();
    }

    // Add this method to return all students
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        saveData();
    }

    public Student getStudentById(String studentId) {
        return students.get(studentId);
    }

    public void addMessage(Message message) {
        messages.add(message);
        saveData();
    }

    public List<Message> getMessagesForUser(String userId) {
        List<Message> userMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getSenderId().equals(userId) || message.getReceiverId().equals(userId)) {
                userMessages.add(message);
            }
        }
        return userMessages;
    }
}
