import java.util.HashMap;

public class Student implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String Name;
    private int studentID;
    //course id against registered course
    private HashMap <String, RegisteredCourse> registeredCourses;

    public Student(String name, int studentID) {
        Name = name;
        this.studentID = studentID;
        this.registeredCourses = new HashMap<>();
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

    public HashMap<String, RegisteredCourse> getregisteredCourses() {

        return this.registeredCourses;
    }
}
