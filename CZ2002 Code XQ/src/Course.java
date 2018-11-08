public class Course {

    private String Name;
    private int courseID;
    private String profInCharge;
    private StudentInCourse Students;
    private Coursework courseWork = new Coursework();
    private Exam Exam = new Exam();
    private Tutorial[] tutGroups;
    private Lab[] labGroups;
    private int Vacancy = 0;

    public Course(int ID) {
        courseID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getProfInCharge() {
        return profInCharge;
    }

    public void setProfInCharge(String profInCharge) {
        this.profInCharge = profInCharge;
    }

    public StudentInCourse getStudents() {
        return Students;
    }

    public void setStudents(StudentInCourse students) {
        Students = students;
    }

    public Exam getExam() {
        return Exam;
    }

    public void setExam(Exam exam) {
        Exam = exam;
    }

    public Tutorial[] getTutGroups() {
        return tutGroups;
    }

    public void setTutGroups(Tutorial[] tutGroups) {
        this.tutGroups = tutGroups;
    }

    public void createTutGroups (int groups){
        int vacanciesLeft = Vacancy;

        tutGroups = new Tutorial[groups];

        for (Tutorial tut : tutGroups){
            tut.setVacancy(vacanciesLeft/groups);
        }

        //ensure all tut/lab have same number of slots as lect
        if (vacanciesLeft % groups != 0 ){
            for (int i = 0; i < (vacanciesLeft%groups); i++){
                tutGroups[i].setVacancy((tutGroups[i].getVacancy()+1));
            }
        }

    }

    public Lab[] getLabGroups() {
        return labGroups;
    }

    public void setLabGroups(Lab[] labGroups) {
        this.labGroups = labGroups;
    }

    public void createLabGroups (int groups){
        labGroups = new Lab[groups];
        int vacanciesLeft = Vacancy;

        for (Lab lab : labGroups){
            lab.setVacancy(vacanciesLeft/groups);
        }

        //ensure all tut/lab have same number of slots as lect
        if (vacanciesLeft % groups != 0 ){
            for (int i = 0; i < (vacanciesLeft%groups); i++){
                labGroups[i].setVacancy((labGroups[i].getVacancy()+1));
            }
        }
    }

    public int getVacancy() {
        return Vacancy;
    }

    public void setVacancy(int vacancy) {
        Vacancy = vacancy;
    }

    public void setWeight(int weight){
        Exam.setWeight(weight);
        courseWork.setWeight(100-weight);

    }
}
