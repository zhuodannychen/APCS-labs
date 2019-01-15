/**
 *  WestStudents.java
 *  File that runs the Student.java class. Prints all the students
 *	with their name,GPA, and grade level. It finds the GPA average
 *	and number of juniors/seniors. Finally, it prints names of honors students.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 01-16-2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WestStudents
{
    public static void main( String[] args)
    {
        // Populate array of Student objects
        Student[] westWolves = loadStudents();
        
        // Display the students
        showStudents(westWolves);
        
        // Calculate the average GPA of all students
        double avgGPA = calcAverageGPA(westWolves);
        System.out.printf("Average GPA: %.5f %n%n", avgGPA);
        
        // Determine the number of juniors
        int numJuniors = calcNumInGrade(westWolves, 11);
        System.out.println("Number of juniors: " + numJuniors);
        
        // Determine the number of seniors
        int numSeniors = calcNumInGrade(westWolves, 12);
        System.out.println("Number of seniors: " + numSeniors);
        System.out.println();
        
        // Bump those with GPA in range [1.9, 2.0] to 2.0
        int numChanged = bumpGPAS(westWolves, 1.9, 2.0);
        System.out.println("Bumped " + numChanged + " gpas in [1.9, 2.0]");
        
        // Bump those with GPA in range [3.55, 3.6] to 3.6
        numChanged = bumpGPAS(westWolves, 3.55, 3.6);
        System.out.println("Bumped " + numChanged + " gpas in [3.55, 3.6]");
        System.out.println();
        
        System.out.println("After bumping:");
        showStudents(westWolves);
        
        // Get the names of students graduating with honors
        String[] honorStudents = getHonorStudents(westWolves, 3.6);
        System.out.println("Honor graduates: " + Arrays.toString(honorStudents));
        System.out.println();       
    }
    
    /** prints the name, GPA, and gradelevel of the student
     *	@param students, list of students that contain name, GPA, and grade level.
     */
    public static void showStudents(Student[] students)
    {
        // replace statement with code to print each student on separate line
        for(Student value : students)
        {
            System.out.println(value);
        }
        
        System.out.println();
    }
    /**This calculates the average GPA of the list of students in the array of students
     *@param students, list of students that contain name, GPA, and grade level.
     *@return an average GPA of all students in the list of students
     */
    public static double calcAverageGPA(Student[] students)
    {
        double sum = 0;
        for(Student value : students)
        {
            sum += value.getGPA();
        }
        return sum / students.length;
    }
    /**This calculates the number of students in a grade level
     *@param students, list of students that contain name, GPA, and grade level.
     *@param grade, the number of students you want to know based on this grade level.
     *@return the number of students in the param grade.
     */
    public static int calcNumInGrade(Student[] students, int grade)
    {
        int c = 0;
        for(Student value : students)
        {
            if(value.getGradeLevel() == grade)
                c++;
        }
        return c;
    }
    /**Calculates the number of GPAS been bumped
     *@param students, list of students that contain name, GPA, and grade level.
     *@param minGPA, the minimum GPA, lower bound
     *@param maxGPA, the maximum GPA, upper bound
     *@return the number of studnets that got bumped in the range min and max GPA.
     */
    public static int bumpGPAS(Student[] students, double minGPA, double maxGPA)
    {
        int c = 0;
        for(Student value : students)
        {
            if(value.getGPA() <= maxGPA && value.getGPA() >= minGPA)
                value.updateGPA(maxGPA);
                if(value.getGPA() == maxGPA)
                    c++;
                
        }
        return c;
    }
    /**Gets the name of all the students in the list of names.
     *@param students, list of students that contain name, GPA, and grade level.
     *@param honorsGPA, the minimum GPA for being a honors student
     *@return an array of student names that are honors students.
     */
    public static String[] getHonorStudents(Student[] students, double honorsGPA)
    {
        int c = 0;
        int a = 0;
        for(Student value : students)
        {
            if(value.getGPA() >= honorsGPA)
                c++;
        }
        String[] arr = new String[c];
        for(int i = 0; i < students.length; i++)
        {
            if(students[i].getGPA() >= honorsGPA)
            {
                arr[a] = students[i].getName();
                a++;
            }
        }
        return arr;
    }
    
    /** Generates and returns an array of Student objects with data from
 	*  the file PWSH_Students.txt
 	*  @return fully populated array of Student objects
 	*/
    private static Student[] loadStudents()
    {
        final String INPUT_FILE = "PWSH_Students.txt";
        
        // Check if the file exists
        File input = new File(INPUT_FILE);
        if (!input.exists())
        {
            System.out.println(INPUT_FILE
                + " not found. Check with your teacher.");
            System.out.println("Ending program");
            System.exit(0);
        }
        
        try
        {
            Scanner reader = new Scanner(input);
            
            // read in # of students in file and create array
            int numStudents = reader.nextInt();
            Student[] wolfpack = new Student[numStudents];
            
            // read in each students' data and add to array
            for (int k = 0; k < wolfpack.length; k++)
            {
                int grade = reader.nextInt();
                double gpa = reader.nextDouble();
                String name = reader.nextLine().trim();
                
                Student stu = new Student(name, gpa, grade);
                wolfpack[k] = stu;
            }
            
            return wolfpack;
        }
        catch (IOException exc)
        {
            System.out.println(exc.getMessage());
            System.out.println("Ending program");
            System.exit(0);
        }
        return null;
    }
}
