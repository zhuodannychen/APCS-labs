/** 
 *This is a speeding ticket calculator to see how much you would have to pay if you
 *overspeed. There are different values for both in school zone and out, and if you
 *speed over 30 miles per hour, there is an extra $175.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-17-18
 */

import java.util.*;
public class SpeedingTicket 
{
	//Constants to prevent magic numbers
	public static final int MIN_COST_TICKET = 50;
	public static final int STANDARD_RATE = 7;
	public static final int SCHOOL_ZONE = 15;
	public static final int EXCESSIVE_SPEED_THRESHOLD = 30;
	public static final int EXCESSIVE_SPEED_COST = 175;	

	public static void main(String[] args) 
	{
		//scan in user input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter driver's name: ");
	
		String driver = in.nextLine();
		
		System.out.print("Enter driver's speed: ");
		int speedTravel = in.nextInt();
		System.out.print("Enter speed limit: ");
		int speedLimit = in.nextInt();
		System.out.print("Was driver in school zone? ");
		String answer = in.next();
		System.out.println();
		int cost = calcTicket(speedTravel, speedLimit, answer);
		System.out.print("Speed traveled: ");
		System.out.printf("%3d\n", speedTravel);
		System.out.print("Speed limit: ");
		System.out.printf("%6d\n", speedLimit);
		System.out.print("In school zone: ");
		System.out.printf("%3s\n", answer);
		System.out.println(driver + " owes $" + cost);
	}

	/** 
	 *This uses if statements to calculate the final cost of the person,
	 *it checks if the person is in school and if he or she is speeding over 30 miles.
	 *@param speedDriving takes in the speed which the driver is driving
	 *@param speedLimit takes in the speed limit
	 *@param schoolZone takes in a string if user is in school zone or not
	 *@return ticket cost in the end after calculation
	 */ 
	public static int calcTicket(int speedDriving, int speedLimit, String schoolZone)
	{
		int cost;
		speedDriving = speedDriving - speedLimit;
		
		if(schoolZone.equalsIgnoreCase("yes"))
		{
			cost = MIN_COST_TICKET + SCHOOL_ZONE*speedDriving;
			
		}
		else
		{
			cost = MIN_COST_TICKET + STANDARD_RATE*speedDriving;
		}
		if(speedDriving > EXCESSIVE_SPEED_THRESHOLD)
		{
			cost += EXCESSIVE_SPEED_COST;
		}
		return cost;
	
	}
}		
