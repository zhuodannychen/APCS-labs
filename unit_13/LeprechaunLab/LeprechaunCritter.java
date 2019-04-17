/**
 *  LeprechaunCritter.java
 *  This class extends the Critter class and defines how to create the LeprechaunCritter class.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 04-17-2019
 */
 
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class LeprechaunCritter extends Critter
{
	private int purseValue;
	
	/** Creates a new LeprechaunCritter object
	 */
	public LeprechaunCritter()
	{
		purseValue = 0;
	}
	
	/** Creates a new LeprechaunCritter object with a starting value
	 *@param startValue, sets the starting value of the purseValue
	 */
	public LeprechaunCritter(int startValue)
	{
		purseValue = startValue;
	}
	
	/** Gets the amount of money in the purse
	 *@return the money in the purse
	 */
	public int getPurseValue()
	{
		return purseValue;
	}
	
	/** Overrides the default processActors method so that
	 *	the LeprechaunCritters take the highest valued, closest
	 *	PotOfGold
	 *	@param actors the array of actors
	 */
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		int maxGold = 0;
		int maxIndex = 0;
		for(int i = 0; i < actors.size(); i++)
		{
			if(actors.get(i) instanceof PotOfGold)
			{
				PotOfGold pot1 = (PotOfGold)actors.get(i);
				PotOfGold bestPot = (PotOfGold)actors.get(i);
				int largestValue = pot1.getValue();
				for(int j = 0; j < actors.size(); j++)
				{
					if(actors.get(j) instanceof PotOfGold)
					{
						PotOfGold test = (PotOfGold)actors.get(j);
						if(largestValue < test.getValue())
						{
							largestValue = test.getValue();
							bestPot = (PotOfGold)actors.get(j);
						}
					}
				}
				purseValue += largestValue;
				bestPot.empty();
			}
			getColor();
		}
	}
	
	/** Overrides the default makeMove method to change
	 *	the direction the Leprechaun faces
	 *	@param loc the location to process
	 */
	@Override
	public void makeMove(Location loc)
	{
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}
	
	/** Turns off the color on the critter's image
	 */
	public Color getColor()
	{
		return null;
	}
}