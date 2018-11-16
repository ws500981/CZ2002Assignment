import java.util.HashMap;

/**
 * Entity class for Student, child of person class
 */
public class Student extends Person implements java.io.Serializable{

    /**
     * HashMap of courses the student registers for, with keys of name of courses and values of registeredCourses objects
     */
    private HashMap <String, RegisteredCourse> registeredCourses;

    /**
     * Constructor to initalise and assign values
     * @param name
     * @param studentID
     */
    public Student(String name, int studentID) {
        super(studentID, name);
        this.registeredCourses = new HashMap<>();
    }

    /**
     * Setter for registeredCourses
     * @param registeredCourses
     */
    public void setRegisteredCourses(HashMap<String, RegisteredCourse> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    /**
     * Getter for registeredCourses
     * @return
     */
    public HashMap<String, RegisteredCourse> getregisteredCourses() {
        return this.registeredCourses;
    }
}
