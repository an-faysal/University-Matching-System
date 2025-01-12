# University-Matching-System
University Matching System

Overview

The University Matching System is a Java-based application designed to help students find universities that match their academic profiles and preferences. It also provides a platform for admins to manage student data and communicate with them effectively.

This project demonstrates the application of Object-Oriented Programming (OOP) principles like inheritance, encapsulation, and composition, along with data persistence using serialization.

Features

For Students:
Create and update academic profiles (e.g., CGPA, IELTS, preferred country).
Search for universities based on their profile.
Communicate directly with admins via a messaging system.
For Admins:
View all registered students and their profiles.
Send and receive messages to/from students.
System Design

The system uses a modular architecture with the following key components:

UniversityMatchingSystem: The main class managing user interaction and system flow.
User: Abstract class inherited by Admin and Student.
StudentProfile: Encapsulates details like CGPA, IELTS scores, and preferred countries.
University: Represents universities with requirements like minimum CGPA, IELTS, and GRE scores.
UniversityMatcher: Contains the logic to match student profiles with universities.
Database: Handles data persistence using serialization.
Getting Started

Follow these steps to set up and run the University Matching System on your local machine.

Prerequisites
Java Development Kit (JDK): Ensure you have Java 8 or above installed.
IDE or Text Editor: Recommended tools:
IntelliJ IDEA
Eclipse
VS Code
Git: To clone the repository.
Setup Instructions
Clone the Repository:
git clone https://github.com/<YourGitHubUsername>/university-matching-system.git
cd university-matching-system
Open the Project:
Import the project into your IDE as a Maven/Java Project.
Build the Project:
Ensure all dependencies are resolved.
Compile the code from the IDE or using the command:
javac -d bin src/**/*.java
Run the Project:
Navigate to the main class UniversityMatchingSystem and run the main() method.
Alternatively, use the command line:
java -cp bin twentyfour.fall.oop.group2.final_java_project.UniversityMatchingSystem
Project Structure

university-matching-system/
├── src/
│   ├── twentyfour/fall/oop/group2/final_java_project/
│   │   ├── Admin.java
│   │   ├── Database.java
│   │   ├── Message.java
│   │   ├── Student.java
│   │   ├── StudentProfile.java
│   │   ├── University.java
│   │   ├── UniversityMatcher.java
│   │   ├── UniversityMatchingSystem.java
│   │   ├── User.java
├── data/
│   ├── admins.ser
│   ├── students.ser
│   ├── universities.ser
│   ├── messages.ser
├── README.md
How to Use

Run the Application:
Launch the application and follow the on-screen menu options.
Choose between creating an account as a student or admin.
For Students:
Create or update your profile by entering academic details like CGPA, IELTS scores, and preferred country.
Use the "Search Universities" option to get a list of universities matching your profile.
Communicate with admins if you need assistance.
For Admins:
Log in to view all registered students and their profiles.
Send messages to specific students for guidance or feedback.
Core Functionalities

1. Matching Logic
Located in the UniversityMatcher class.
Matches students to universities based on:
Minimum CGPA, IELTS, TOEFL, and GRE/GMAT scores.
Publications and research proposal requirements.
Preferred country.
2. Data Persistence
Handled by the Database class.
Data is serialized into .ser files (admins.ser, students.ser, universities.ser), ensuring it is saved between program runs.
3. Encapsulation
Sensitive fields like cgpa in StudentProfile are private and accessed through getters and setters.
Ensures data integrity and validation.
Future Enhancements

Web-Based Interface: Transition to a web or mobile application.
Dynamic University Database: Integrate APIs to fetch live university data.
Advanced Matching: Use machine learning to improve recommendation accuracy.
Improved Security: Implement hashed passwords and multi-factor authentication.
Contributing

We welcome contributions to enhance the University Matching System! If you're interested:

Fork the repository.
Create a feature branch:
git checkout -b feature/your-feature-name
Commit your changes:
git commit -m "Add your feature description"
Push to your branch:
git push origin feature/your-feature-name
Create a Pull Request on GitHub.
License

This project is licensed under the MIT License. See the LICENSE file for more details.
