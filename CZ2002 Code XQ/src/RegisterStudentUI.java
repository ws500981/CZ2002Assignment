import java.util.Scanner;

public class RegisterStudentUI {

    private static Scanner sc = new Scanner(System.in);

    public RegisterStudentUI() {
    }

    public static void registerStudent(RegistrationManager rManager, CourseManager cManager, StudentManager sManager) {
        int sID = ScannerManager.testIntInput("Please enter Student ID: ");
        while(!sManager.getAllStudents().containsKey(sID)) {
            sID = ScannerManager.testIntInput("Student ID not found! Please re-enter Student ID: ");
        }

        String cID = ScannerManager.stringInput("Please enter Course ID to register student to: ");
        while (!cManager.getCourseList().containsKey(cID) || cManager.getCourseList().get(cID).getStudentsList().containsKey(sID) ) {
            cID = ScannerManager.stringInput("Course ID not found or Student already registered for course! Please re-enter Course ID: ");
        }

        System.out.println("Tutorial Groups available: " + cManager.getCourseList().get(cID).getTutGroups().size() + "\nTutorial Groups: ");
        for (String key : cManager.getCourseList().get(cID).getTutGroups().keySet()) {
            System.out.printf("%s\t", cManager.getCourseList().get(cID).getTutGroups().get(key).getGroupName());
        }
        String tutGroup = ScannerManager.stringInput("\nEnter Tutorial Group: ");
        while(!cManager.getCourseList().get(cID).getTutGroups().containsKey(tutGroup)) {
            tutGroup = ScannerManager.stringInput("Tutorial Group cannot be found! Please re-enter Tutorial Group: ");
        }

        System.out.println("Lab Groups available: " + cManager.getCourseList().get(cID).getLabGroups().size());
        for (String key : cManager.getCourseList().get(cID).getLabGroups().keySet()) {
            System.out.printf("%s\t", cManager.getCourseList().get(cID).getLabGroups().get(key).getGroupName());
        }
        String labGroup = ScannerManager.stringInput("\nEnter Lab Group: ");
        while(!cManager.getCourseList().get(cID).getLabGroups().containsKey(labGroup)) {
            labGroup = ScannerManager.stringInput("Lab Group cannot be found! Please re-enter Lab Group: ");
        }

        if (rManager.registerStudent(cID, sID, cManager, sManager, tutGroup, labGroup)) {
            System.out.println("Successfully Registered");
        } else {
            System.out.println("Error Registering Course");
        }
    }
}
