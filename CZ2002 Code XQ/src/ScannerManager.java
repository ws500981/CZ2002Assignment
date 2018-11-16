import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Control class pertaining only to scanner
 * Decentralises user inputs away from the other parts of the code
 */
public class ScannerManager {

    /**
     * Initialise scanner object
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Method to added many strings into an ArrayList of messages
     * @param message1
     * @param message2
     * @return
     */
    public static ArrayList<String> createMessages(String message1, String message2) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        return messages;
    }

    /**
     * Blueprint method to enact scanner functionality accepting String values
     * message refers to the message prompted to user for input
     * @param message
     * @return
     */
    public static String stringInput(String message) {
    	//default string input
        System.out.println(message);
        return sc.nextLine();
    }

    /**
     * Blueprint method to enact scanner functionality accepting Integer values, with exceptions included
     * message refers to the message prompted to user for input
     * @param message
     * @return
     */
    public static int testIntInput(String message) {
        //default int input
        boolean success;
        int myInt = -1;

        do {
            System.out.println(message);
            success = true;
            try {
                myInt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an integer!");
                success = false;
            }
            sc.nextLine();
        } while (!success);

        return myInt;
    }

    /**
     * Blueprint method to enact scanner functionality accepting Integer values, with exceptions included
     * ArrayList of messages refers to the message prompted to user for input, as well as other messages prompted after exceptions are thrown
     * lowerLimit sets the lower boundary in which an exception will be thrown if user input an integer lower than it
     * @param messages
     * @param lowerLimit
     * @return
     */
    public static int testIntInput (ArrayList < String > messages,int lowerLimit){
        //customizable int input that contains upper and lower limit and custom message. required to createMessages first

        boolean success;
        int myInt = -1;

        do {
            System.out.println(messages.get(0));
            success = true;
            try {
                myInt = sc.nextInt();
                if (myInt < lowerLimit) throw new CustomException(messages.get(1));
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an integer!");
                success = false;
            } catch (CustomException e) {
                System.out.println(messages.get(1));
                success = false;
            }
            sc.nextLine();
        } while (!success);

        return myInt;

    }

    /**
     * Overloaded method
     * upperLimit sets the upper boundary in which an exception will be thrown if user input an integer larger than it
     * @param messages
     * @param lowerLimit
     * @param upperLimit
     * @return
     */
    public static int testIntInput (ArrayList < String > messages,int lowerLimit, int upperLimit){
        //customizable int input that contains upper and lower limit and custom message. required to createMessages first

        boolean success;
        int myInt = -1;

        do {
            System.out.println(messages.get(0));
            success = true;
            try {
                myInt = sc.nextInt();
                if (myInt < lowerLimit || myInt > upperLimit) throw new CustomException(messages.get(1));
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an integer!");
                success = false;
            } catch (CustomException e) {
                System.out.println(messages.get(1));
                success = false;
            }
            sc.nextLine();
        } while (!success);

        return myInt;

    }
}

