/**
 *  LeprechaunRunner.java
 *  This class runs the LeprechaunCritter class and PotOfGold class.
 *	It creates objects of pot of gold and Leprechaun.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 04-17-2019
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import java.awt.Color;

public class LeprechaunRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		// Adding some rocks and flowers at random locations
		for (int k = 0; k < 5; k++)
		{
			world.add(new Flower(Color.cyan));
			world.add(new Rock(Color.green));
		}
	
		// Add 10 PotOfGold objects with different colors and values to grid
		for(int i = 0; i < 10; i++){
			
			int rand = (int) (Math.random() * (100 - 1)) + 1;
			
			int r = (int) (Math.random() * 255 - 10) + 10;
			int g = (int) (Math.random() * 255 - 10) + 10;
			int b = (int) (Math.random() * 255 - 10) + 10;
			
			Color randCol = new Color(r,g,b);
			world.add(new PotOfGold(rand, randCol));
		}
				
		// Add 2 LeprechaunCritter objects to grid using both constructors
		LeprechaunCritter critter1 = new LeprechaunCritter();
		
		int randValue = (int) (Math.random() * (100 - 10) + 10);
		LeprechaunCritter critter2 = new LeprechaunCritter(randValue);

		world.add(critter1);
		world.add(critter2);
		world.show();
	}
}
