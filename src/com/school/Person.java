package com.school;

public class Person {
    private static int nextIdCounter = 1; // Auto-increment counter
    protected int id;
    protected String name;

    public Person(String name) {
        this.id = nextIdCounter++;//a.id=1// b.id
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}
//Person a= new Person(1,33);
//Person b= new Person(1,33);
//a.id;
//a.nextIdCounter;
//Person.nextIdCounter;--> belongs to class;
//Person.id ; --> wrong , error;