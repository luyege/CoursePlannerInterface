/**
 * @author Luye Ge
 * ID# 111857836
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class PlannerManager {
    /**
     *
     * @param args
     * @throws CloneNotSupportedException
     * @throws IndexOutOfBoundsException
     * @throws InputMismatchException
     */
        public static void main(String[] args) throws CloneNotSupportedException {
            //final int[] sizeOfList = new int[50];

            Planner myPlanner = new Planner();
            Planner backupCopy = new Planner();
            Course myCourse = new Course();
            int[] number = {0,1,2,3,4,5,6,7,8,9};
            String selection = "";
            String[] menuOP = {"A", "G","R","P","F","L","S","B","PB","RB","Q"};
            System.out.println("" +
                    "(A)  Add Course " +
                    "\n(G)  Get Course " +
                    "\n(R)  Remove Course " +
                    "\n(P)  Print Course in Planner" +
                    "\n(F)  Filter by Department Code " +
                    "\n(L)  Look For Course " +
                    "\n(S)  Size " +
                    "\n(B)  Backup" +
                    "\n(PB) Print Courses in Backup " +
                    "\n(RB) Revert to Backup " + // replace the current planner with the back up one
                    "\n(Q)  Quit" +
                    "\n\nEnter a selection: ");
            Scanner input = new Scanner(System.in);
            selection = input.next();
            /**
             * let the user input the option
             */
            while (!(selection.toUpperCase().equals("Q"))) {

                if (selection.toUpperCase().equals("A")) {
                        String tempCourseName;
                        String tempDepartment;
                        int tempCourseCode = 0;
                        byte tempCourseSection = 0;
                        String tempInstructor;
                        int tempPosition = 0;
                        System.out.println("Enter course name: ");
                        tempCourseName = input.next();
                        System.out.println("Enter department: ");
                        tempDepartment = input.next().toUpperCase();
                        System.out.println("Enter course code: ");
                        try {
                            tempCourseCode = input.nextInt();


                        } catch (IndexOutOfBoundsException errCourseCode) {
                            input.nextInt();
                            System.out.println("The course code needs a correct type!");
                        }
                        System.out.println("Enter course section: ");
                        try {
                            tempCourseSection = input.nextByte();
                            if (tempCourseSection <= 0) {
                                System.out.println(menuOP[menuOP.length + 1]);
                            }
                        }
                        //-----------------------------------------------------------------------
                        catch (InputMismatchException IME) {
                            input.nextByte();
                            System.out.println("The course section needs a correct type!");

                        }
                        //----------------------------------------------------------------------
                        catch (IndexOutOfBoundsException errCourseSection) {
                            input.nextByte();
                            System.out.println("The course section needs a correct type!");
                        }


                        System.out.println("Enter instructor: ");
                        tempInstructor = input.next().toUpperCase();
                        System.out.println("Enter position: ");
                        while (!(((0 < tempPosition)) && (tempPosition < 3))) {

                            tempPosition = input.nextInt();
                            if (tempPosition > 0 && tempPosition < 3) {
                                break;
                            }
                            System.out.println("The position needs a correct type!" +
                                    " \nEnter position: ");
                        }


                        Course c = new Course();
                        c.setCourse_Name(tempCourseName);
                        c.setDepartment(tempDepartment);
                        c.setCourse_Code(tempCourseCode);
                        c.setCourse_Section(tempCourseSection);
                        c.setInstructor(tempInstructor);
                        myPlanner.addCourse(c, tempPosition);

                        System.out.println(c.getDepartment() + " " +
                                c.getCourse_Code() + ".0" + c.getCourse_Section() +
                                " successfully added to planner.");

                } else if (selection.toUpperCase().equals("G")) {
                    System.out.println("Which position's course do you want?" +
                            "\n Enter a position: ");
                    int positionOfCourse = input.nextInt();
                    System.out.println(myPlanner.getCourse(positionOfCourse));
                    System.out.println("Enter a selection: ");
                    selection = input.next();

                } else if (selection.toUpperCase().equals("R")) {
                    System.out.println("Enter a position to remove the course: ");
                    int positionOfRemove = input.nextInt();
                    myPlanner.removeCourse(positionOfRemove);
                    System.out.println("Enter a selection: ");
                    selection = input.next();
                } else if (selection.toUpperCase().equals("P")) {
                    if(myPlanner.size() == 0){
                        System.out.println("This Planner object has not been instantiated");
                    }else
                        myPlanner.printAllCourse();

                    System.out.println("Enter a selection: ");
                    selection = input.next();
                } else if (selection.toUpperCase().equals("F")){
                    if(myPlanner.size() == 0){
                        System.out.println("This Planner object has not been instantiated");
                    }else
                        System.out.println("Enter department code: ");
                        String filterDepartment = input.next().toUpperCase();
                        Planner.filter(myPlanner, filterDepartment);
                    System.out.println("Enter a selection: ");
                    selection = input.next();
                }else if (selection.toUpperCase().equals("L")){
                    System.out.println("Enter Course Name: ");
                    String lookName = input.next();
                    System.out.println("Enter department: ");
                    String lookDepartment = input.next();
                    System.out.println("Enter course code: ");
                    int lookCode = input.nextInt();
                    System.out.println("Enter course Section: ");
                    int lookSection = input.nextInt();
                    System.out.println("Enter instructor: ");
                    String lookInstructor = input.next();
                    myPlanner.lookForCourse(lookName, lookDepartment, lookCode, lookSection, lookInstructor);

                    System.out.println("Enter a selection: ");
                    selection = input.next();
                }else if (selection.toUpperCase().equals("S")){
                    System.out.println("There are " + myPlanner.size() + " courses in the planner.");
                    System.out.println("Enter a selection: ");
                    selection = input.next();
                }else if (selection.toUpperCase().equals("B")){
                    //backupCopy = (Planner) myPlanner.clone();
                    myPlanner.clone();
                    System.out.println("Created a backup of the current planner");
                    System.out.println("Enter a selection: ");
                    selection = input.next();
                }else if (selection.toUpperCase().equals("PB")){

                    myPlanner.printBackupAllCourse();
                    System.out.println("Print Courses in Backup");
                    System.out.println("Enter a selection: ");
                    selection = input.next();
                }else if (selection.toUpperCase().equals("RB")){
                    myPlanner.revertBackup();
                    System.out.println("Planner successfully reverted to the backup copy.");
                    System.out.println("Enter a selection: ");
                    selection = input.next();
                }else {
                    System.out.println("Enter a selection: ");
                    selection = input.next();

                }
            }

            System.out.println("Program terminating successfully...");

    }


    public static boolean isCorrectSelection(String[] menuOP, String selection) {
        for(int i = 0; i < menuOP.length; i++){
            if (selection.toUpperCase().equals(menuOP[i])){
                return true;
            }
        }
        return false;
    }
}

/*

while (!= Q)
    enter election
    if...A
    if....S
        ...
    else

    enter a selection



 */
