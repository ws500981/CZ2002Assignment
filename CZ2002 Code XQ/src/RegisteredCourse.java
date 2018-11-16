import java.util.ArrayList;

/**
 * Entity class for registered course
 * Registered course is different from plain course as this included different variables and methods from course class
 * Only pertaining to the course a student registers for
 */
public class RegisteredCourse implements java.io.Serializable{

    /**
     * Name of registered course by student
     */
    private String courseName;

    /**
     * ID of registered course by student
     */
    private String courseId;

    /**
     * ArrayList of components in registered course
     */
    private ArrayList<Component> components;

    /**
     * Name of tutorial group
     */
    private String tutGroup;

    /**
     * Name of lab group
     */
    private String labGroup;

    /**
     * Constructor to assign values
     * @param courseName
     * @param courseId
     * @param components
     * @param tutGroup
     * @param labGroup
     */
    public RegisteredCourse(String courseName, String courseId, ArrayList<Component> components, String tutGroup, String labGroup) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.components = components;
        this.tutGroup = tutGroup;
        this.labGroup = labGroup;
    }

    /**
     * Method to calculate total results attained by student in this course, taking into account weightage of each component
     * @return
     */
    public int calculateResults() {
        int sum = 0;
        for(Component c : components) {
            sum += (c.getMarks())*(c.getWeight()/100);
        }
        return sum;
    }

    /**
     * Getter for name
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter for name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter for ID
     * @return
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Setter for ID
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Getter for components
     * @return
     */
    public ArrayList<Component> getComponents() {
        return components;
    }

    /**
     * Setter for components
     * @param components
     */
    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

  }
