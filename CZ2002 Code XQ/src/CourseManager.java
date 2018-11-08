import java.util.*;

public class CourseManager{
    private static Scanner sc = new Scanner(System.in);
    private SortedMap<String, Course> courseList;
    private Course course;
    private String[] componentName;
    private int[] componentWeight;

    public CourseManager() {
        courseList = new TreeMap<>();
    }

    public void addCourse(String name, String ID, String prof,
                          int vacancies, String[] tutNames, String[] labNames,
                          String[] componentNames, int[] componentWeights) {
        ArrayList<Component> components = new ArrayList<>();
        for(int i=0; i<componentName.length; i++) components.add(new Component(componentNames[i],componentWeights[i],0));
        Map<String, Tutorial> tutorials = new TreeMap<>();
        for(int i=0; i<tutNames.length; i++) {
            tutorials.put(tutNames[i], new Tutorial(tutNames[i],vacancies/tutNames.length, null));
        }
        Map<String, Lab> labs = new TreeMap<>();
        for(int i=0; i<labNames.length; i++) {
            labs.put(labNames[i], new Lab(labNames[i], vacancies/labNames.length, null ));
        }
        Course course = new Course(name, ID, prof, null, components, tutorials, labs, vacancies);
    }


    public void checkAvailSlots(String courseID) {
        Course course = findCourse(courseID);
        if(course!=null) System.out.println("There are " + course.getVacancy() + " vacancies left");
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
                RegisteredCourse registeredCourse = student.getRegisteredCourses().get(courseID);
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
                System.out.println(id + " " + students.get(id));
            }
        }
    }

    private Course findCourse(String courseID) {
        for(String str : this.courseList.keySet()) {
            if(str==courseID) return this.courseList.get(str);
        }
        return null;
    }

    public SortedMap<String, Course> getCourseList() {
        return courseList;
    }


}
