import java.util.ArrayList;
import java.util.List;

public class UniversityApp {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        addStudent(studentList,"John", "A123456K");
        addStudent(studentList,"John", "A123456K");
        addCourse(courseList, "CZ2002", "OODP",  10, "Tan");
        addCourse(courseList, "CZ2002", "OODP",  10, "Tan");
        Student selectedStudent = findStudent("A123456K", studentList);
        Course selectedCourse = findCourse("CZ2002", courseList);
        registerStudentForCourse(selectedStudent, selectedCourse);
        registerStudentForCourse(selectedStudent, selectedCourse);
        getCourseVacancy(selectedCourse);

    }



    public static boolean addStudent(List<Student> studentList, String name, String ID) {
        if(findStudent(ID, studentList) != null) {
            System.out.println("Student already exists");
            return false;
        } else {
            studentList.add(new Student(name, ID));
            System.out.println("Student added");
            return true;
        }
    }

    public static boolean addCourse(List<Course> courseList, String ID, String name, int courseSize, String profInCharge) {
        if(findCourse(ID, courseList) != null) {
            System.out.println("Course already exists");
            return false;
        } else {
            courseList.add(new Course(ID, name, courseSize, profInCharge));
            System.out.println("Course added");
            return true;
        }
    }

    public static boolean registerStudentForCourse(Student student, Course course) {
        return course.registerStudent(student);
    }

    public static int getCourseVacancy(Course course) {
        System.out.println(course.getID() + " " + course.getName() + " has " + course.getVacancy() + " vacanies");
        return course.getVacancy();
    }

    private static int findStudentByElement(String ID, List<Student> studentList) {
        for(int i=0; i< studentList.size(); i++) {
            if(ID == studentList.get(i).getID()) return i;
        }
        return -1;
    }

    private static int findCourseByElement(String ID, List<Course> courseList) {
        for(int i=0; i< courseList.size(); i++) {
            if(ID == courseList.get(i).getID()) return i;
        }
        return -1;
    }

    public static Student findStudent(String ID, List<Student> studentList) {
        if(studentList.isEmpty()) return null;
        else return studentList.get(findStudentByElement(ID, studentList));
    }

    public static Course findCourse(String ID, List<Course> courseList) {
        if(courseList.isEmpty()) return null;
        else return courseList.get(findCourseByElement(ID, courseList));
    }
}
