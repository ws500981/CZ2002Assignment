import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Entity class for courses
 */
public class Course implements java.io.Serializable{

    /**
     * Name of course
     */
    private String name;

    /**
     * Name of ID
     */
    private String courseID;

    /**
     * Name of professor in charge
     */
    private Professor profInCharge;

    /**
     * SortedMap of students registered in course, with keys of student ID and values of student objects
     */
    private SortedMap<Integer, Student> studentsList;

    /**
     * ArrayList of components
     */
    private ArrayList<Component> components;

    /**
     * Map of tutorial groups, with keys of name of tutorial groups and values of tutorial objects
     */
    private Map<String, Tutorial> tutGroups;

    /**
     * Map of lab groups, with keys of name of lab group and values of lab objects
     */
    private Map<String, Lab> labGroups;

    /**
     * Number of vacancies
     */
    private int vacancy;

    /**
     * Course size
     */
    private int originalVacancy;

    /**
     * Constructor to assign values to variables
     * @param name
     * @param courseID
     * @param profInCharge
     * @param vacancy
     */
    public Course(String name, String courseID, Professor profInCharge, int vacancy) {
        this.name = name;
        this.courseID = courseID;
        this.profInCharge = profInCharge;
        this.vacancy = vacancy;
        this.originalVacancy = vacancy;
        this.components = new ArrayList<>();
        this.studentsList = new TreeMap<>();
        this.tutGroups= new TreeMap<>();
        this.labGroups = new TreeMap<>();
    }

    /**
     * Overloaded constructor to assign values to variables
     * @param name
     * @param courseID
     * @param profInCharge
     * @param components
     * @param tutGroups
     * @param labGroups
     * @param vacancy
     */
    public Course(String name, String courseID, Professor profInCharge, ArrayList<Component> components, Map<String, Tutorial> tutGroups, Map<String, Lab> labGroups, int vacancy) {
        this.name = name;
        this.courseID = courseID;
        this.profInCharge = profInCharge;
        this.studentsList = new TreeMap<>();
        this.components = components;
        this.tutGroups = tutGroups;
        this.labGroups = labGroups;
        this.vacancy = vacancy;
        this.originalVacancy = vacancy;
    }

    /**
     * Getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for ID
     * @return
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Setter for ID
     * @param courseID
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * Getter for object of professor in charge
     * @return
     */
    public Professor getProfInCharge() {
        return profInCharge;
    }

    /**
     * Setter for professor in charge
     * @param profInCharge
     */
    public void setProfInCharge(Professor profInCharge) {
        this.profInCharge = profInCharge;
    }

    /**
     * Getter for list of students
     * @return
     */
    public SortedMap<Integer, Student> getStudentsList() {
        return studentsList;
    }

    /**
     * Setter for list of students
     * @param studentsList
     */
    public void setStudentsList(SortedMap<Integer, Student> studentsList) {
        this.studentsList = studentsList;
    }

    /**
     * Getter for list of components
     * @return
     */
    public ArrayList<Component> getComponents() {
        return components;
    }

    /**
     * Setter for list of components
     * @param components
     */
    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    /**
     * Getter for map of tutorial groups
     * @return
     */
    public Map<String, Tutorial> getTutGroups() {
        return tutGroups;
    }

    /**
     * Setter for map of tutorial groups
     * @param tutGroups
     */
    public void setTutGroups(Map<String, Tutorial> tutGroups) {
        this.tutGroups = tutGroups;
    }

    /**
     * Getter for map of lab groups
     * @return
     */
    public Map<String, Lab> getLabGroups() {
        return labGroups;
    }

    /**
     * Setter for map of lab groups
     * @param labGroups
     */
    public void setLabGroups(Map<String, Lab> labGroups) {
        this.labGroups = labGroups;
    }

    /**
     * Getter for vacancy
     * @return
     */
    public int getVacancy() {
        return vacancy;
    }

    /**
     * Setter for vacancy
     * @param vacancy
     */
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    /**
     * Getter for course size
     * @return
     */
    public int getOriginalVacancy() {
        return originalVacancy;
    }

    /**
     * Setter for course size
     * @param originalVacancy
     */
    public void setOriginalVacancy(int originalVacancy) {
        this.originalVacancy = originalVacancy;
    }
}


