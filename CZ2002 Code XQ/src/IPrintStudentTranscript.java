/**
 * Child interface pertaining only to printing student transcript
 */
public interface IPrintStudentTranscript extends IPrint {

    /**
     * Overriden method that will be implemented in concrete class
     * @param ID
     */
    @Override
    void print(String ID);
}
