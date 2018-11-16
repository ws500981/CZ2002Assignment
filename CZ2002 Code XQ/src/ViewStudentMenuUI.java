/**
 * Boundary class used only for viewing students
 */

public class ViewStudentMenuUI {

    /**
     * UI that displays and interacts from menu to view student data
     * @param sManager
     * @param cManager
     */
    public static void viewStudentMenu(StudentManager sManager, CourseManager cManager) {
        int sID = ScannerManager.testIntInput(ScannerManager.createMessages("Please enter StudentID: ", "Please enter a positive integer"), 0);
        if (!sManager.getAllStudents().containsKey(sID)) {
            System.out.println("Student ID not found.");
            return;
        }
        
        int choice = 0;
        String message = "Viewing StudentID " + sID + ": " + sManager.getAllStudents().get(sID).getName() + "\n"
        		+ "1. Enter coursework marks\n"
                + "2. Enter exam marks\n"
                + "3. Print course list\n"
                + "4. Exit to main menu\n";
        String cID;
        int marks;
        RegisteredCourse registeredCourse = null;
        Student student = null;
        
        do {
            choice = ScannerManager.testIntInput(message);

            switch (choice) {
                case 1:
                	//what if course code doesnt exist
                    cID = ScannerManager.stringInput("Please enter the course code: ");
                    try {
                    	registeredCourse = sManager.getAllStudents().get(sID).getregisteredCourses().get(cID);
                        student = cManager.getCourseList().get(cID).getStudentsList().get(sID);
                    }
                    catch (NullPointerException e) {
                    	System.out.println("Course code does not exist\n");
                    	break;
                    }



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
                        marks = ScannerManager.testIntInput(ScannerManager.createMessages("Please enter your marks for " + component.getName(), "Please enter a valid mark"), 0, 100);
                        component.setMarks(marks);

                        student.getregisteredCourses().get(cID).getComponents().get(i).setMarks(marks);

                    }

                    System.out.println("Coursework marks entered");
                    break;
                case 2:
                    cID = ScannerManager.stringInput("Please enter the exam's course code: ");
                    if (!(sManager.getAllStudents().get(sID).getregisteredCourses().containsKey(cID))){
                        System.out.println("Invalid course code entered!");
                        break;
                    }
                    marks = ScannerManager.testIntInput(ScannerManager.createMessages("Please enter your marks: ", "Please enter a valid mark"), 0, 100);
                    sManager.enterMarksExam(sID, cID, marks);
                    cManager.enterMarksExam(sID, cID, marks);
                    System.out.println("Exam marks entered");
                    break;
                case 3:
                    sManager.print(sID);
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
