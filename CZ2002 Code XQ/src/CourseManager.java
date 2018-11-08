import java.io.*;
import java.util.*;

public class CourseManager {
    private SortedMap<Integer, Course> coursemap = new TreeMap<Integer, Course>();
    
    
    Scanner sc = new Scanner(System.in);


    public void addCourse(){
        System.out.println("Enter course ID: ");
        int courseID;
        do {
        	courseID = sc.nextInt();
        	if (coursemap.get(courseID) != null) {
        		System.out.println("Course ID " + Integer.toString(courseID) + " has already been assigned to " + coursemap.get(courseID).getName());
        	}
        } while (coursemap.get(courseID) != null);
        
        Course course1 = new Course (courseID);
        course1.createLabGroups(groups);

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

	public Course[] getCourselist() {
		return courselist;
	}

}
