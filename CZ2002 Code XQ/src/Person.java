import java.io.Serializable;

/**
 * Entity Class for Person
 */
public abstract class Person implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Student's ID
     */
    private int Id;

    /**
     * Student's first and last name
     */
    private String Name;

    /**
     * Constructor to assign values to Id and Name
     * @param id
     * @param name
     */
    public Person(int id, String name) {
        Name = name;
        Id = id;
    }

    /**
     * Getter for Name
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * Setter for Name
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Getter for Id
     * @return
     */
    public int getId() {
        return Id;
    }

    /**
     * Setter for Id
     * @param id
     */
    public void Id(int id) {
        Id = id;
    }

}
