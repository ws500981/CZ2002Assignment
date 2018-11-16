import java.util.SortedMap;

/**
 * Entity Class for Lab, which is a child of Lesson class
 */
public class Lab extends Lesson{

    /**
     * Child class extended from Lesson with more specific characteristics
     * @param groupName
     * @param vacancy
     * @param studentList
     */
    public Lab(String groupName, int vacancy, SortedMap<Integer, Student> studentList) {
        super(groupName, vacancy, studentList);
    }
}
