public interface EntityManagerInterface {
	public void readData();
	public void writeData();
	public void serializeData(Object data);
	public Object deserializeData();
}
