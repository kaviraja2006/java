
package com.school;
import java.util.ArrayList;
import java.util.List;
import com.school.Student;
import com.school.Teacher;
import com.school.Staff;
import com.school.AttendanceRecord;

public class Main {
    // Polymorphic display of school directory
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("=== School Directory ===");
        for (Person person : people) {
            person.displayDetails();
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Alice", "10th Grade");
        Student s2 = new Student("Bob", "11th Grade");

        // Create teacher
        Teacher t1 = new Teacher("Mr. Smith", "Mathematics");

        // Create staff
        Staff st1 = new Staff("Karen", "Librarian");

        // Create courses
        Course c1 = new Course(101, "Mathematics");
        Course c2 = new Course(102, "Physics");

        // Add all people to schoolPeople list
        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(t1);
        schoolPeople.add(st1);

        // Display school directory using polymorphism
        displaySchoolDirectory(schoolPeople);

        // Attendance log (using Student and Course objects)
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1, c1, "Present"));
        attendanceLog.add(new AttendanceRecord(s2, c2, "Absent"));
        attendanceLog.add(new AttendanceRecord(s1, c2, "Late")); // Invalid

        System.out.println("\n=== Attendance Log ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Prepare students list for saving (filter from schoolPeople)
        List<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                students.add((Student) p);
            }
        }
        // Example: Save students to file (pseudo-code, actual FileStorageService not shown)
        // FileStorageService.saveData(students, "students.txt");
    }
}
