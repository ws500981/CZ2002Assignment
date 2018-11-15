import java.util.*;

public class Course {

    private String ID;
    private String name;
    private List<Student> studentList;
    private int vacancy;
    private String profInCharge;

    public Course(String ID, String name, int courseSize, String profInCharge) {
        this.ID = ID;
        this.name = name;
        this.studentList = new ArrayList<>();
        this.vacancy = courseSize;
        this.profInCharge = profInCharge;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getVacancy() {
        return vacancy;
    }

    public String getProfInCharge() {
        return profInCharge;
    }

    public boolean registerStudent(Student student) {
        if(studentList.contains(student)) {
            System.out.println(student.getName() + ": " + student.getID() + " is already registered in " + this.ID + " " + this.name);
            return false;
        } else {
            studentList.add(student);
            System.out.println(student.getName() + ": " + student.getID() + " added to " + this.ID + " " + this.name);
            this.vacancy--;
            return true;
        }
    }

    public void printCourse() {
        System.out.println(this.ID + ": " + this.name + "\n" +
                "\tProfessor-in-charge (coordinator): Prof " + this.profInCharge);
    }
}
