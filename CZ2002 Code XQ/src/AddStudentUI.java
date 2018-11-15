import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AddStudentUI {

    private static Scanner sc = new Scanner(System.in);

    public static void addStudentMenu(StudentManager sManager) {
        // TODO Auto-generated method stub
        System.out.println("Enter Student Name: ");
        String Name = sc.nextLine();
//        System.out.println("Enter Student ID: ");
//        int studentID = sc.nextInt();
        ArrayList<String> messages = ScannerTest.createMessages("Enter Student ID: ");
        int studentID = ScannerTest.testIntInput(messages);

        sManager.addStudent(Name, studentID);
    }
}
