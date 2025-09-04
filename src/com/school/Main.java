
package com.school;
import java.util.ArrayList;
import java.util.List;
import com.school.Student;
import com.school.Teacher;
import com.school.Staff;
import com.school.AttendanceRecord;

public class Main {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Alice", "10th Grade");
        Student s2 = new Student("Bob", "11th Grade");

        // Create teacher
        Teacher t1 = new Teacher("Mr. Smith", "Mathematics");

        // Create staff
        Staff st1 = new Staff("Karen", "Librarian");

        // Display hierarchy details
        System.out.println("=== Person Hierarchy Demo ===");
        s1.displayDetails();
        System.out.println("-----------------------------");
        s2.displayDetails();
        System.out.println("-----------------------------");
        t1.displayDetails();
        System.out.println("-----------------------------");
        st1.displayDetails();

        // Attendance log (using Person.getId())
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create records using inherited getId()
        attendanceLog.add(new AttendanceRecord(s1.getId(), 101, "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getId(), 102, "Absent"));
        attendanceLog.add(new AttendanceRecord(s1.getId(), 102, "Late")); // Invalid

        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
