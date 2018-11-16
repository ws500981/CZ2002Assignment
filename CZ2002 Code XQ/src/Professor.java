/**
 * Entity class for professor, child of person class
 */
public class Professor extends Person implements java.io.Serializable{

    /**
     * Professor's Name
     */
    private String Name;

    /**
     * Professor's ID
     */
    private int profId;

    /**
     * Constructor to assign values to Name and profId
     * @param profId
     * @param name
     */
    public Professor(int profId, String name) {
        super(profId,name);
    }
}
