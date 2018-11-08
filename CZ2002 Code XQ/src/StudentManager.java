import java.util.HashMap;

public class StudentManager {

    HashMap<Integer, String> allStudents = new HashMap<>();

    public void addStudent(String Name, int studentID) {

        Student student = new Student();
        student.setName(Name);
        student.setStudentID(studentID);
        allStudents.put(student.getStudentID(), student.getName());

        for (Integer i : allStudents.keySet()) {

            System.out.println(allStudents.get(i) + ", " + i);
        }
    }
}