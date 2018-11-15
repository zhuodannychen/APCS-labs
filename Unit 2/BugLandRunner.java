/** 
 * The BugLandRunner class: This program creates a diamond of rocks displayed
 * in a certain pattern. Also, there are four bugs on the edge of the diamond,
 * and they're in different colors. Then, there's one random bug that lands anywhere
 * with random direction on the grid, and it's green.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:9-4-18
 */
 
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import java.awt.Color;
import info.gridworld.grid.Location;


public class BugLandRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		
		//The 4 individual bugs with a fixed position, naimg goes from top in a clockwise direction
		Bug bug1;
		bug1 = new Bug(Color.BLUE);
		bug1.setDirection(135);
		Location loc = new Location(0,4);
		world.add(loc, bug1);
		
		Bug bug2;
		bug2 = new Bug(Color.CYAN);
		bug2.setDirection(225);
		loc = new Location(4,9);
		world.add(loc, bug2);
		
		Bug bug3;
		bug3 = new Bug(Color.ORANGE);
		bug3.setDirection(315);
		loc = new Location(9,5);
		world.add(loc, bug3);
		
		Bug bug4;
		bug4 = new Bug(Color.GRAY);
		bug4.setDirection(45);
		loc = new Location(5,0);
		world.add(loc, bug4);
		
		//The 16 individual rocks with a specific location, and naming goes from top in a clockwise location
		Rock rock1;
		rock1 = new Rock(Color.PINK);
		loc = new Location(0,5);
		world.add(loc, rock1);
		
		Rock rock2;
		rock2 = new Rock(Color.PINK);
		loc = new Location(1,6);
		world.add(loc, rock2);
		
		Rock rock3;
		rock3 = new Rock(Color.PINK);
		loc = new Location(2,7);
		world.add(loc, rock3);
		
		Rock rock4;
		rock4 = new Rock(Color.PINK);
		loc = new Location(3,8);
		world.add(loc, rock4);
		
		Rock rock5;
		rock5 = new Rock(Color.RED);
		loc = new Location(5,9);
		world.add(loc, rock5);
		
		Rock rock6;
		rock6 = new Rock(Color.RED);
		loc = new Location(6,8);
		world.add(loc, rock6);
		
		Rock rock7;
		rock7 = new Rock(Color.RED);
		loc = new Location(7,7);
		world.add(loc, rock7);
		
		Rock rock8;
		rock8 = new Rock(Color.RED);
		loc = new Location(8,6);
		world.add(loc, rock8);
		
		Rock rock9;
		rock9 = new Rock(Color.BLUE);
		loc = new Location(9,4);
		world.add(loc, rock9);
		
		Rock rock10;
		rock10 = new Rock(Color.BLUE);
		loc = new Location(8,3);
		world.add(loc, rock10);
		
		Rock rock11;
		rock11 = new Rock(Color.BLUE);
		loc = new Location(7,2);
		world.add(loc, rock11);
		
		Rock rock12;
		rock12 = new Rock(Color.BLUE);
		loc = new Location(6,1);
		world.add(loc, rock12);
		
		Rock rock13;
		rock13 = new Rock(Color.YELLOW);
		loc = new Location(4,0);
		world.add(loc, rock13);
		
		Rock rock14;
		rock14 = new Rock(Color.YELLOW);
		loc = new Location(3,1);
		world.add(loc, rock14);
		
		Rock rock15;
		rock15 = new Rock(Color.YELLOW);
		loc = new Location(2,2);
		world.add(loc, rock15);
		
		Rock rock16;
		rock16 = new Rock(Color.YELLOW);
		loc = new Location(1,3);
		world.add(loc, rock16);

		world.show();
		
		//Random bug: BONUS
		Bug random1;
		random1 = new Bug(Color.GREEN);
		//Direction and location are random
		world.add(random1);
		//Random bug Acts twice
		random1.act();
		random1.act();
		//Prints out direction
		int dir2 = random1.getDirection();
		System.out.println("Direction: " + dir2);
		//Prints out location
		loc = random1.getLocation();
		System.out.println("Location: " + loc);

		
		
		
		
		// show the world - DO NOT DELETE THIS!!!!
		world.show();
	}
}
