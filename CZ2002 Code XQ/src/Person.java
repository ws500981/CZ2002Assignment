import java.io.Serializable;

public class Person implements Serializable {

    protected int Id;
    protected String Name;

    public Person(int id, String name) {
        Name = name;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void Id(int id) {
        Id = id;
    }

}
