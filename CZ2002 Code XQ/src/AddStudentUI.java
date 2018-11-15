import java.util.ArrayList;
import java.util.Scanner;

public class AddStudentUI {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> messages;

    public static void addStudentMenu(StudentManager sManager) {
        messages = ScannerManager.createMessages("Enter Student ID: ", "Student ID should not be 0 or negative!");
        int studentID = ScannerManager.testIntInput(messages, 0);
        String name = ScannerManager.stringInput("Enter Student Name: ");

        sManager.addStudent(name, studentID);
    }
}
