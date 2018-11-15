public class RegistrationManager {

    public Boolean registerStudent(String courseID, int studentID, CourseManager courseManager, StudentManager studentManager, String tutGroup, String labGroup) {

        Course course = courseManager.getCourseList().get(courseID);
        Student student = studentManager.getAllStudents().get(studentID);
        Lab lab = course.getLabGroups().get(labGroup);
        Tutorial tut = course.getTutGroups().get(tutGroup);

        Boolean registered = true;

        //check if student is already registered
        if (!(course.getStudentsList().containsKey(studentID))){
            //add student into lab and tutorial

            if (course.getVacancy() <= 0) {
                registered = false;
            }
            else{
                //add student into course student list and minus vacancy
                course.getStudentsList().put(studentID, student);
                course.setVacancy(course.getVacancy()-1);
            }

            if(addStudentintoLesson(lab, student) && addStudentintoLesson(tut, student)){
                registered = true;
            }
            else{
                registered = false;
            }

            RegisteredCourse register = new RegisteredCourse(course.getName(), courseID, course.getComponents(), tutGroup, labGroup);

            //add registered course into student
            student.getregisteredCourses().put(courseID, register);;
        }
        else{
            System.out.println(student.getName() + " " + student.getId() + " already exists in " + course.getName());
            registered = false;
        }
        return registered;
    }

    //check vacancies in lab/tut
    private Boolean addStudentintoLesson(Lesson lesson, Student student){

        if (lesson.getVacancy() > 0){
            lesson.getStudentList().put(student.getId(), student);
            lesson.setVacancy(lesson.getVacancy()-1);
            return true;
        }
        else{
            return false;
        }

    }

}
