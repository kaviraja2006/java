
package com.school;

public class Teacher extends Person implements Storable {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher, Subject Taught: " + subjectTaught);
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + subjectTaught;
    }
}
