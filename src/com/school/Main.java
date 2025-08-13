package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");

        // Create courses
        Course c1 = new Course(101, "Math");
        Course c2 = new Course(102, "Science");

        // Attendance log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create records
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c2.getCourseId(), "Late")); // Invalid

        // Display records
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
