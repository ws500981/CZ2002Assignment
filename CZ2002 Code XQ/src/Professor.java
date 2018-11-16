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
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to assign values to Name and profId
     * @param profId
     * @param name
     */
    public Professor(int profId, String name) {
        super(profId,name);
    }
}
