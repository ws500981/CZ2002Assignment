import java.util.Scanner;

public class AddCourseUI {

    private static Scanner sc = new Scanner(System.in);

    public static void addCourseMenu(CourseManager cManager, ProfessorManager pManager) {

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
}
