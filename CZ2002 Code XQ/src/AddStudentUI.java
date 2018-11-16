import java.util.ArrayList;

/**
 * Boundary class used only for adding students
 */
public class AddStudentUI {

    /**
     * This is for console log purposes
     */
    private static ArrayList<String> messages;

    /**
     * UI that adds a new student
     * @param sManager
     */
    public static void addStudentMenu(StudentManager sManager) {

        String name = ScannerManager.stringInput("Enter Student Name: ");
        messages = ScannerManager.createMessages("Enter Student ID: ", "Student ID should a positive number!");
        int studentID = ScannerManager.testIntInput(messages, 1);

        sManager.addStudent(name, studentID);
    }
}
