package com.school;

public class AttendanceRecord {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status provided for studentId " + student.getId());
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")"
                + ", Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ")"
                + ", Status: " + status);
    }

    // For file saving: studentId, courseId, status
    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
