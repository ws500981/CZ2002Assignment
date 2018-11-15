import java.util.ArrayList;
import java.util.Scanner;

public class AddCourseUI {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> messages;

    public static void addCourseMenu(CourseManager cManager, ProfessorManager pManager) {

        System.out.println("Enter name of course: ");
        String name = sc.nextLine();

        System.out.println("Enter course ID: ");
        String ID = sc.nextLine();

        System.out.println("Professor List: ");
        for (Integer key : pManager.getAllProfessors().keySet()) {
            System.out.printf("ID: %s \t Name: %s \n", pManager.getAllProfessors().get(key).getProfId(), pManager.getAllProfessors().get(key).getName());
        }
        System.out.println("Select from Professor list\nEnter ID of Prof in Charge: ");
        Professor professor = pManager.getAllProfessors().get(sc.nextInt());
        do {
            System.out.println("Unable to find professor! Please enter a valid ID: ");
            professor = pManager.getAllProfessors().get(sc.nextInt());
        }while(professor==null);

        System.out.println("Enter Vacancies: ");
        messages = ScannerManager.createMessages("Enter Vacancies: ", "Student ID should a positive number!");
        int vacancies = ScannerManager.testIntInput(messages, 0);

        messages = ScannerManager.createMessages("Enter number of Tutorial Groups: ", "Number of tutorial groups should a positive number!");
        int numberOfTutGroups = ScannerManager.testIntInput(messages, 0);
        String[] tutorialName = new String[numberOfTutGroups];

        for (int i = 0; i < tutorialName.length; i++) {
            tutorialName[i] = ScannerManager.stringInput("Enter name of tutorial " + (i+1) + " :").toLowerCase();
        }

        System.out.println("Enter number of Lab Groups: ");
        String[] labName = new String[sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < labName.length; i++) {
            System.out.printf("Enter name of lab %d: ", i+1);
            labName[i] = sc.nextLine().toLowerCase();
        }

        messages = ScannerManager.createMessages("Enter weightage of Exam: ", "Weightage should not be 0 or negative!");
        int examWeight = ScannerManager.testIntInput(messages, 0);
        System.out.printf("Exam has a weightage of %d%%. Coursework will be allocated the remaining %d%%.\n", examWeight, 100-examWeight);

        messages = ScannerManager.createMessages("Enter number of Coursework subcomponents: ", "Number of subcomponents should not be 0 or negative!");
        int numComponents = ScannerManager.testIntInput(messages, 0) + 1;
        String[] componentName = new String[numComponents];
        float[] componentWeight = new float[numComponents];
        componentName[0] = "exam";
        componentWeight[0] = examWeight;

        for (int i = 1; i < numComponents; i++) {
            componentName[i] = ScannerManager.stringInput("Enter name of component " + i + " :").toLowerCase();
            messages = ScannerManager.createMessages("\nEnter weightage of %s: " + componentName[i] + " :", "Weightage should not be 0 or negative!");
            componentWeight[i] = (float) ScannerManager.testIntInput(messages, 0);
        }

        cManager.addCourse(name, ID, professor, vacancies, tutorialName, labName, componentName, componentWeight);

    }
}
