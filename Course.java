/**
 * @author Luye Ge
 * ID# 111857836
 */
public class Course implements Cloneable{

    /**
     * @para create the variable for course
     */
    private String Course_Name;
    private String Department;
    private int Course_Code;
    private byte Course_Section;
    private String Instructor;

    /**
     *
     */
    public Course(){
        Course_Name = null;
        Department = null;
        Course_Code = 0;
        Course_Section = 0;
        Instructor = null;

    }

    /**
     *
     * @param Course_Name
     * @param Department
     * @param Course_Code
     * @param Course_Section
     * @param Instructor
     *
     * the information for course
     */
    public Course(String Course_Name, String Department, int Course_Code,
                 byte Course_Section, String Instructor){
        this.Course_Name = Course_Name;
        this.Department = Department;
        if(Course_Code < 0)
            throw new IllegalArgumentException("Argument " + Course_Code + " is nonPositive");
        this.Course_Code = Course_Code;
        if(Course_Section < 0)
            throw new IllegalArgumentException("Argument " + Course_Section + " is nonPositive");
        this.Course_Section = Course_Section;
        this.Instructor = Instructor;

    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        if(!(other instanceof Course))
            return false;
        Course result = (Course) other;
        if(!(getCourse_Name().compareTo(result.getCourse_Name()) == 0))
            return false;
//        if(!(getDepartment(tempDepartment).compareTo(result.getDepartment(tempDepartment)) == 0))
//            return false;
        if(!(getCourse_Code() == (result.getCourse_Code())))
            return false;
        if(!(getInstructor().compareTo(result.getInstructor()) == 0))
            return false;
        return true;
    }

    /**
     *
     * @return
     */
    public String getCourse_Name() {
        return Course_Name;
    }

    /**
     *
     * @param newCourse_Name
     */
    public void setCourse_Name(String newCourse_Name) {
        this.Course_Name = newCourse_Name;
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return Department;
    }

    /**
     *
     * @param newDepartment
     */
    public void setDepartment(String newDepartment) {
        this.Department = newDepartment;
    }

    /**
     *
     * @return
     */
    public int getCourse_Code(){
        return Course_Code;
    }

    /**
     *
     * @param newCourse_Code
     */
    public void setCourse_Code(int newCourse_Code){
        if(Course_Code < 0)
            throw new IllegalArgumentException("Argument " + Course_Code + " is nonPositive");
        this.Course_Code = newCourse_Code;
    }

    /**
     *
     * @return
     */
    public byte getCourse_Section() {
        return Course_Section;
    }

    /**
     *
     * @param newCourse_Section
     */
    public void setCourse_Section(byte newCourse_Section){
        if(Course_Section < 0)
            throw new IllegalArgumentException("Argument " + Course_Section + " is nonPositive");
        this.Course_Section = newCourse_Section;
    }

    /**
     *
     * @return
     */
    public String getInstructor(){
        return Instructor;
    }

    /**
     *
     * @param newInstructor
     */
    public void setInstructor(String newInstructor){
        this.Instructor = newInstructor;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getCourse_Name() + "                 " + getDepartment() + "   "
                + getCourse_Code()+ "    " + getCourse_Section() + "  " + getInstructor();
    }
}
