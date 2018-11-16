import java.io.*;
import java.util.HashMap;

/**
 * Control class pertaining to professor class
 */
public class ProfessorManager implements EntityManagerInterface{

    /**
     * HashMap containing keys of professors' ID and values of professor objects
     */
    private HashMap<Integer, Professor> allProfessors;

    /**
     * Constructor to initialise HashMap
     */
    public ProfessorManager() {
        this.allProfessors = new HashMap<>();
    }

    /**
     * Add professor to list of professors
     * @param Id
     * @param Name
     */
    public void addProf(int Id, String Name){
        Professor prof = new Professor(Id, Name);
        allProfessors.put(Id, prof);
        System.out.println("Student List:");
        for (Integer key : allProfessors.keySet()) {

            System.out.println(key + ", " + allProfessors.get(key).getName());
        }
    }

    /**
     * Read data from serialisable using deserializeData()
     */
    public void readData() {
        this.allProfessors = (HashMap<Integer, Professor>) deserializeData();
        System.out.println("Professor List:");
        for (int key : allProfessors.keySet()) {
            System.out.println(key + ", " + allProfessors.get(key).getName());
        }

    }

    /**
     * Getter for data from HashMap of professors
     * @return
     */
    public HashMap<Integer, Professor> getAllProfessors() {
        return allProfessors;
    }

    /**
     * Write data to serialisable using serializeData()
     */
    public void writeData(){
        serializeData(this.allProfessors);
    }

    /**
     * Logic to serialize data
     * @param data
     */
	@Override
	public void serializeData(Object data) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data/professors.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data/professors.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
	}

    /**
     * Logic to deserialize data
     * @return
     */
	@Override
	public Object deserializeData() {
		HashMap<Integer, Professor> professorData = null;
        try {
            FileInputStream fileIn = new FileInputStream("data/professors.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            professorData = (HashMap<Integer, Professor>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("Professor Data not found!");
            professorData = this.allProfessors;

            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Professor class not found");
            c.printStackTrace();
        }

        return professorData;
	}
}
