

package com.school;

public class Main {
    // Polymorphic display of school directory
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("=== School Directory ===");
        for (Person person : regService.getAllPeople()) {
            person.displayDetails();
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        // Create services
        FileStorageService fileStorageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(fileStorageService);
        AttendanceService attendanceService = new AttendanceService(fileStorageService, registrationService);

        // Register students
        Student s1 = new Student("Alice", "10th Grade");
        Student s2 = new Student("Bob", "11th Grade");
        registrationService.registerStudent(s1);
        registrationService.registerStudent(s2);

        // Register teacher
        Teacher t1 = new Teacher("Mr. Smith", "Mathematics");
        registrationService.registerTeacher(t1);

        // Register staff
        Staff st1 = new Staff("Karen", "Librarian");
        registrationService.registerStaff(st1);

        // Create courses with capacity
        Course c1 = new Course(101, "Mathematics", 2);
        Course c2 = new Course(102, "Physics", 1);
        registrationService.createCourse(c1);
        registrationService.createCourse(c2);

        // Enroll students in courses
        System.out.println("\n=== Course Enrollment ===");
        registrationService.enrollStudentInCourse(s1, c1); // Alice in Math
        registrationService.enrollStudentInCourse(s2, c1); // Bob in Math
        registrationService.enrollStudentInCourse(s1, c2); // Alice in Physics
        registrationService.enrollStudentInCourse(s2, c2); // Bob in Physics (should fail, capacity=1)

        // Display course details
        System.out.println("\n=== Course Details ===");
        c1.displayDetails();
        System.out.println("-----------------------------");
        c2.displayDetails();

        // Display school directory using RegistrationService
        displaySchoolDirectory(registrationService);

        // Mark attendance using new AttendanceService
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c2, "Absent");
        attendanceService.markAttendance(s1.getId(), c2.getCourseId(), "Present"); // Alice for Physics
        attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Absent"); // Bob for Mathematics

        // Display all attendance records
        attendanceService.displayAttendanceLog();

        // Display attendance for a specific student
        attendanceService.displayAttendanceLog(s1);

        // Display attendance for a specific course
        attendanceService.displayAttendanceLog(c1);

        // Save all registrations and attendance data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
