import java.util.HashMap;

public class Student {
    private String Name;
    private int studentID;
    private HashMap <String, RegisteredCourse> registeredCourses;

    public HashMap<String, RegisteredCourse> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(HashMap<String, RegisteredCourse> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
