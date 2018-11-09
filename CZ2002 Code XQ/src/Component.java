public class Component implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private float weight;
    private int marks;

    public Component(String name, float weight, int marks) {
        this.name = name;
        this.weight = weight;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
