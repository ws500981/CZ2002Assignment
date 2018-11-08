import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {

    HashMap<Integer, Student> allStudents = new HashMap<>();

    public void addStudent(String Name, int studentID) {

        Student student = new Student();
        student.setName(Name);
        student.setStudentID(studentID);
        allStudents.put(student.getStudentID(), student);

        for (Integer key : allStudents.keySet()) {

            System.out.println(allStudents.get(key) + ", " + key);
        }
    }

    public HashMap<Integer, Student> getAllStudents(){

        return this.allStudents;

    }

    public void enterMarks (int studentID, String courseID, int marks){

        Student student = allStudents.get(studentID);
        HashMap<String, RegisteredCourse> courses = student.getregisteredCourses();
        RegisteredCourse course = courses.get(courseID);
        ArrayList<Component> components = course.getComponents();

        for(Component c : components) {

            if (c.getName().toLowerCase()== "exam") {
                c.setMarks(marks);

            }
        }
    }

    public void printStudentTranscript (int studentID){

        Student student = allStudents.get(studentID);
        HashMap<String, RegisteredCourse> courses = student.getregisteredCourses();

        System.out.println("Transcript\n");
        System.out.println("Student ID: " + studentID + "Name: " + student.getName() + "" +
                "\n");
        System.out.println("Subject \t Results");

        for (String s : courses.keySet()) {

            System.out.println("%s" + courses.get(s).getCourseId() + "\t" + "%d" + courses.get(s).calculateResults());
        }

    }

}