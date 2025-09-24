
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

        // Prepare students and courses lists
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);
        List<Course> allCourses = new ArrayList<>();
        allCourses.add(c1);
        allCourses.add(c2);

        // Display school directory using polymorphism
        displaySchoolDirectory(schoolPeople);

        // Create services
        FileStorageService fileStorageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(fileStorageService);

        // Mark attendance using overloaded methods
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c2, "Absent");
        attendanceService.markAttendance(1, 102, "Present", allStudents, allCourses); // Alice for Physics
        attendanceService.markAttendance(2, 101, "Absent", allStudents, allCourses); // Bob for Mathematics

        // Display all attendance records
        attendanceService.displayAttendanceLog();

        // Display attendance for a specific student
        attendanceService.displayAttendanceLog(s1);

        // Display attendance for a specific course
        attendanceService.displayAttendanceLog(c1);

        // Save attendance data
        attendanceService.saveAttendanceData();
    }
}
