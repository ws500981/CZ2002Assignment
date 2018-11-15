import java.util.Scanner;

public class RegisterStudentUI {

    private static Scanner sc = new Scanner(System.in);

    public RegisterStudentUI() {
    }

    public static void registerStudent(RegistrationManager rManager, CourseManager cManager, StudentManager sManager) {
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
        } else if (cManager.getCourseList().get(cID).getStudentsList().containsKey(sID)) {
            System.out.println("Student already registered for course. Cancelling operation.");
            return;
        } else {

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

            if (rManager.registerStudent(cID, sID, cManager, sManager, tutGroup, labGroup)) {
                System.out.println("Successfully Registered");
            } else {
                System.out.println("Error Registering Course");
            }
        }
        return;
    }
}
