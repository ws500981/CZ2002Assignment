import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerManager {

    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> createMessages(String message1, String message2) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        return messages;
    }

    public static String stringInput(String message) {
    	//default string input
        System.out.println(message);
        return sc.nextLine();
    }
    
    public static int testIntInput(String message){
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
        } while(!success);

        return myInt;

    }
    
    public static int testIntInput(ArrayList<String> messages, int lowerLimit){
    	//customizable int input that contains upper and lower limit and custom message. required to createMessages first
    	
        boolean success;
        int myInt = -1;
        
        do {
            System.out.println(messages.get(0));
            success = true;
            try {
                myInt = sc.nextInt();
                if(myInt <= lowerLimit) throw new CustomException(messages.get(1));
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an integer!");
                success = false;
            } catch (CustomException e) {
                System.out.println(messages.get(1));
                success = false;
            }
            sc.nextLine();
        } while(!success);

        return myInt;

    }

    public static int testIntInput(ArrayList<String> messages, int lowerLimit, int upperLimit){
    	//customizable int input that contains upper and lower limit and custom message. required to createMessages first
    	
        boolean success;
        int myInt = -1;
        
        do {
            System.out.println(messages.get(0));
            success = true;
            try {
                myInt = sc.nextInt();
                if(myInt <= lowerLimit || myInt >= upperLimit) throw new CustomException(messages.get(1));
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an integer!");
                success = false;
            } catch (CustomException e) {
                System.out.println(messages.get(1));
                success = false;
            }
            sc.nextLine();
        } while(!success);

        return myInt;

    }
    

}
