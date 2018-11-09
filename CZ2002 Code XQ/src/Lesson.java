import java.util.SortedMap;

public abstract class Lesson implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String groupName;
    private int Vacancy;
    private int originalVacancy;
    private SortedMap<Integer, Student> studentList;

    public Lesson(String groupName, int vacancy, SortedMap<Integer, Student> studentList) {
        this.groupName = groupName;
        this.Vacancy = vacancy;
        this.originalVacancy = vacancy;
        this.studentList = studentList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getVacancy() {
        return Vacancy;
    }

    public void setVacancy(int vacancy) {
        Vacancy = vacancy;
    }

    public SortedMap<Integer, Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(SortedMap<Integer, Student> studentList) {
        this.studentList = studentList;
    }

    public int getOriginalVacancy() {
        return originalVacancy;
    }

    public void setOriginalVacancy(int originalVacancy) {
        this.originalVacancy = originalVacancy;
    }
}
