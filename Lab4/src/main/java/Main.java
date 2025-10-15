import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StudentRegistry registry = new StudentRegistry();
        registry.loadFromJsonFile("students.json");

        for (Student student : registry.getStudents()) {
            GradeBook gb = student.getGradeBook();
            System.out.println(gb.isExcellentStudent() ? "Excellent student" : "Not excellent");
        }

        registry.saveToJsonFile("students-out.json");
    }
}
