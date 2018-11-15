import java.util.Scanner;

public class ViewCourseMenuUI {

    private static Scanner sc = new Scanner(System.in);

    public ViewCourseMenuUI() {
    }

    public static void viewCourseMenu(CourseManager cManager) {
        System.out.print("Please enter CourseID: ");
        String cID = (String) sc.nextLine();
        if (!cManager.getCourseList().containsKey(cID)) {
            System.out.println("Course ID not found.");
            return;
        }

        int choice = 0;

        do {
            System.out.printf("\nViewing CourseID %s: %s.\n"
                    + "1. Check available slots\n"
                    + "2. Print course statistics\n"
                    + "3. Print student list\n"
                    + "4. Exit to main menu\n", cID, cManager.getCourseList().get(cID).getName());

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    cManager.checkAvailSlots(cID);
                    break;
                case 2:
                    cManager.printCourseStatistics(cID);
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

    private static void printStudentList(CourseManager cManager, String cID) {

        int choice = 0;
        String lessonID;

        do {
            System.out.printf("\nPrinting student list for CourseID %s: %s.\n"
                    + "1. Print student list for whole course\n"
                    + "2. Print student list for lecture\n"
                    + "3. Print student list for tutorial\n"
                    + "4. Print student list for lab\n"
                    + "5. Exit to main menu\n", cID, cManager.getCourseList().get(cID).getName());

            choice = sc.nextInt();
            sc.nextLine();

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

                    System.out.println("Enter Tutorial ID to print");
                    lessonID = sc.nextLine();

                    cManager.printStudentListLesson(cID, lessonID, 0);
                    break;
                case 4:
                    System.out.println("Lab IDs available: ");

                    for (String key : cManager.getCourseList().get(cID).getLabGroups().keySet()) {
                        System.out.println(cManager.getCourseList().get(cID).getLabGroups().get(key).getGroupName());
                    }
                    System.out.println();

                    System.out.println("Enter Lab ID to print");
                    lessonID = sc.nextLine();

                    cManager.printStudentListLesson(cID, lessonID, 1);
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }

        } while (choice != 5);
    }


}
