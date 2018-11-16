/**
 * Entity class for component of course
 */
public class Component implements java.io.Serializable{

    /**
     * Name of component
     */
    private String name;

    /**
     * Weight of component
     */
    private float weight;

    /**
     * Mark of component
     */
    private int marks;

    /**
     * Constructor to assign values
     * @param name
     * @param weight
     * @param marks
     */
    public Component(String name, float weight, int marks) {
        this.name = name;
        this.weight = weight;
        this.marks = marks;
    }

    /**
     * Getter for name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for weight
     * @return
     */
    public float getWeight() {
        return this.weight;
    }

    /**
     * Setter for weight
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Getter for marks
     * @return
     */
    public int getMarks() {
        return marks;
    }

    /**
     * Setter for marks
     * @param marks
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }
}
