/**
 * Interface for reading and writing data from serializable
 */
public interface EntityManagerInterface {

    /**
     * Read data from serialisable that will use deserializeData()
     */
	public void readData();

    /**
     * Write data to serialisable that will use serializeData()
     */
	public void writeData();

    /**
     * Write data to serialisable
     * @param data
     */
	public void serializeData(Object data);

    /**
     * Read data from serialisable
     * @return
     */
	public Object deserializeData();
}
