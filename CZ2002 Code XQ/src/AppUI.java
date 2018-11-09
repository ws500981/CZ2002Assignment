import javax.swing.text.StyleContext;
import java.io.*;
import java.util.ArrayList;
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

		int choice;

		do {
			System.out.println("\nWelcome to the STUDENT COURSE REGISTRATION AND MARK ENTRY Application. Please select what you want to do.\n"
					+ "0. Add new professor\n"
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
					System.out.println("Enter Professor ID: ");
					int profId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Professor Name: ");
					String profName = sc.nextLine();
					professorManager.addProf(profId, profName);
					break;
				case 1:
					addStudentMenu(studentManager);
					break;
				case 2:
					addCourseMenu(courseManager, professorManager);
					break;
				case 3:
					viewStudentMenu(studentManager);
					break;
				case 4:
					viewCourseMenu(courseManager);
					break;
				case 5:
					registerStudent(registrationManager, courseManager, studentManager);
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

	private static void addStudentMenu(StudentManager sManager) {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Name: ");
        String Name = sc.nextLine();
        System.out.println("Enter Student ID: ");
        int studentID = sc.nextInt();

		sManager.addStudent(Name, studentID);
	}

	private static void addCourseMenu(CourseManager cManager, ProfessorManager pManager) {

		System.out.println("Enter name of course: ");
        String name = sc.nextLine();
        System.out.println("Enter course ID: ");
        String ID = sc.nextLine();
		System.out.println("Professor List: ");
		for (Integer key : pManager.getAllProfessors().keySet()) {
			System.out.printf("ID: %s \t Name: %s \n", pManager.getAllProfessors().get(key).getProfId(), pManager.getAllProfessors().get(key).getName());
		}
		System.out.println("Select from Professor list");
        System.out.println("Enter ID of Prof in Charge: ");
        Professor professor = pManager.getAllProfessors().get(sc.nextInt());

        System.out.println("Enter Vacancies: ");
        int vacancies = sc.nextInt();

        System.out.println("Enter number of Tutorial Groups: ");
        String[] tutorialName = new String[sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < tutorialName.length; i++) {
        	System.out.printf("Enter name of tutorial %d: ", i+1);
        	tutorialName[i] = sc.nextLine().toLowerCase();
        }

        System.out.println("Enter number of Lab Groups: ");
        String[] labName = new String[sc.nextInt()];
		sc.nextLine();
        for (int i = 0; i < labName.length; i++) {
        	System.out.printf("Enter name of lab %d: ", i+1);
        	labName[i] = sc.nextLine().toLowerCase();
        }

        System.out.println("Enter weightage of Exam: ");
        int examWeight = sc.nextInt();
		System.out.printf("Exam has a weightage of %d%%. Coursework will be allocated the remaining %d%%.\n", examWeight, 100-examWeight);

		System.out.println("Enter number of Coursework subcomponents: ");
        int numComponents = sc.nextInt()+1;
        sc.nextLine();
        String[] componentName = new String[numComponents];
        float[] componentWeight = new float[numComponents];
        componentName[0] = "exam";
        componentWeight[0] = examWeight;

        for (int i = 1; i < numComponents; i++) {
        	System.out.printf("Enter name of component %d: ", i);
        	componentName[i] = sc.nextLine().toLowerCase();
            System.out.printf("\nEnter weightage of %s: ", componentName[i]);
            componentWeight[i] = sc.nextInt();
            sc.nextLine();
        }

		cManager.addCourse(name, ID, professor, vacancies, tutorialName, labName, componentName, componentWeight);

	}

	private static void viewStudentMenu(StudentManager sManager) {
		System.out.print("Please enter StudentID: ");
		int sID = sc.nextInt();
		if (!sManager.getAllStudents().containsKey(sID)) {
			System.out.println("Student ID not found.");
			return;
		}
		int choice = 0;
		do {
			System.out.printf("\nViewing StudentID %d: %s.\n"
					+ "1. Enter coursework marks\n"
					+ "2. Enter exam marks\n"
					+ "3. Print course list\n"
					+ "4. Exit to main menu", sID, sManager.getAllStudents().get(sID).getName());
			System.out.println();

			String cID;
			int marks;

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Please enter the course code: ");
					cID = sc.next();
					RegisteredCourse registeredCourse = sManager.getAllStudents().get(sID).getregisteredCourses().get(cID);
					if (!(sManager.getAllStudents().get(sID).getregisteredCourses().containsKey(cID))){
						System.out.println("Student not registered to course!");
						break;
					}

					System.out.printf("There are %d components: \n", registeredCourse.getComponents().size()-1);


					for (int i = 1; i < registeredCourse.getComponents().size(); i++) {
						Component component = registeredCourse.getComponents().get(i);
						float weight_display = component.getWeight() / (1 - (registeredCourse.getComponents().get(0).getWeight() / 100));
						System.out.printf("Name: %s, Weight: %.0f\n", component.getName(), weight_display);
					}
					System.out.println();

					for (int i = 1; i < registeredCourse.getComponents().size(); i++){
						Component component = registeredCourse.getComponents().get(i);
						System.out.printf("Please enter your marks for %s\n", component.getName());
						marks = sc.nextInt();
						component.setMarks(marks);
					}

					System.out.println("Coursework marks entered");
					break;
				case 2:
					System.out.println("Please enter the exam's course code: ");
					cID = sc.next();
					if (!(sManager.getAllStudents().get(sID).getregisteredCourses().containsKey(cID))){
						System.out.println("Student not registered to course!");
						break;
					}
					System.out.println("Please enter your marks: ");
					marks = sc.nextInt();
					sManager.enterMarksExam(sID, cID, marks);
					System.out.println("Exam marks entered");
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
		String cID = (String) sc.nextLine();
		if (!cManager.getCourseList().containsKey(cID)) {
			System.out.println("Course ID not found.");
			return;
		}

		int choice = 0;

		do {
			System.out.printf("\nViewing CourseID %s: %s.\n"
					+ "1. Check available slots\n"
					+ "2. Print course statistics\n"
					+ "3. Print student list\n"
					+ "4. Exit to main menu\n", cID, cManager.getCourseList().get(cID).getName());

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					cManager.checkAvailSlots(cID);
					break;
				case 2:
					cManager.printCourseStatistics(cID);
					break;
				case 3:
					printStudentList(cManager, cID);
					break;
				case 4:
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;
			}

		} while (choice != 4);
	}

	private static void printStudentList(CourseManager cManager, String cID) {

		int choice = 0;
		String lessonID;

		do {
			System.out.printf("\nPrinting student list for CourseID %s: %s.\n"
					+ "1. Print student list for whole course\n"
					+ "2. Print student list for lecture\n"
					+ "3. Print student list for tutorial\n"
					+ "4. Print student list for lab\n"
					+ "5. Exit to main menu\n", cID, cManager.getCourseList().get(cID).getName());

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
				case 2:
					cManager.printStudentList(cID);
					break;
				case 3:
					System.out.println("Tutorial IDs available: ");

					for (String key : cManager.getCourseList().get(cID).getTutGroups().keySet()) {
						System.out.println(cManager.getCourseList().get(cID).getTutGroups().get(key).getGroupName());
					}
					System.out.println();

					System.out.println("Enter Tutorial ID to print");
					lessonID = sc.nextLine();

					cManager.printStudentListLesson(cID, lessonID, 0);
					break;
				case 4:
					System.out.println("Lab IDs available: ");

					for (String key : cManager.getCourseList().get(cID).getLabGroups().keySet()) {
						System.out.println(cManager.getCourseList().get(cID).getLabGroups().get(key).getGroupName());
					}
					System.out.println();

					System.out.println("Enter Lab ID to print");
					lessonID = sc.nextLine();

					cManager.printStudentListLesson(cID, lessonID, 1);
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;
			}

		} while (choice != 5);
	}

	private static void registerStudent(RegistrationManager rManager, CourseManager cManager, StudentManager sManager) {
		System.out.print("Please enter StudentID: ");
		int sID = sc.nextInt();
		sc.nextLine();
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
		else{

			System.out.println("Tutorial Groups available: " + cManager.getCourseList().get(cID).getTutGroups().size());
			System.out.println("Tutorial Groups: ");
			for (String key : cManager.getCourseList().get(cID).getTutGroups().keySet()) {
				System.out.printf("%s\t", cManager.getCourseList().get(cID).getTutGroups().get(key).getGroupName());
			}
			System.out.println();
			System.out.println("Enter Tutorial Group: ");
			String tutGroup = sc.nextLine();

			System.out.println("Lab Groups available: " + cManager.getCourseList().get(cID).getLabGroups().size());
			for (String key : cManager.getCourseList().get(cID).getLabGroups().keySet()) {
				System.out.printf("%s\t", cManager.getCourseList().get(cID).getLabGroups().get(key).getGroupName());
			}
			System.out.println();
			System.out.println("Enter Lab Group:");
			String labGroup = sc.nextLine();

			if (rManager.registerStudent(cID, sID, cManager, sManager, tutGroup, labGroup)){
				System.out.println("Successfully Registered");
			}
			else{
				System.out.println("Error Registering Course");
			}
		}
		return;
	}



/*
	public static void testwrite(){

		ArrayList<String> courseData = new ArrayList<>();

		courseData.add("test1");
		courseData.add("test2");

		try {
			FileOutputStream fileOut =
					new FileOutputStream("data/test.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(courseData);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in data/courses.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void testread (){
		ArrayList<String> studentData = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream("data/test.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			studentData = (ArrayList<String>) in.readObject();
			in.close();
			fileIn.close();

			System.out.println("size: " + studentData.size());

			for (String student : studentData){
				System.out.println(student);
			}
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
		}


	}
*/

}
