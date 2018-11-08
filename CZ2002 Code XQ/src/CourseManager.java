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
                          int vacancies, int numTutGroups, int numLabGroups, String[] tutNames, String[] labNames,
                            String[] componentNames, int[] componentWeights) {
        ArrayList<Component> components = new ArrayList<>();
        for(int i=0; i<componentName.length; i++) components.add(new Component(componentNames[i],componentWeights[i]));
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
        System.out.println("There are " + course.getVacancy() + " vacancies left");
    }

    public void printCourseStatistics(String courseID) {

    }

    public void getResults(SortedMap<Integer,StudentInCourse> students) {

    }

    public void printStudentList(String courseID) {
        Course course = findCourse(courseID);
        SortedMap<Integer, StudentInCourse> students = course.getStudentsInCourse();
        System.out.println("There are " + students.size() + " students in " + course.getName());
        for(int id : students.keySet()) {
            System.out.println(id + " " + students.get(id));
        }
    }

    private Course findCourse(String courseID) {
        for(String str : this.courseList.keySet()) {
            if(str==courseID) return this.courseList.get(str);
        }
        return null;
    }


}
