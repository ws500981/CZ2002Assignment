import java.util.ArrayList;
import java.util.Scanner;

public class AddStudentUI {

    private static ArrayList<String> messages;

    public static void addStudentMenu(StudentManager sManager) {
        String name = ScannerManager.stringInput("Enter Student Name: ");
        messages = ScannerManager.createMessages("Enter Student ID: ", "Student ID should a positive number!");
        int studentID = ScannerManager.testIntInput(messages, 1);

        sManager.addStudent(name, studentID);
    }
}
