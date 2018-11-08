import java.util.HashMap;

public class Student {
    private String Name;
    private int studentID;

    HashMap<String, Course> registeredCourses = new HashMap<>();


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

    public HashMap<String, Course> getregisteredCourses() {

        return this.registeredCourses;
    }
}
