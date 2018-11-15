public class RegisterStudentManager {
    private Course course;
    private Student student;
    private CourseManager courseManager;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void registerCourse(String courseId, int studentId){
        if(courseManager.checkVacancy(courseId)){
            courseManager.getCourseList();

        }
    }

    private boolean addStudentIntoCourse(int studentID, String nameOfStudent, String courseID) {
        Course course = findCourse(courseID);
        if(!checkStudentInCourse(studentID, course)) {
            course.getStudentsInCourse().

        } else {
            System.out.println(nameOfStudent + " " + studentID + " already exists in " + course.getName());
        }
    }

    private boolean checkStudentInCourse(int studentID, Course course) {
        if(findStudent(studentID, course)!=null) return true;
        else return false;
    }

    private Course findCourse(String courseID) {
        for(String str : this.courseList.keySet()) {
            if(str==courseID) return this.courseList.get(str);
        }
        return null;
    }

    private Student findStudent(int ID, Course course) {
        for(int i : course.getStudentsInCourse().keySet()){
            if(i==ID) return course.getStudentsInCourse().get(i);
        }
        return null;
    }
}
