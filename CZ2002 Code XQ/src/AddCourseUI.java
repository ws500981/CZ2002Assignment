import java.util.ArrayList;
import java.util.Scanner;

public class AddCourseUI {

    private static ArrayList<String> messages;

    public static void addCourseMenu(CourseManager cManager, ProfessorManager pManager) {

        String name = ScannerManager.stringInput("Enter name of course: ");

        String ID = ScannerManager.stringInput("Enter course ID: ");

        System.out.println("Professor List: ");
        for (Integer key : pManager.getAllProfessors().keySet()) {
            System.out.printf("ID: %s \t Name: %s \n", pManager.getAllProfessors().get(key).getProfId(), pManager.getAllProfessors().get(key).getName());
        }
        Professor professor = pManager.getAllProfessors().get(ScannerManager.testIntInput("Select from Professor list\nEnter ID of Prof in Charge: "));
        do {
            professor = pManager.getAllProfessors().get(ScannerManager.testIntInput("Unable to find professor! Please enter a valid ID: "));
        }while(professor==null);

        ArrayList<String> messages = ScannerManager.createMessages("Enter Vacancies: ", "Vacanies should be between 1 and 1000");
        int vacancies = ScannerManager.testIntInput(messages, 1, 1000);

        messages = ScannerManager.createMessages("Enter number of Tutorial Groups: ", "Number of tutorial groups should a positive number!");
        int numberOfTutGroups = ScannerManager.testIntInput(messages, 1);
        String[] tutorialName = new String[numberOfTutGroups];

        for (int i = 0; i < tutorialName.length; i++) {
            tutorialName[i] = ScannerManager.stringInput("Enter name of tutorial " + (i+1) + ": ").toLowerCase();
        }

        messages = ScannerManager.createMessages("Enter number of Lab Groups: ", "Number of Lab Groups should be positive!");
        String[] labName = new String[ScannerManager.testIntInput(messages, 1)];
        for (int i = 0; i < labName.length; i++) {
            labName[i] = ScannerManager.stringInput("Enter name of lab " + (i+1) + ": ").toLowerCase();
        }

        messages = ScannerManager.createMessages("Enter weightage of Exam: ", "Weightage should be between 1 and 100");
        int examWeight = ScannerManager.testIntInput(messages, 1, 100);
        System.out.printf("Exam has a weightage of %d%%. Coursework will be allocated the remaining %d%%.\n", examWeight, 100-examWeight);

        messages = ScannerManager.createMessages("Enter number of Coursework subcomponents: ", "Number of subcomponents should be positive!");
        int numComponents = ScannerManager.testIntInput(messages, 1) + 1;
        String[] componentName = new String[numComponents];
        float[] componentWeight = new float[numComponents];
        componentName[0] = "exam";
        componentWeight[0] = examWeight;

        for (int i = 1; i < numComponents; i++) {
            float sumOfWeightage = 0;
            int index = numComponents-1;
            componentName[i] = ScannerManager.stringInput("Enter name of component " + i + ": ").toLowerCase();
            if(i < numComponents-1){
                messages = ScannerManager.createMessages("Enter weightage of " + componentName[i] + " (upon 100%): ", "Weightage should be between 1 and 100!");
                componentWeight[i] = (float) ScannerManager.testIntInput(messages, 1, 100);
                sumOfWeightage += componentWeight[i];
//                System.out.println("componentWeight[1]" + componentWeight[i]);
//                System.out.println("sumOfWeightage: " + sumOfWeightage);
            } else {
                break;
            }
//            System.out.println("sumOfWeightage: " + sumOfWeightage);
            componentWeight[index] = 100 - sumOfWeightage;
//            for(float f : componentWeight) {
//                System.out.println("Component weight " + f);
//            }

        }
        cManager.addCourse(name, ID, professor, vacancies, tutorialName, labName, componentName, componentWeight);

    }
}
