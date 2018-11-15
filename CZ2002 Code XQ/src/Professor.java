public class Professor implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String Name;
    private int profId;

    public Professor(int profId, String name) {
        Name = name;
        this.profId = profId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }
}
