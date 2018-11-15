import java.util.HashMap;

public class Student extends Person implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private HashMap <String, RegisteredCourse> registeredCourses;

    public Student(String name, int studentID) {
        super(studentID, name);
        this.registeredCourses = new HashMap<>();
    }

    public void setRegisteredCourses(HashMap<String, RegisteredCourse> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public HashMap<String, RegisteredCourse> getregisteredCourses() {

        return this.registeredCourses;
    }
}
