/**
 *  SalmonCritter.java
 *	This class creates a SalmonCritter object and extends the Critter class.
 *	Everytime a salmon matures, it can hatch new salmons in its adjacent locations
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 04-24-2019
 */
 
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.*;

public class SalmonCritter extends Critter
{
	private static final Color BIRTH = Color.ORANGE;
	private static final Color MATURITY = Color.RED;
	private static final int MATUREAGE = 4;
	private static final int MAXAGE = 10;
	private static final int PROBABILITY_OF_HATCHING = 5;
	//5 means the salmon has a 1/5 chance of hatching
	
	private int age;
	private boolean hatch;
	
	/** Constructs a SalmonCritter Object
	 */
	public SalmonCritter()
	{
		setColor(BIRTH);
		setDirection(Location.EAST);
		age = 0;
		hatch = false;
	}
	
	/** the method on how a salmon acts. If it's mature, then it changes color and can hatch.
	 *  @param actors all the actors and objects on a grid
	 */
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		age++;
		if(age >= MATUREAGE)
			setColor(MATURITY);
		if(age >= 4)
		{
			boolean val = new Random().nextInt(PROBABILITY_OF_HATCHING) == 0;
			if(val)
			{
				hatch = hatchEggs();
			}
		}
		
		for (Actor a : actors)
        {
            if (a instanceof Bug)
                a.removeSelfFromGrid();
        }
	}
	
	/** This method selects where a salmon should move. If age or if the salmon has hatched, then it gets removed.
	 *  @param loc, list of possible location the salmon can move
	 *	@return the new location the salmon will move to, null if the salmon will die.
	 */
	@Override
	public Location selectMoveLocation(ArrayList<Location> loc)
	{
		if(age >= MAXAGE)
			return null;
		else if(hatch)
			return null;
		else
			return super.selectMoveLocation(loc);
	}
	
	/** the method that determines whether a salmon will hatch or not.
	 *	@return whether a salmon hatches an egg or not
	 */
	public boolean hatchEggs()
	{
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        
		ArrayList<Location> arr = new ArrayList<>();
		arr = getGrid().getEmptyAdjacentLocations(loc);
		
		if(arr.size() > 0)
		{
			for(int i = 0; i < arr.size(); i++)
			{
				SalmonCritter sal = new SalmonCritter();
				sal.putSelfInGrid(getGrid(), arr.get(i));
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}