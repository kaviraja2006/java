# Part 2 – Student & Course Management (Java)

## 📌 Overview
In this part of the assignment, we extended the project to handle **arrays of objects** in Java.  
We created two new classes (`Student` and `Course`) inside the `com.school` package, and modified `Main.java` to work with arrays of these objects.

---

## ✅ What was done
- ✔ **Created `Student.java`** with name and rollNumber fields, constructor, getters, and a `displayInfo()` method.
- ✔ **Created `Course.java`** with courseName and courseCode fields, constructor, getters, and a `displayInfo()` method.
- ✔ **Modified `Main.java`** to:
  - Create an array of `Student` objects.
  - Create an array of `Course` objects.
  - Loop through both arrays and print details using their `displayInfo()` methods.

---

## 📂 Folder Structure
src/
└── com/
└── school/
├── Main.java
├── Student.java
└── Course.java


---

## ▶️ How to Compile and Run
**Compile all classes:**
```bash
cd src/com/school
javac *.java




## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run
1. Navigate to the project root directory.
2. Compile:
   ```bash
   javac src/com/school/*.java


## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public getters.
- Introduced a new `AttendanceRecord` class with private fields, a constructor, and getters to store attendance data.
- Implemented validation in `AttendanceRecord` to only allow "Present" or "Absent" statuses.
- Demonstrated storing attendance in an ArrayList and displaying the results.

### How to Run
```bash
javac src/com/school/*.java
java -cp src com.school.Main


## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy
- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.
