public class RegisteredCourse extends Student {
    private Component[] courseworkMark;
    private int examMark;
    private int totalMark;
    private int courseId;
    private int tutGroup;
    private int labGroup;

    public int getExamMark() {
        return examMark;
    }

    public void setExamMark(int examMark) {
        this.examMark = examMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public Component[] getCourseworkMark() {
        return courseworkMark;
    }

    public void setCourseworkMark(Component[] courseworkMark) {
        this.courseworkMark = courseworkMark;
    }

    public int calculateTotalMark(){
        //plcaeholder
        return 0;
    }
}
