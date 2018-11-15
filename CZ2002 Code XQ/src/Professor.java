public class Professor extends Person implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String Name;
    private int profId;

    public Professor(int profId, String name) {
        super(profId,name);
    }
}
