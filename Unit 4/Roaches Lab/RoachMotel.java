/** 
 *This is the main method and where the code executes for
 *the number of roaches. It uses the class RoachPopulation.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-1-18
 */

import java.util.*;

public class RoachMotel
{
  public static void main(String[] args)
  	{

	//Declares a lab, and gets in initial population
    RoachPopulation lab = new RoachPopulation();
    int labPop = lab.getRoaches();
    System.out.println("My lab has an initial population of " + labPop + " roaches.");
    System.out.println();
	//Declares a kitchen, and gives the initial population based on the input.
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter starting population of the kitchen (an integer): ");
    int initialPopulation = scan.nextInt();
    RoachPopulation kitchen = new RoachPopulation(initialPopulation);
    System.out.println("My kitchen has an initial population of " + initialPopulation + " roaches.");

	

    // Wait for the kitchen population to double and display the results
    kitchen.waitForDoubling();
    //int current stores and updates the current number of roaches.
    int current = kitchen.getRoaches();
    System.out.println();
    System.out.println("Waiting for the kitchen population to grow....");
    System.out.println("My kitchen now has " + current + " roaches");

    // Wait for the lab population to double and display the results
    lab.waitForDoubling();
    current = lab.getRoaches();
    System.out.println();
    System.out.println("Waiting for the lab population to grow....");
    System.out.println("My kitchen now has " + current + " roaches");

	//Incoporates the pesticide use and its strength
    System.out.println();
    System.out.print("Enter strength of kitchen insecticide used (ex, 22.75): ");
    double pesticideStrength = scan.nextDouble();
    current = kitchen.getRoaches();

    int killed = kitchen.spray(pesticideStrength);
    
    current = kitchen.getRoaches();

    System.out.println("My kitchen now has " + current + " roaches after killing " + killed + " roaches");

    System.out.println();
    System.out.print("Enter strength of lab insecticide used (ex, 22.75): ");
    pesticideStrength = scan.nextDouble();
    current = lab.getRoaches();

    killed = lab.spray(pesticideStrength);
    
    current = lab.getRoaches();
	//Prints out final result
    System.out.println("My lab now has " + current + " roaches after killing " + killed + " roaches");

    

  }
}
