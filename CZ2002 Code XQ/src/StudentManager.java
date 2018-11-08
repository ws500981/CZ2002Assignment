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

    public void enterMarks (int studentID){

    }

    public void printStudentTranscript (int studentID){

    }

}