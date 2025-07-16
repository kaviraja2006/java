package com.school;

public class Main {
    public static void main(String[] args) {
        // create array of students
        Student[] students = new Student[3];
        students[0] = new Student("Alice", 101);
        students[1] = new Student("Bob", 102);
        students[2] = new Student("Charlie", 103);

        // create array of courses
        Course[] courses = new Course[2];
        courses[0] = new Course("Mathematics", 201);
        courses[1] = new Course("Science", 202);

        // display students
        System.out.println("=== Students ===");
        for (Student s : students) {
            s.displayInfo();
        }

        // display courses
        System.out.println("\n=== Courses ===");
        for (Course c : courses) {
            c.displayInfo();
        }
    }
}
