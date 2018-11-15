import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerTest {

    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> createMessages(String message1) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(message1);
        return messages;
    }

    public static int testIntInput(ArrayList<String> messages){

        boolean success;
        int myInt = -1;

        do {
            System.out.println(messages.get(0));
            success = true;
            try {
                myInt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an integer!");
                success = false;
            }
            sc.nextLine();
        } while(!success);

        return myInt;

    }
}
