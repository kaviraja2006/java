package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // Overloaded markAttendance: direct objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Overloaded markAttendance: by IDs
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Error: Student or Course not found for attendance record.");
        }
    }

    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // Overloaded displayAttendanceLog: all records
    public void displayAttendanceLog() {
        System.out.println("=== All Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    // Overloaded: by student
    public void displayAttendanceLog(Student student) {
        System.out.println("=== Attendance for Student: " + student.getName() + " ===");
        attendanceLog.stream()
            .filter(r -> r.getStudent().getId() == student.getId())
            .forEach(AttendanceRecord::displayRecord);
    }

    // Overloaded: by course
    public void displayAttendanceLog(Course course) {
        System.out.println("=== Attendance for Course: " + course.getCourseName() + " ===");
        attendanceLog.stream()
            .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
            .forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
