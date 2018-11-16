import java.util.SortedMap;

/**
 * Entity Class for Tutorial, which is a child of Lesson class
 */
public class Tutorial extends Lesson{

    /**
     * Child class extended from Lesson with more specific characteristics
     * @param groupName
     * @param vacancy
     * @param studentList
     */
    public Tutorial(String groupName, int vacancy, SortedMap<Integer, Student> studentList) {
        super(groupName, vacancy, studentList);
    }
}
