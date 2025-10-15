import java.util.*;
import java.io.*;

import com.fasterxml.jackson.databind.*;

public class StudentRegistry {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void loadFromJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student[] loaded = mapper.readValue(new File(filename), Student[].class);
        students.addAll(Arrays.asList(loaded));
    }

    public void saveToJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), students);
    }
}
