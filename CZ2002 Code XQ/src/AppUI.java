import java.util.Scanner;

public class AppUI {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {	
		
		CourseManager courseManager = new CourseManager();
		StudentManager studentManager = new StudentManager();
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
					addStudentMenu(studentManager);
					break;
				case 2:
					addCourseMenu(courseManager);
					break;
				case 3:
					viewStudentMenu(studentManager);
					break;
				case 4:
					viewCourseMenu(courseManager);
					break;
				case 5:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;				
			}
			
			
		} while (choice != 5);
		
	}

	private static void addStudentMenu(StudentManager sManager) {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Name: ");
        String Name = sc.nextLine();
        System.out.println("Enter Student ID: ");
        int studentID = sc.nextInt();
        
		sManager.addStudent(Name, studentID);
		return;
	}

	private static void addCourseMenu(CourseManager cManager) {
		// TODO Add course code
		
		System.out.println("Enter name of course: ");
        String name = sc.nextLine();
        System.out.println("Enter course Prof in Charge: ");
        String prof = sc.nextLine();
        System.out.println("Enter Exam Weight. The remaining percentage will be assigned to CourseWork. Exam Weight: ");
        int examWeight = sc.nextInt();
        System.out.println("Enter Vacancies: ");
        int vacancies = sc.nextInt();
        System.out.println("Enter number of Tutorial Groups: ");
        int numTutGroups = sc.nextInt();
        System.out.println("Enter number of Lab Groups: ");
        int numLabGroups = sc.nextInt();
        
		cManager.addCourse(name, prof, examWeight, vacancies, numTutGroups, numLabGroups);
		return;
	}

	private static void viewStudentMenu(StudentManager sManager) {

		int sID = sc.nextInt();
		if (!sManager.getCourseList().containsKey(sID)) {
			System.out.println("Student ID not found.");
			return;
		}
		
		do {
			System.out.printf("Viewing StudentID %d: %s.\n"
					+ "1. Register for course\n"
					+ "2. Enter Marks\n"
					+ "3. Print student list\n"
					+ "4. Exit to main menu", sID, sManager.getAllStudents().get(sID).getName());
			
			int choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					sManager.registerCourse(sID);
					break;
				case 2:
					sManager.enterMarks(sID);
					break;
				case 3:
					sManager.printStudentTranscript(sID);
					break;
				case 4:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;				
			}
			
		} while (choice != 4);
	}

	private static void viewCourseMenu(CourseManager cManager) {	
		
		int cID = sc.nextInt();
		if (!cManager.getCourseList().containsKey(cID)) {
			System.out.println("Course ID not found.");
			return;
		}
		
		do {
			System.out.printf("Viewing CourseID %d: %s.\n"
					+ "1. Check available slots\n"
					+ "2. Print course statistics\n"
					+ "3. Print student list\n"
					+ "4. Exit to main menu", cID, cManager.getCourseList().get(cID).getName());
			
			int choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					cManager.checkAvailSlots(cID);
					break;
				case 2:
					cManager.printCourseStatistics(cID);
					break;
				case 3:
					printStudentList(cID);
					break;
				case 4:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;				
			}
			
		} while (choice != 4);
		
	}

}
