import java.io.*;
import java.util.*;

/**
 * Control class pertaining to courses
 */
public class CourseManager implements EntityManagerInterface, IPrintCourseStats{
    /**
     * A SortedMap of courses
     */
    private SortedMap<String, Course> courseList;

    /**
     * Instantiation of a course object
     */
    private Course course;

    /**
     * Constructor
     * Instantiation of courseList
     */
    public CourseManager() {
        courseList = new TreeMap<>();
    }

    /**
     * Reads data from serialisable using deserializeData()
     */
    public void readData(){
        this.courseList = (SortedMap<String, Course>) deserializeData();
        System.out.println("Course List:");
        for (String key : courseList.keySet()) {
            System.out.println(key + ", " + courseList.get(key).getName());
        }
        System.out.println();
    }

    /**
     * Writes data into serialisable using serializeData()
     */
    public void writeData(){
        serializeData(this.courseList);
    }

    /**
     * Logic that adds a new course
     * @param name
     * @param ID
     * @param prof
     * @param vacancies
     * @param tutNames
     * @param labNames
     * @param componentNames
     * @param componentWeights
     */
    public void addCourse(String name, String ID, Professor prof,
                          int vacancies, String[] tutNames, String[] labNames,
                          String[] componentNames, float[] componentWeights) {

        try{
            if (courseList.containsKey(ID)){
                throw new CustomException("Course ID exists! Please try again");
            }
            ArrayList<Component> components = new ArrayList<>();

            float courseWorkPercent = 0;

            if(componentNames != null & componentWeights != null) {
                if (componentNames.length > 1) {
                    for (int i = 1; i < componentWeights.length; i++) {
                        courseWorkPercent += componentWeights[i];
                    }

                    if (courseWorkPercent != 100.0) {
                        System.out.println("Total coursework Weight not 100%! Course not added!");
                        return;
                    }
                }

                components.add(new Component(componentNames[0], componentWeights[0], 0));
                System.out.println();

                for (int i = 1; i < componentNames.length; i++) {
                    float decimal_weight = componentWeights[0] / 100;
                    float weight = (1 - decimal_weight) * componentWeights[i];

                    components.add(new Component(componentNames[i], weight, 0));
                }
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
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }


    }

    /**
     * Iterator pattern
     * Prints out all courses
     */
    private void printAllCourses(){
        System.out.println("Course Listing:");
        System.out.println("Course ID \t Course Title \t Professor in Charge");

        for (String key : courseList.keySet()) {
            Course course = courseList.get(key);
            System.out.printf("%10s \t %13s \t %s \n", course.getCourseID(), course.getName(), course.getProfInCharge().getName());
        }
    }

    /**
     * Checks the number of vacancies of a course
     * @param courseID
     */
    public void checkAvailSlots(String courseID) {
        try{
            Course course = findCourse(courseID);
            System.out.println("Total Course Vacancy: ");
            System.out.println("There are " + course.getVacancy() + "/" + course.getOriginalVacancy() + " vacancies left");
            System.out.println();

            if (course.getTutGroups().size() != 0){
                System.out.println("Tutorial Vacancy: ");
                for (String key : course.getTutGroups().keySet()){
                    Tutorial tutorial = course.getTutGroups().get(key);
                    System.out.printf("Tutorial Group %s has %d/%d vacancies left\n", tutorial.getGroupName(), tutorial.getVacancy(), tutorial.getOriginalVacancy());
                }
                System.out.println();
            }

            if (course.getTutGroups().size() != 0){
                System.out.println("Lab Vacancy");
                for (String key : course.getLabGroups().keySet()){
                    Lab lab = course.getLabGroups().get(key);
                    System.out.printf("Lab Group %s has %d/%d vacancies left\n", lab.getGroupName(), lab.getVacancy(), lab.getOriginalVacancy());
                }
            }

        }catch(NullPointerException e){
            System.out.println("Course not found");
        }
    }

    /**
     * Set the marks allocated to exam component of chosen course
     * @param sID
     * @param cID
     * @param marks
     */
    public void enterMarksExam(int sID, String cID, int marks){
        Course course = getCourseList().get(cID);
        RegisteredCourse reg = course.getStudentsList().get(sID).getregisteredCourses().get(cID);
        reg.getComponents().get(0).setMarks(marks);
    }

    /**
     * NEVER USED
     * @param courseID
     * @param sManager
     */
    public void update(String courseID, StudentManager sManager) {
        Course course = findCourse(courseID);
        if (course != null) {
            System.out.println("Course Statistics for " + courseID + " " + course.getName() + ":");
            int sum = 0;
            int marks = 0;
            SortedMap<Integer, Student> studentList = course.getStudentsList();
            HashMap<String, RegisteredCourse> registeredCourses = new HashMap<>();
            for (int i : studentList.keySet()) {
                Student student = studentList.get(i);
                RegisteredCourse registeredCourse = student.getregisteredCourses().get(courseID);
                marks = registeredCourse.calculateResults();
                ArrayList<Component> marks_update = sManager.getAllStudents().get(i).getregisteredCourses().get(courseID).getComponents();
                registeredCourse.setComponents(marks_update);
                System.out.println(student.getId() + " " + student.getName() + ": " + marks);
                sum += marks;
            }
        }
    }

    /**
     * Implemented method from IPrintCourseStats interface
     * Prints out statistics of a chosen course
     * @param courseID
     */
    @Override
    public void print(String courseID) {
        Course course = findCourse(courseID);
        if (course != null) {
            System.out.println("Course Statistics for " + courseID + " " + course.getName() + ":");
            int sum = 0;
            int marks = 0;
            SortedMap<Integer, Student> studentList = course.getStudentsList();
            HashMap<String, RegisteredCourse> registeredCourses = new HashMap<>();

            System.out.println("Course Overall Statistics: ");

            for (int i : studentList.keySet()) {
                Student student = studentList.get(i);
                RegisteredCourse registeredCourse = student.getregisteredCourses().get(courseID);
                marks = registeredCourse.calculateResults();
                System.out.println(student.getId() + " " + student.getName() + ": " + marks);
                sum += marks;
            }
            int average = sum / studentList.size();
            System.out.println("Course Average: " + average);
            System.out.println();
            System.out.println("Course Exam Statistics");
            System.out.println();
            int sum_exam = 0;

            for (int i : studentList.keySet()) {
                Student student = studentList.get(i);
                RegisteredCourse registeredCourse = student.getregisteredCourses().get(courseID);
                marks = registeredCourse.getComponents().get(0).getMarks();
                System.out.println(student.getId() + " " + student.getName() + ": " + marks);
                sum_exam += marks;
            }
            int average_exam = sum_exam / studentList.size();
            System.out.println("Course Average: " + average_exam);
            System.out.println();
            System.out.println("Course CourseWork Statistics");
            System.out.println();


            for (int i = 1; i < course.getComponents().size(); i++) {
                int sum_coursework = 0;
                System.out.printf("Course %s Statistics", course.getComponents().get(i).getName());
                System.out.println();
                for (int j : studentList.keySet()) {
                    Student student = studentList.get(j);
                    RegisteredCourse registeredCourse = student.getregisteredCourses().get(courseID);
                    marks = registeredCourse.getComponents().get(i).getMarks();
                    System.out.println(student.getId() + " " + student.getName() + ": " + marks);
                    sum_coursework += marks;
                }
                int average_course = sum_coursework / studentList.size();
                System.out.println("Course Average: " + average_course);
                System.out.println();
            }

        }
    }

    /**
     * Print a list of students in chosen course
     * @param courseID
     */
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

    /**
     * Prints list of students in a chosen lesson (tutorial/lab)
     * @param courseID
     * @param lessonID
     * @param choice
     */
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

    /**
     * Private method that returns Course object from courseID
     * @param courseID
     * @return
     */
    private Course findCourse(String courseID) {
        return courseList.get(courseID);

    }

    /**
     * Gets the SortedMap of courseList
     * @return
     */
    public SortedMap<String, Course> getCourseList() {
        return courseList;
    }

    /**
     * Writes into serialisable
     * @param data
     */
	@Override
	public void serializeData(Object data) {
		try {
            FileOutputStream fileOut =
                    new FileOutputStream("data/courses.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data/courses.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
	}

    /**
     * Read from serialisable
     * @return
     */
	@Override
	public Object deserializeData() {
		SortedMap<String, Course> courseData = null;
        try {
            FileInputStream fileIn = new FileInputStream("data/courses.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            courseData = (SortedMap<String, Course>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {
            System.out.println("Course Data not found!");
            courseData = this.courseList;
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Course class not found");
            c.printStackTrace();
        }
        return courseData;
	}
}
