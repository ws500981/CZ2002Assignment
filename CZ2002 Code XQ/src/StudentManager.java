import java.io.*;
import java.util.HashMap;

public class StudentManager  implements EntityManagerInterface, IPrintStudentTranscript{

    //map student id against student
    private HashMap<Integer, Student> allStudents;

    public StudentManager() {
        allStudents = new HashMap<>();
    }

    public void readData() {

        this.allStudents = (HashMap<Integer, Student>) deserializeData();
        System.out.println("Student List:");
        for (Integer key : allStudents.keySet()) {
            System.out.println(key + ", " + allStudents.get(key).getName());
        }
        System.out.println();
    }
    public void writeData(){
        serializeData(this.allStudents);
    }

    public void addStudent(String Name, int studentID) {

        try{
            if (allStudents.containsKey(studentID)){
                throw new CustomException("StudentID exists! Please try again!");
            }
            Student student = new Student(Name, studentID);
            allStudents.put(student.getId(), student);

            System.out.println("Student List:");
            for (Integer key : allStudents.keySet()) {

                System.out.println(key + ", " + allStudents.get(key).getName());
            }
        }catch(CustomException e){
            System.out.println(e.getMessage());
        }


    }

    public HashMap<Integer, Student> getAllStudents(){

        return this.allStudents;

    }

    public void enterMarksExam (int studentID, String courseID, int marks){

        allStudents.get(studentID).getregisteredCourses().get(courseID).getComponents().get(0).setMarks(marks);

    }

    public void print(int ID) {
        print(String.valueOf(ID));

    }

    @Override
    public void print(String ID) {
        int studentID = Integer.parseInt(ID);
        Student student = allStudents.get(studentID);
        HashMap<String, RegisteredCourse> courses = student.getregisteredCourses();

        System.out.println("Transcript\n");
        System.out.println("Student ID: " + studentID + "\nName: " + student.getName() + "" + "\n");

        for (String key : courses.keySet()) {
            System.out.println("Subject \t  Results");
            System.out.printf("%7s \t %d \n", courses.get(key).getCourseId(), courses.get(key).calculateResults());
            System.out.println("\nBreakdown:");
            System.out.println("Component \t Weight \t Marks");
            for (Component component : courses.get(key).getComponents()){
                System.out.printf("%10s \t %6s \t %d \n", component.getName(),Math.round(component.getWeight()), component.getMarks());
            }
            System.out.printf("%10s \t %6s \t %d \n", "total", 100, courses.get(key).calculateResults());
        }
    }

	@Override
	public void serializeData(Object data) {
		try {
            FileOutputStream fileOut =
                    new FileOutputStream("data/students.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data/student.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
	}

	@Override
	public Object deserializeData() {
		HashMap<Integer, Student> studentData = null;
        try {
            FileInputStream fileIn = new FileInputStream("data/students.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            studentData = (HashMap<Integer, Student>) in.readObject();
            in.close();
            fileIn.close();
/*
			System.out.println("size: " + studentData.size());

			for(int i = 0; i<studentData.size(); i++){
				System.out.println(studentData.get(i).getName());
			}

			for (Student student : studentData){
				System.out.println(student.getName() + " " + student.getStudentID());
			}
			*/
        } catch (IOException i) {
            System.out.println("Student Data not found!");
            studentData = this.allStudents;

            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        }

        return studentData;
	}

}