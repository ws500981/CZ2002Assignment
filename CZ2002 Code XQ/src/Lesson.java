import java.util.SortedMap;

public abstract class Lesson implements java.io.Serializable{

    /**
     * Name of lesson
     */
    private String groupName;
    private static final long serialVersionUID = 1L;

    /**
     * Number of vacanies
     */
    private int Vacancy;

    /**
     * Lesson size
     */
    private int originalVacancy;

    /**
     * SortedMap of students, with keys of student ID and values of student objects
     */
    private SortedMap<Integer, Student> studentList;

    /**
     * Constructor to assign values
     * @param groupName
     * @param vacancy
     * @param studentList
     */
    public Lesson(String groupName, int vacancy, SortedMap<Integer, Student> studentList) {
        this.groupName = groupName;
        this.Vacancy = vacancy;
        this.originalVacancy = vacancy;
        this.studentList = studentList;
    }

    /**
     * Getter for name
     * @return
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Setter for name
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Getter for vacancy
     * @return
     */
    public int getVacancy() {
        return Vacancy;
    }

    /**
     * Setter for vacancy
     * @param vacancy
     */
    public void setVacancy(int vacancy) {
        Vacancy = vacancy;
    }

    /**
     * Getter for sortedMap of students
     * @return
     */
    public SortedMap<Integer, Student> getStudentList() {
        return studentList;
    }

    /**
     * Setter for sortedMap of students
     * @param studentList
     */
    public void setStudentList(SortedMap<Integer, Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Getter for lesson size
     * @return
     */
    public int getOriginalVacancy() {
        return originalVacancy;
    }

    /**
     * Setter for lesson size
     * @param originalVacancy
     */
    public void setOriginalVacancy(int originalVacancy) {
        this.originalVacancy = originalVacancy;
    }
}
