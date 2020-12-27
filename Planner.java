/**
 * @author Luye Ge
 * ID# 111857836
 */
/**
 *
 */
public class Planner implements Cloneable {
    private final int MAX_COURSE = 50;
    private int sizeOfCourse = 0;
    private Course[] courseList = new Course[MAX_COURSE];
    private Course[] backupCourseList = new Course[MAX_COURSE];
    //private Course[] tempCourseList = new Course[MAX_COURSE+1];
    /*
    Constructs an instance of the Planner with no Course objects in it.
Postcondition:
This Planner has been initialized to an empty list of Courses.

     */

    public Planner() {
    }

    /**
     * @return return the copy from the original course list
     */
    public Object clone() {
        backupCourseList = courseList.clone();
        //return backupCourseList;
        return backupCourseList;
    }

    /**
     * Reverts the current Planner to the backed up copy
     */
    public void revertBackup() {
        courseList = backupCourseList;
    }

/*    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Planner))
            return false;
        Planner result = (Planner) other;
        if (!(size() == result.size()))
            return false;
        for(int i = 0; i < result.size(); i++){
            if()
        }
        return true;
    }*/

    /**
     * @return the size after adding course
     * Determines the number of courses in the Planner.
     */
    public int size() {
        return sizeOfCourse;
    }

    /**
     * @param course
     * @param position
     * Adds a new course into the list.
     */
    public void addCourse(Course course, int position) {
        position -= 1;
        if (courseList[position] == null) {
            courseList[position] = course;
            sizeOfCourse++;
        }
        /* personal note
        add(a, 1)
        [a]
        add(b, 2)
        [a, b]
        add(c, 2)
        original: [a, c, b]
        copy: [a, d, c, b]
        if(position = 3)
        for(int i = 0; i < 3; i++){
        copy[i] = original[i]
        }
        for(int i = 4; i < sizeOfList; i++){
            copy[i] = original[i-1]

        add(d,
                [a,d,c,b]
     */
        // make a copy for original course list
        // if current index has a course
        // if yes,  insert the current course to this index, move everything after + 1

        else {
            Course[] tempCourseList = courseList;
            if (sizeOfCourse == MAX_COURSE) {
                System.out.println("There is no more room for this course!");
            }

            // the position has course already

            if (courseList[position] != null) {

                for (int i = position; i < MAX_COURSE; i++) {
                    if (courseList[i + 1] != null) {
                        courseList[i + 1] = tempCourseList[i];
                    } else {
                        courseList[i + 1] = tempCourseList[i];
                        break;
                    }
                }
                courseList[position] = course;
                sizeOfCourse++;
            }
        }
    }

    /**
     * @param position
     * Removes the Course at the given position.
     */
    public void removeCourse(int position) {
        // make a copy
        position--;
        Course[] tempList = courseList;
        if (courseList[position] != null) {
            courseList[position] = null;
            sizeOfCourse--;
            for (int i = position; i < MAX_COURSE - 1; i++) {
                courseList[i] = tempList[i + 1];
            }
        }
        /*
            [a, b, c, null, ....]
         */

    }

    /**
     * @param position
     * @return the course which the user want to look at
     */
    public Course getCourse(int position) {
        return courseList[position - 1];
    }

    /**
     * @param planner
     * @param department
     * Displays courses that match the given department code.
     */
    public static void filter(Planner planner, String department) {
        Course temp;
        for (int i = 0; i < planner.courseList.length; i++) {
            for (int j = 0; j < planner.courseList.length - 1; j++) {
                if (!(planner.courseList[i].getDepartment().equals(department))) {
                    temp = planner.courseList[i];
                    planner.courseList[i] = planner.courseList[i + 1];
                    planner.courseList[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < planner.courseList.length; i++) {
            if (planner.courseList[i].getDepartment().equals(department))
                System.out.println(planner.courseList[i]);
        }
    }

    /**
     * Displays all courses in the list.
     * P for menuOP
     */
    public void printAllCourse() {
        for (int i = 0; i < courseList.length; i++) {
            if (courseList[i] != null) {
                System.out.println("No." + " Course Name        " + " Department " +
                        " Code " + " Section " + " Instructor" +
                        "\n----------------------------------------------------------------------------------" +
                        "\n" + (i + 1) + "   " + courseList[i].toString());
            }
        }
    }

    /**
     *
     * @return the format of course
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Displays all the courses from the backed-up list.
     */
    public void printBackupAllCourse() {
        for (int i = 0; i < backupCourseList.length; i++) {
            if (backupCourseList[i] != null) {
                System.out.println((i + 1) + " " + backupCourseList[i].toString());
            }
        }
    }

    /**
     * @param name
     * @param code
     * @param section
     * @param instructor
     * Determines whether the course with the given attributes is in the list.
     */
    public void lookForCourse(String name, String department, int code, int section, String instructor) {
        int countLook = 0;
        for (int i = 0; i < MAX_COURSE; i++) {
            if ((courseList[i].getCourse_Name().toUpperCase().equals(name))) {
                countLook++;
            }
            if (courseList[i].getDepartment().toUpperCase().equals(department)) {
                countLook++;
            }
            if (courseList[i].getCourse_Code() == code) {
                countLook++;
            }
            if (courseList[i].getCourse_Section() == section) {
                countLook++;
            }
            if (courseList[i].getInstructor().toUpperCase().equals(instructor)) {
                countLook++;
            }
            if (countLook == 5) {
                System.out.println(department + " " +
                        code + ".0" + section +
                        " is found in the planner at position " + i + ".");
            }
        }
        if(countLook == 0){
            System.out.println(department + " " +
                        code + ".0" + section +
                        " is not found in any position of this planner.");
        }
    }

}

