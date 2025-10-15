import java.util.*;

public class GradeBook {
    private String lastName;
    private String firstName;
    private String middleName;
    private int course;
    private String group;
    private List<Session> sessions = new ArrayList<>();

    public GradeBook() {}

    public GradeBook(String lastName, String firstName, String middleName, int course, String group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.course = course;
        this.group = group;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public List<Session> getSessions() { return sessions; }
    public void setSessions(List<Session> sessions) { this.sessions = sessions; }

    public void addSession(int number, String subject, String type, int grade) {
        sessions.add(new Session(number, subject, type, grade));
    }

    public boolean isExcellentStudent() {
        for (Session s : sessions) {
            if ("exam".equals(s.getType()) && s.getGrade() < 9) return false;
            if ("coursework".equals(s.getType()) && s.getGrade() < 9) return false;
        }
        return true;
    }

    public static class Session {
        private int number;
        private String subject;
        private String type;
        private int grade;

        public Session() {}

        public Session(int number, String subject, String type, int grade) {
            this.number = number;
            this.subject = subject;
            this.type = type;
            this.grade = grade;
        }

        public int getNumber() { return number; }
        public void setNumber(int number) { this.number = number; }

        public String getSubject() { return subject; }
        public void setSubject(String subject) { this.subject = subject; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public int getGrade() { return grade; }
        public void setGrade(int grade) { this.grade = grade; }
    }
}
