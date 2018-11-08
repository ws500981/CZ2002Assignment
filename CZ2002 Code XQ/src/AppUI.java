import java.util.Scanner;

public class AppUI {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {	
		
		CourseManager courseManager = new CourseManager();
		StudentManager studentManager = new StudentManager();
		RegistrationManager registrationManager = new RegistrationManager();
		
		int choice;
		
		do {
			System.out.println("Welcome to the STUDENT COURSE REGISTRATION AND MARK ENTRY Application. Please select what you want to do.\n"
					+ "1. Add new student\n"
					+ "2. Add new course\n"
					+ "3. View student info\n"
					+ "4. View course info\n"
					+ "5. Register student for course\n"
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
					registerStudent(registrationManager);
					break;
				case 6:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;				
			}
			
			
		} while (choice != 6);
		
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
		
		System.out.println("Enter name of course: ");
        String name = sc.nextLine();
        System.out.println("Enter course ID in Charge: ");
        String ID = sc.nextLine();
        System.out.println("Enter course Prof in Charge: ");
        String prof = sc.nextLine();
        System.out.println("Enter Vacancies: ");
        int vacancies = sc.nextInt();
        
        System.out.println("Enter number of Tutorial Groups: ");
        String[] tutorialName = new String[sc.nextInt()];
        for (int i = 1; i < tutorialName.length; i++) {
        	System.out.printf("Enter name of tutorial %d: ", i);
        	tutorialName[i] = sc.nextLine().toLowerCase();
        }
        
        System.out.println("Enter number of Lab Groups: ");
        String[] labName = new String[sc.nextInt()];
        for (int i = 1; i < labName.length; i++) {
        	System.out.printf("Enter name of lab %d: ", i);
        	labName[i] = sc.nextLine().toLowerCase();
        }
        
        System.out.println("Enter weightage of Exam: ");
        int examWeight = sc.nextInt();
        System.out.println("Enter number of Coursework subcomponents: ");
        int numComponents = sc.nextInt() + 1;
        String[] componentName = new String[numComponents];
        int[] componentWeight = new int[numComponents];
        componentName[0] = "exam";
        componentWeight[0] = examWeight;
        for (int i = 1; i < numComponents; i++) {
        	System.out.printf("Enter name of component %d: ", i);
        	componentName[i] = sc.nextLine().toLowerCase();
            System.out.printf("\nEnter weightage of %s: ", componentName[i]);
            componentWeight[i] = sc.nextInt();
        }
        
		cManager.addCourse(name, ID, prof, vacancies, tutorialName, labName, componentName, componentWeight);
		return;
	}

	private static void viewStudentMenu(StudentManager sManager) {
		System.out.print("Please enter StudentID: ");
		int sID = sc.nextInt();
		if (!sManager.getAllStudents().containsKey(sID)) {
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
		System.out.print("Please enter CourseID: ");
		int cID = sc.nextLine();
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
	
	private static void registerStudent(RegistrationManager rManager, CourseManager cManager, StudentManager sManager) {
		System.out.print("Please enter StudentID: ");
		int sID = sc.nextInt();
		if (!sManager.getAllStudents().containsKey(sID)) {
			System.out.println("Student ID not found. Cancelling operation.");
			return;
		}
		
		System.out.print("Please enter CourseID to register student to: ");
		String cID = sc.nextLine();
		if (!cManager.getCourseList().containsKey(cID)) {
			System.out.println("Course ID not found. Cancelling operation.");
			return;
		}
		else if (cManager.getCourseList().get(cID).getStudentsList().containsKey(sID)) {
			System.out.println("Student already registered for course. Cancelling operation.");
			return;
		}
		
		rManager.registerStudent(cManager.getCourselist().get(cID), sManager.getAllStudents().containsKey(sID));
		
		return;
	}

}
