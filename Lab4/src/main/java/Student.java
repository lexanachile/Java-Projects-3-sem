public class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private int course;
    private String group;
    private GradeBook gradeBook;

    public Student() {}

    public Student(String firstName, String lastName, String middleName, int course, String group, GradeBook gradeBook) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.course = course;
        this.group = group;
        this.gradeBook = gradeBook;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public GradeBook getGradeBook() { return gradeBook; }
    public void setGradeBook(GradeBook gradeBook) { this.gradeBook = gradeBook; }
}
