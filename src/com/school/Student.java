package com.school;

public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name + ", Roll No: " + rollNumber);
    }
}
