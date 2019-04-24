/**
 *  SalmonRunner.java
 *	This class runs the SalmonCritter class and creates 10 rocks, 10 bugs, and 2 salmons.
 *	As the salmons become more mature, they can hatch new salmons.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 04-24-2019
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class SalmonRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Place bugs, rocks, and another salmon in random locations
		world.add(new Location(0, 1), new Rock(Color.CYAN));
		world.add(new Location(1, 0), new Rock(Color.CYAN));
		world.add(new Location(1, 1), new Rock(Color.CYAN));
		
		// Add a SalmonCritter in the upper left-hand corner surrounded by rocks
		world.add(new Location(0, 0), new SalmonCritter());
		
		// Adds 10 rocks and bugs that are all at random location
		for(int i = 0; i < 10; i++)
		{
			world.add(new Rock());
			world.add(new Bug());
		}
		
		//Adds a SalmonCritter at a random location
		world.add(new SalmonCritter());

		// Do not delete this statement		
		world.show();
	}
}
