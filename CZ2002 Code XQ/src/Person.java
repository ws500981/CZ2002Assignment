import java.io.Serializable;

public abstract class Person implements Serializable {

    private int Id;
    private String Name;

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
