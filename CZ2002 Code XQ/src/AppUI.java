import java.util.Scanner;

public class AppUI {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		CourseManager courseManager = new CourseManager();
		StudentManager studentManager = new StudentManager();
		RegistrationManager registrationManager = new RegistrationManager();
		ProfessorManager professorManager = new ProfessorManager();

		studentManager.readData();
		courseManager.readData();
		professorManager.readData();

		boolean success = true;

		int choice;

		do {
			System.out.println("\nWelcome to the STUDENT COURSE REGISTRATION AND MARK ENTRY Application. Please select what you want to do.\n"
					+ "1. Add new student\n"
					+ "2. Add new course\n"
					+ "3. View student info\n"
					+ "4. View course info\n"
					+ "5. Register student for course\n"
					+ "6. Save Data\n"
					+ "7. Exit application");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 0:

//					professorManager.addProf(101, "James Cameron");
//					professorManager.addProf(102, "Steven Spielberg");
//					professorManager.addProf(103, "Christopher Nolan");
//					professorManager.addProf(104, "Stan Lee");
//					studentManager.addStudent("Jet Li", 1001);
//					studentManager.addStudent("Jay Chou", 1002);
//					studentManager.addStudent("Ariana Grande", 1003);
//					studentManager.addStudent("Leonardo DiCaprio", 1004);
//					studentManager.addStudent("Jessie McCartney", 1005);
//					studentManager.addStudent("Brad Pitt", 1006);
//					studentManager.addStudent("Angelina Jolie", 1007);
//					studentManager.addStudent("Taylor Swift", 1008);
//					studentManager.addStudent("Mariah Carey", 1009);
//					studentManager.addStudent("Justin Bieber", 1010);
//					studentManager.addStudent("Katy Perry", 1011);
//					studentManager.addStudent("Ed Sheeran", 1012);
//					studentManager.addStudent("Demi Lovato", 1013);
//					studentManager.addStudent("Paris Hilton", 1014);
//					studentManager.addStudent("Selena Gomez", 1015);


					String [] test1 = {"m1", "m2"};
					float [] test1_weight = {50f, 50f, 50f};
					String [] test1_names = {"Exam", "Assignment", "Test"};

					courseManager.addCourse("Math", "m001", professorManager.getAllProfessors().get(102), 20, test1, test1, test1_names, test1_weight);


					String [] test3 = {"p1", "p2"};
					float [] test3_weight = {60f, 100f};
					String [] test3_names = {"Exam", "Coursework"};

					courseManager.addCourse("Physics", "p001", professorManager.getAllProfessors().get(103), 20, test3, test3, test3_names, test3_weight);




					break;
				case 1:
					AddStudentUI.addStudentMenu(studentManager);
					break;
				case 2:
					AddCourseUI.addCourseMenu(courseManager, professorManager);
					break;
				case 3:
					//courseManager.update("m001", studentManager);
					ViewStudentMenuUI.viewStudentMenu(studentManager, courseManager);
					break;
				case 4:
					ViewCourseMenuUI.viewCourseMenu(courseManager);
					break;
				case 5:
					RegisterStudentUI.registerStudent(registrationManager, courseManager, studentManager);
					break;
				case 6:
				case 7:
					studentManager.writeData();
					courseManager.writeData();
					professorManager.writeData();
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;
			}

		} while (choice != 7);
	}
}
