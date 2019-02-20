/** Performs a series of methods including the linear
 *search, the insertion sort, the selection sort, and *the binary search.
 *@author Danny Chen
 *Teacher: Garg
 *Period: 3
 *Date: 02-20-19
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentGroup 
{
	// Maximum number of students stored in array
	private final static int MAX_STUDENTS = 200;
	
	// Instance variables
	private Student[] students;	// array of Student objects
	private int numStudents;	// number of actual objects in array

	/** Constructs an empty student group with capacity for MAX_STUDENTS
	 */
	public StudentGroup() 
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
	}
	
	/** Constructs a student group with capacity for MAX_STUDENTS
	 *  and populates it with the student data found in the given file
	 *  @param fileName name of file containing student data
	 */
	public StudentGroup(String fileName) 
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
		readFile(fileName);
	}
	/**Finds the students by name using linear search
	 *@param name, the student name that you're trying to find.
	 *@return the student object if it's found
	 */
	public Student findByName(String name) 
	{
		for(int i = 0; i < numStudents; i++)
		{
			if(students[i].getName().equals(name))
				return students[i];
		}
		return null;
	}
	/**Sorts the students by name using insertion sort
	 */
	public void sortByName() 
	{
		//Arrays.sort(students);
		int real = numStudents;
		//int len = students.length;

		for (int i = 1; i < real; i++)
		{
			Student key = students[i];
			int position = i;

			while (position > 0 && key.getName().compareTo(students[position - 1].getName()) < 0)
			{
				students[position] = students[position - 1];
				position--;
			}
			students[position] = key;
		}
	}
	/**Sorts the student id by using a selection sort
	 */
	public void sortByID() 
	{
		int length = numStudents;
		for (int start = 0; start + 1< length; start++)
		{
			int min = start;
			for (int index = start + 1; index < length; index ++)
			{
				if (students[index].getID() < students[min].getID())
					min = index;
			}
			Student temp = students[start];
			students[start] = students[min];
			students[min] = temp;
		}
	}
	/**Finds the students by their id using binary search since the 
	 * array is already sorted from previoud steps.
	 *@param id, the student id that you're trying to find.
	 *@return the student object if it's found
	 */
	public Student findByID(int id) 
	{
		int low = 0;
		int high = numStudents - 1;
		while(low <= high)
		{
			int middle = (high + low) / 2;
			if(students[middle].getID() == id)
				return students[middle];
			else if(students[middle].getID() > id)
				high = middle - 1;
			else
				low = middle + 1;
		}
		return null;
	}

	/** Provides the group of students
	 *  @return the group of students as a string
	 */
	@Override
	public String toString() 
	{
		String str = "[";
		for (int index = 0; index < numStudents; index++) 
		{
			str += students[index].toString();
			if (index == numStudents - 1) 
				str += "]";
			else
				str += ",\n ";
		}
		return str;
	}

	/** Reads student entries from a given file and stores them in the array
	 *  @param fileName name of file containing student data in format
	 *         LAST<space>FIRST<space>ID<space>GPA
	 */
	private void readFile(String fileName) 
	{
		try 
		{
			// Open file for reading
			Scanner scan = new Scanner(new FileReader(fileName));
			
			// Continue reading and adding students until  no more entries
			// Entries are in form LAST<space>FIRST<space>ID<space>GPA
			while (scan.hasNextLine()) 
			{						
				String inputStr = scan.nextLine();
				Scanner strScan = new Scanner(inputStr);
				String lastName = strScan.next();
				String firstName = strScan.next();
				int id = strScan.nextInt();
				double gpa = strScan.nextDouble();

				Student stu = new Student(lastName, firstName, id, gpa);
				students[numStudents] = stu;
				numStudents++;
			}
			scan.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		} 
		catch (Exception e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		}
	}
}
