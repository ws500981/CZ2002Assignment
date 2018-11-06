public class Lesson {
    private String groupName;
    private int Vacancy;
    private StudentInCourse[] studentList;

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

    public StudentInCourse[] getStudentList() {
        return studentList;
    }

    public void setStudentList(StudentInCourse[] studentList) {
        this.studentList = studentList;
    }
}
