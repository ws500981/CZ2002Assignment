import java.io.*;
import java.util.*;

public class CourseManager{
    private static Scanner sc = new Scanner(System.in);
    private SortedMap<String, Course> courseList;
    private Course course;
    //private String[] componentName;
    //private int[] componentWeight;

    public CourseManager() {
        courseList = new TreeMap<>();
    }

    public void readData(){
        this.courseList = DeserialiseDataCourse();
        System.out.println("Course List:");
        for (String key : courseList.keySet()) {
            System.out.println(courseList.get(key).getName() + ", " + key);
        }
        System.out.println();
    }

    public void writeData(){
        SerialiseDataCourse(this.courseList);
    }


    public void addCourse(String name, String ID, Professor prof,
                          int vacancies, String[] tutNames, String[] labNames,
                          String[] componentNames, float[] componentWeights) {

        ArrayList<Component> components = new ArrayList<>();

        int courseWorkPercent = 0;

        if (componentNames.length > 1){
            for(int i = 1; i < componentWeights.length; i++){
                courseWorkPercent += componentWeights[i];
            }

            if (courseWorkPercent != 100){
                System.out.println("Total coursework Weight not 100%! Course not added!");
                return;
            }
        }

        components.add(new Component(componentNames[0], componentWeights[0], 0));
        System.out.println("Component name 0: " + componentNames[0]);
        System.out.println("Component Weight 0: " + componentWeights[0]);
        System.out.println();

        for(int i=1; i<componentNames.length; i++){
            float decimal_weight = componentWeights[0]/100;
            float weight = (1-decimal_weight)*componentWeights[i];
            System.out.println("component weight: " + weight);

            components.add(new Component(componentNames[i],weight,0));
        }

        Map<String, Tutorial> tutorials = new TreeMap<>();

        for(int i=0; i<tutNames.length; i++) {
            tutorials.put(tutNames[i], new Tutorial(tutNames[i],vacancies/tutNames.length, new TreeMap<>()));
        }

        Map<String, Lab> labs = new TreeMap<>();

        for(int i=0; i<labNames.length; i++) {
            labs.put(labNames[i], new Lab(labNames[i], vacancies / labNames.length, new TreeMap<>()));
        }
        Course course = new Course(name, ID, prof, components, tutorials, labs, vacancies);

        courseList.put(ID, course);
        printAllCourses();
    }

    private void printAllCourses(){
        System.out.println("Course Listing:");
        System.out.println("Course ID \t Course Title \t Professor in Charge");

        for (String key : courseList.keySet()) {
            Course course = courseList.get(key);
            System.out.printf("%s \t %s \t %s \n", course.getCourseID(), course.getName(), course.getProfInCharge().getName());
        }
    }


    public void checkAvailSlots(String courseID) {
        try{
            Course course = findCourse(courseID);
            course.setOriginalVacancy(20);
            System.out.println("Total Course Vacancy: ");
            System.out.println("There are " + course.getVacancy() + "/" + course.getOriginalVacancy() + " vacancies left");
            System.out.println();

            if (course.getTutGroups().size() != 0){
                System.out.println("Tutorial Vacancy: ");
                for (String key : course.getTutGroups().keySet()){
                    Tutorial tutorial = course.getTutGroups().get(key);
                    tutorial.setOriginalVacancy(10);
                    System.out.printf("Tutorial Group %s has %d/%d vacancies left\n", tutorial.getGroupName(), tutorial.getVacancy(), tutorial.getOriginalVacancy());
                }
                System.out.println();
            }

            if (course.getTutGroups().size() != 0){
                System.out.println("Lab Vacancy");
                for (String key : course.getLabGroups().keySet()){
                    Lab lab = course.getLabGroups().get(key);
                    lab.setOriginalVacancy(10);
                    System.out.printf("Lab Group %s has %d/%d vacancies left\n", lab.getGroupName(), lab.getVacancy(), lab.getOriginalVacancy());
                }
            }

        }catch(NullPointerException e){
            System.out.println("Course not found");
        }
    }

    public void printCourseStatistics(String courseID) {
        Course course = findCourse(courseID);
        if(course!=null) {
            System.out.println("Course Statistics for " + courseID + " " + course.getName() + ":");
            int sum = 0;
            SortedMap<Integer, Student> studentList = course.getStudentsList();
            HashMap<String, RegisteredCourse> registeredCourses = new HashMap<>();
            for(int i : studentList.keySet()) {
                Student student = studentList.get(i);
                RegisteredCourse registeredCourse = student.getregisteredCourses().get(courseID);
                int marks = registeredCourse.calculateResults();
                System.out.println(student.getStudentID() + " " + student.getName() + ": " + marks);
                sum += marks;
            }
            int average = sum/studentList.size();
            System.out.println("Course Average: " + average);
        }
    }


    public void printStudentList(String courseID) {
        Course course = findCourse(courseID);
        if (course != null) {
            SortedMap<Integer, Student> students = course.getStudentsList();
            System.out.println("There are " + students.size() + " students in " + course.getName());
            for (int id : students.keySet()) {
                System.out.println(id + " " + students.get(id).getName());
            }
        }
    }

    public void printStudentListLesson(String courseID, String lessonID, int choice){
        Course course = findCourse(courseID);
        Lesson lesson = null;

        if (course != null){

            if (choice == 1){
                lesson = course.getLabGroups().get(lessonID);
            }
            else{
                lesson = course.getTutGroups().get(lessonID);
            }
        }

        System.out.println("Lesson: " + lesson.getGroupName());

        SortedMap<Integer, Student> students = lesson.getStudentList();
        System.out.println("There are " + students.size() + " students in " + lesson.getGroupName());
        for (int id : students.keySet()) {
            System.out.println(id + " " + students.get(id).getName());
        }

    }
    /*
    public void printStudentListLab(String courseID, String labID){
        Course course = findCourse(courseID);
        Lab lab = course.getLabGroups().get(labID);

        if (course != null) {
            SortedMap<Integer, Student> students = lab.getStudentList();
            System.out.println("There are " + students.size() + " students in " + lab.getGroupName());
            for (int id : students.keySet()) {
                System.out.println(id + " " + students.get(id).getName());
            }
        }
    }

    public void printStudentListTut(String courseID, String tutID){
        Course course = findCourse(courseID);
        Tutorial tut = course.getTutGroups().get(tutID);

        if (course != null) {
            SortedMap<Integer, Student> students = tut.getStudentList();
            System.out.println("There are " + students.size() + " students in " + tut.getGroupName());
            for (int id : students.keySet()) {
                System.out.println(id + " " + students.get(id).getName());
            }
        }
    }
*/
    private Course findCourse(String courseID) {
        /*
        System.out.println("Course List:");
        for (String key : courseList.keySet()) {

            System.out.println("key " + key + " name " + courseList.get(key).getName());
        }
        */
        return courseList.get(courseID);

    }

    public SortedMap<String, Course> getCourseList() {
        return courseList;
    }

    public SortedMap<String, Course> DeserialiseDataCourse(){
        SortedMap<String, Course> courseData = null;
        try {
            FileInputStream fileIn = new FileInputStream("data/courses.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            courseData = (SortedMap<String, Course>) in.readObject();
            in.close();
            fileIn.close();
	/*
			System.out.println("size: " + courseData.size());

			for (Course course : courseData){
				System.out.println(course.getName() + " " + course.getCourseID());
			}
			*/

        } catch (IOException i) {
            System.out.println("Course Data not found!");
            courseData = this.courseList;
            /*
            String fileSeparator = System.getProperty("file.separator");
            String relativePath = "/data"+fileSeparator+"courses.ser";
            File file = new File(relativePath);
            */
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Course class not found");
            c.printStackTrace();
        }
        return courseData;
    }



    public static void SerialiseDataCourse(SortedMap<String, Course> courseData){

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data/courses.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(courseData);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data/courses.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


}
