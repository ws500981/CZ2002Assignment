/**
 * Boundary class used only for viewing courses and its components
 */
public class ViewCourseMenuUI {

    /**
     * UI that displays and interacts from menu to view course data
     * @param cManager
     */
    public static void viewCourseMenu(CourseManager cManager) {
        String cID = ScannerManager.stringInput("Please enter CourseID: ");
        if (!cManager.getCourseList().containsKey(cID)) {
            System.out.println("Course ID not found.");
            return;
        }

        int choice = 0;
        String message = "Viewing CourseID " + cID + ": " + cManager.getCourseList().get(cID).getName() + "\n"
        		+ "1. Check available slots\n"
                + "2. Print course statistics\n"
                + "3. Print student list\n"
                + "4. Exit to main menu\n";

        do {
        	choice = ScannerManager.testIntInput(message);

            switch (choice) {
                case 1:
                    cManager.checkAvailSlots(cID);
                    break;
                case 2:
                    cManager.print(cID);
                    break;
                case 3:
                    printStudentList(cManager, cID);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }

        } while (choice != 4);
    }

    /**
     * Method that prints list of students pertaining to the course and its components
     * @param cManager
     * @param cID
     */
    private static void printStudentList(CourseManager cManager, String cID) {

        String lessonID;
        int choice = 0;
        String message = "Printing student list for CourseID " + cID + ": " + cManager.getCourseList().get(cID).getName() + "\n"
        		+ "1. Print student list for whole course\n"
                + "2. Print student list for lecture\n"
                + "3. Print student list for tutorial\n"
                + "4. Print student list for lab\n"
                + "5. Exit to main menu\n";

        do {

            choice = ScannerManager.testIntInput(message);

            switch (choice) {
                case 1:
                case 2:
                    cManager.printStudentList(cID);
                    break;
                case 3:
                    System.out.println("Tutorial IDs available: ");

                    for (String key : cManager.getCourseList().get(cID).getTutGroups().keySet()) {
                        System.out.println(cManager.getCourseList().get(cID).getTutGroups().get(key).getGroupName());
                    }
                    System.out.println();

                    lessonID = ScannerManager.stringInput("Enter Tutorial ID to print");

                    try {
                        cManager.printStudentListLesson(cID, lessonID, 0);
                    }
                    catch (NullPointerException e) {
                        System.out.println("Tutorial ID invalid!");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Lab IDs available: ");

                    for (String key : cManager.getCourseList().get(cID).getLabGroups().keySet()) {
                        System.out.println(cManager.getCourseList().get(cID).getLabGroups().get(key).getGroupName());
                    }
                    System.out.println();

                    lessonID = ScannerManager.stringInput("Enter Lab ID to print");

                    try {
                        cManager.printStudentListLesson(cID, lessonID, 1);
                    }
                    catch (NullPointerException e) {
                        System.out.println("Lab ID invalid!");
                        break;
                    }
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }

        } while (choice != 5);
    }
}
