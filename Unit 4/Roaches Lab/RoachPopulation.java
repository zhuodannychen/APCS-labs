/** 
 * This is the class that doesn't contain the main method,
 *so it doesn't run by itself, and requires the client class,
 *which is the RoachMotel. It declares several methods and two constructors.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-1-18
 */

public class RoachPopulation 
{
	//two constants
	private static final int DOUBLE_TIME = 2;
	private static final int DEFAULT_POPULATION = 10;
	//instance variable
	// The roach population
	private int numRoaches;
	
	/** 
	 *Default constructor, initializes the population to 10
	 */
	public RoachPopulation() 
	{
		numRoaches = DEFAULT_POPULATION;
	}
	/**
	 *Overloaded constructor for the kitchen
	 *@param initial takes the initial population of the roaches from a user input
	 */
	public RoachPopulation(int initial) 
	{
		numRoaches = initial;
	}
	


	/** 
	 *Provides the current roach population
	 *  @return number of roaches remaining
	 */
	public int getRoaches() 
	{
		return numRoaches;
	}


	/** 
	 *This method doubles the population
	 *it uses the constant DOUBLE_TIME
	 */
	public void waitForDoubling() 
	{
		numRoaches = numRoaches * DOUBLE_TIME;
	}
	


	/**
	 *This takes in the parameter of the strength of a pesticide, then it calculates the
	 *number of roaches killed and returns it. It also updates the roaches population.
	 *@param killPercent, the strength of pesticide used to kill the roaches.
	 *@return the number of roaches killed
	 */
	public int spray(double killPercent) 
	{
		//local variable called roachesKill
		double roachesKill = numRoaches * (killPercent/100);
		//cast and rounding is used to prevent errors
		roachesKill = (int)Math.ceil(roachesKill);
		//update on roach population
		numRoaches = numRoaches - (int)roachesKill;
		return (int)roachesKill;
	}
}
	