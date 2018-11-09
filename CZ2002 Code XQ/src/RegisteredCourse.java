import java.util.ArrayList;

public class RegisteredCourse implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String courseName;
    private String courseId;
    private ArrayList<Component> components;
    private String tutGroup;
    private String labGroup;

    public RegisteredCourse(String courseName, String courseId, ArrayList<Component> components, String tutGroup, String labGroup) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.components = components;
        this.tutGroup = tutGroup;
        this.labGroup = labGroup;
    }

    public int calculateResults() {
        int sum = 0;
        for(Component c : components) {
            sum += (c.getMarks())*(c.getWeight()/100);
        }
        return sum;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

  }
