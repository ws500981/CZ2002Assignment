import java.io.*;
import java.util.HashMap;

public class ProfessorManager {
    private HashMap<Integer, Professor> allProfessors;

    public ProfessorManager() {
        this.allProfessors = new HashMap<>();
    }

    public void addProf(int Id, String Name){
        Professor prof = new Professor(Id, Name);
        allProfessors.put(Id, prof);
    }

    public void readData() {

        this.allProfessors = DeserialiseDataProfessor();
        System.out.println("Professor List:");
        for (int key : allProfessors.keySet()) {
            System.out.println(allProfessors.get(key).getName() + ", " + key);
        }

    }

    public HashMap<Integer, Professor> getAllProfessors() {
        return allProfessors;
    }

    public void writeData(){
        SerialiseDataProfessor(this.allProfessors);
    }

    private static void SerialiseDataProfessor(HashMap<Integer, Professor> professorData){

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data/professors.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(professorData);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data/professors.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private HashMap<Integer, Professor> DeserialiseDataProfessor(){
        HashMap<Integer, Professor> professorData = null;
        try {
            FileInputStream fileIn = new FileInputStream("data/professors.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            professorData = (HashMap<Integer, Professor>) in.readObject();
            in.close();
            fileIn.close();
/*
			System.out.println("size: " + professorData.size());

			for(int i = 0; i<professorData.size(); i++){
				System.out.println(professorData.get(i).getName());
			}

			for (Professor professor : professorData){
				System.out.println(professor.getName() + " " + professor.getProfessorID());
			}
			*/
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
