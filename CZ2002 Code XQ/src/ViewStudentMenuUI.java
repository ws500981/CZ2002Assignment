import java.util.Scanner;

public class ViewStudentMenuUI {

    private static Scanner sc = new Scanner(System.in);

    public ViewStudentMenuUI() {
    }

    public static void viewStudentMenu(StudentManager sManager, CourseManager cManager) {
        System.out.print("Please enter StudentID: ");
        int sID = sc.nextInt();
        if (!sManager.getAllStudents().containsKey(sID)) {
            System.out.println("Student ID not found.");
            return;
        }
        int choice = 0;
        do {
            System.out.printf("\nViewing StudentID %d: %s.\n"
                    + "1. Enter coursework marks\n"
                    + "2. Enter exam marks\n"
                    + "3. Print course list\n"
                    + "4. Exit to main menu", sID, sManager.getAllStudents().get(sID).getName());
            System.out.println();

            String cID;
            int marks;

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please enter the course code: ");
                    cID = sc.next();
                    RegisteredCourse registeredCourse = sManager.getAllStudents().get(sID).getregisteredCourses().get(cID);
                    Student student = cManager.getCourseList().get(cID).getStudentsList().get(sID);


                    if (!(sManager.getAllStudents().get(sID).getregisteredCourses().containsKey(cID))){
                        System.out.println("Student not registered to course!");
                        break;
                    }

                    System.out.printf("There are %d components: \n", registeredCourse.getComponents().size()-1);


                    for (int i = 1; i < registeredCourse.getComponents().size(); i++) {
                        Component component = registeredCourse.getComponents().get(i);
                        float weight_display = component.getWeight() / (1 - (registeredCourse.getComponents().get(0).getWeight() / 100));
                        System.out.printf("Name: %s, Weight: %.0f\n", component.getName(), weight_display);
                    }
                    System.out.println();

                    for (int i = 1; i < registeredCourse.getComponents().size(); i++){
                        Component component = registeredCourse.getComponents().get(i);
                        System.out.printf("Please enter your marks for %s\n", component.getName());
                        marks = sc.nextInt();
                        component.setMarks(marks);

                        student.getregisteredCourses().get(cID).getComponents().get(i).setMarks(marks);

                    }

                    System.out.println("Coursework marks entered");
                    break;
                case 2:
                    System.out.println("Please enter the exam's course code: ");
                    cID = sc.next();
                    if (!(sManager.getAllStudents().get(sID).getregisteredCourses().containsKey(cID))){
                        System.out.println("Student not registered to course!");
                        break;
                    }
                    System.out.println("Please enter your marks: ");
                    marks = sc.nextInt();
                    sManager.enterMarksExam(sID, cID, marks);
                    cManager.enterMarksExam(sID, cID, marks);
                    System.out.println("Exam marks entered");
                    break;
                case 3:
                    sManager.printStudentTranscript(sID);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }

        } while (choice != 4);
    }


}
