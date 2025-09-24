package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageService {
    public <T> void saveData(List<T> dataList, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (T item : dataList) {
                if (item instanceof AttendanceRecord) {
                    writer.write(((AttendanceRecord) item).toDataString() + "\n");
                } else if (item instanceof Student) {
                    Student s = (Student) item;
                    writer.write(s.getId() + "," + s.getName() + "," + s.getGradeLevel() + "\n");
                } // Add more types as needed
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + filename);
        }
    }
}
