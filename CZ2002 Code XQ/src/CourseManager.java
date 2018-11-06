import java.sql.SQLOutput;
import java.util.Scanner;

public class CourseManager {
    private Course[] courselist;
    Scanner sc = new Scanner(System.in);


    public void addCourse(){
        System.out.println("Enter course ID: ");
        int courseID = sc.nextInt();
        Course course = new Course (courseID);

        System.out.println("Enter name of course: ");
        course.setName(sc.nextLine());

        System.out.println("Enter course Prof in Charge: ");
        course.setProfInCharge(sc.nextLine());
        System.out.println("Enter Exam Weight! The remaining percentage will be assigned to CourseWork. Exam Weight: ");
        course.setWeight(sc.nextInt());
        System.out.println("Enter Vacancies: ");
        course.setVacancy(sc.nextInt());
        System.out.println("Enter number of Tutorial Groups: ");
        course.createTutGroups(sc.nextInt());
        System.out.println("Enter number of Lab Groups: ");
        course.createLabGroups(sc.nextInt());
    }

    public Boolean checkVacancy(Course course){
        return false;
    }
}
