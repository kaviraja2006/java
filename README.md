
## Part 9: SOLID Service Layer – RegistrationService & AttendanceService Separation

## Part 10: Capacity Management & SOLID Principles Reflection

### Features Added
- Added capacity management to `Course` class:
  - New fields: `capacity` and `enrolledStudents`
  - Methods to track and manage enrollment
  - Enhanced `displayDetails()` to show capacity and current enrollment
  - Updated `toDataString()` to include capacity information
- Enhanced `RegistrationService`:
  - Added `enrollStudentInCourse` method
  - Enrollment validation against course capacity
- Updated `Main` class to demonstrate:
  - Course creation with capacity limits
  - Student enrollment process
  - Capacity limit enforcement

### SOLID Principles Application
1. **Single Responsibility Principle (SRP)**:
   - `RegistrationService`: Handles registration and enrollment
   - `AttendanceService`: Manages attendance records
   - `FileStorageService`: Handles data persistence
   - `Course`: Manages its own capacity and enrolled students

2. **Open/Closed Principle**:
   - Classes are open for extension (e.g., new entity types can implement `Storable`)
   - Core functionality is closed for modification

3. **Liskov Substitution Principle**:
   - `Student`, `Teacher`, and `Staff` can be used wherever `Person` is expected
   - All implementations of `Storable` provide consistent behavior

4. **Interface Segregation**:
   - `Storable` interface is focused and minimal
   - Classes only implement interfaces they need

5. **Dependency Inversion**:
   - Services depend on abstractions (interfaces)
   - High-level modules aren't dependent on details

- **Applied the Single Responsibility Principle (SRP):**
  - Introduced `RegistrationService.java` to manage registration, storage, and lookup of `Student`, `Teacher`, `Staff`, and `Course` entities.
  - `RegistrationService` handles all entity lists, provides registration and lookup methods, and saves data to files.
- **Refactored `Teacher.java` and `Staff.java`:**
  - Both now implement the `Storable` interface.
  - Added `toDataString()` methods for file persistence.
- **Refactored `AttendanceService.java`:**
  - Now depends on `RegistrationService` for student/course lookups by ID.
  - Removed internal lookup helpers; all lookups are delegated to `RegistrationService`.
  - Focuses solely on attendance record management.
- **Updated `Main.java`:**
  - Instantiates `FileStorageService`, `RegistrationService`, and `AttendanceService` with proper dependencies.
  - Uses `RegistrationService` for all entity creation and registration.
  - Calls `registrationService.saveAllRegistrations()` and `attendanceService.saveAttendanceData()` to persist data.
  - `displaySchoolDirectory` now uses `registrationService.getAllPeople()`.
- **Persistence:**
  - Data for students, teachers, staff, and courses is now saved to `students.txt`, `teachers.txt`, `staff.txt`, and `courses.txt` respectively.
  - Attendance records are saved to `attendance_log.txt`.

### How to Run

1. Navigate to the project root directory.
2. Compile all Java files:
   ```bash
   javac src/com/school/*.java
   ```
3. Run the application:
   ```bash
   java -cp src com.school.Main
   ```
4. Check for the following files to confirm persistence:
   - `students.txt`
   - `teachers.txt`
   - `staff.txt`
   - `courses.txt`
   - `attendance_log.txt`

---

**Submission Checklist:**
- [ ] Link to Pull Request.
- [ ] Screenshot of console output.
- [ ] Confirmation that `teachers.txt` and `staff.txt` are created/updated.
- [ ] Console output after the commit.
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

## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports
// ...existing code...
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance
- Created an `AttendanceService.java` class to encapsulate attendance logic and manage the list of `AttendanceRecord` objects.
- Implemented overloaded `markAttendance` methods in `AttendanceService`:
  - `markAttendance(Student student, Course course, String status)`
  - `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` (performs lookups)
- Implemented overloaded `displayAttendanceLog` methods in `AttendanceService`:
  - `displayAttendanceLog()` (shows all records)
  - `displayAttendanceLog(Student student)` (filters by student)
  - `displayAttendanceLog(Course course)` (filters by course)
- Utilized Java Streams for filtering records in the specific display methods.
- `AttendanceService` now uses `FileStorageService` to save its `attendanceLog`.
- Demonstrated the use of these overloaded methods in `Main.java`, showing how different method signatures allow for flexible ways to call the same conceptual operation.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `attendance_log.txt` for saved records.
Submission:

- Link to PR.
- Screenshot of the console output showing the results of overloaded calls. content of attendance_log.txt.
- Screenshot of console output after commit:

- Modified `AttendanceRecord` to hold `Student` and `Course` objects instead of just their IDs, enhancing its object-oriented nature and how records are displayed. The `toDataString()` method still uses IDs for simpler file storage.

- Created a `displaySchoolDirectory(List<Person> people)` method in `Main.java` to demonstrate polymorphism. This method iterates through a list of `Person` objects (containing `Student`, `Teacher`, `Staff` instances) and calls `person.displayDetails()`. The correct overridden method for each specific object type is executed at runtime.

- Populated a `List<Person>` in `main` and used it with `displaySchoolDirectory`.

- Updated `Main.java` to use `instanceof` and casting when preparing the list of students for saving, as `Person` itself does not implement `Storable`.

- Discussed how polymorphism allows for flexible and extensible code by treating different object types uniformly through a common interface or base class reference.


### How to Run

1. Navigate to the project root directory.

2. Compile: `javac src/com/school/*.java`

3. Run: `java -cp src com.school.Main`

Submission:

- Link to PR:
- Screenshot of the console output, clearly showing the “School Directory” and “Attendance Log”.
- Screenshot after pushing code to the repo:
