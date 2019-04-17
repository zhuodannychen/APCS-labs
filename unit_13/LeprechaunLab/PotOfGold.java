/**
 *  PotOfGold.java
 *  This class is the PotOfGold class and extends the Actor class
 *	It provides code to construct a PotOfGold object.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 04-17-2019
 */
 
import info.gridworld.actor.Actor;
import java.awt.Color;

public class PotOfGold extends Actor
{
	private static final int SMALL = 1;
	private static final int BIG = 10;
	
	private int value;
	private Color color;
	
	/** Constructs a PotOfGold Object
	 *	@param goldValue the initial value of the pot
	 *	@param changePot the new color of the pot
	 */
	public PotOfGold(int value, Color color)
	{
		this.value = value;
		this.color = color;
		setColor(color);
	}
	
	/** Updates the value of the pot with a random number
	 *in between [1,10]
	 */
	@Override
	public void act()
	{
		int random = (int)(Math.random()*(BIG-SMALL)) + SMALL;
		value += random;
	}
	
	/** Gets the pot of gold's value
	 *	@return the value of the pot
	 */
	public int getValue()
	{
		return value;
	}
	
	/** Resets the pots value to 0
	 */
	public void empty()
	{
		value = 0;
	}
	
	/** Retrieves the value for displaying on the grid
	 */
	public String getText()
	{
		return "" + String.valueOf(value);  // update to return the value as a string
	}
}