/**
 * Child interface pertaining only to printing of course statistics
 */
public interface IPrintCourseStats extends IPrint {

    /**
     * Overriden method that will be implemented in concrete class
     * @param ID
     */
    @Override
    void print(String ID);
}
