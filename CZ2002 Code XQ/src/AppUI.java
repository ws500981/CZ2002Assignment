import java.util.Scanner;

public class AppUI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		CourseManager courseManager = new CourseManager();
		//create studentManager
		//create registerStudentManager
		
		int choice;
		
		do {
			System.out.println("Welcome to the STUDENT COURSE REGISTRATION AND MARK ENTRY Application. Please select what you want to do.\n"
					+ "1. Add new student\n"
					+ "2. Add new course\n"
					+ "3. Edit student info\n"
					+ "4. Edit course info\n"
					+ "5. Check for course slot\n"
					+ "6. Exit application");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					addStudentMenu();
					break;
				case 2:
					addCourseMenu(courseManager);
					break;
				case 3:
					editStudentMenu();
					break;
				case 4:
					editCourseMenu(courseManager);
					break;
				case 5:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;				
			}
			
			
		} while (choice != 5);
		
	}

	private static void addStudentMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void addCourseMenu(CourseManager cManager) {
		cManager.addCourse();
	}

	private static void editStudentMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void editCourseMenu(CourseManager cManager) {
		
		
		System.out.println("Enter course ID");
		
		
	}

}
