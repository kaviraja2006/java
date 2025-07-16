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