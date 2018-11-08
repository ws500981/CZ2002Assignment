public class RegistrationManager {

    public boolean registerStudent(Course course, Student student) {

        if(!checkStudentInCourse(student.getStudentID(), course)) {
            course.getStudentsList().put(student.getStudentID(), student);
            return true;

        } else {
            System.out.println(student.getName() + " " + student.getStudentID() + " already exists in " + course.getName());
            return false;
        }
    }

    private boolean checkStudentInCourse(int studentID, Course course) {
        if(findStudent(studentID, course)!=null) return true;
        else return false;
    }

    private void findCourse(String courseID) {


    }

    private Student findStudent(int ID, Course course) {
        for(int i : course.getStudentsList().keySet()){
            if(i==ID) return course.getStudentsList().get(i);
        }
        return null;
    }
}
