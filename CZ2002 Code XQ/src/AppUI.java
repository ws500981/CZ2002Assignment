import javax.swing.text.StyleContext;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
