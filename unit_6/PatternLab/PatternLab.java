/**This lab produces patterns using gridworlds, and nested loops are used
 *to make the pattern *  
 * @author Zhuo Chen
 * Teacher Name: Garg
 * Period: 3
 * Due Date: 11-15-18
 */

import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class PatternMaker
{
	// Dimensions for the different worlds
	public static final int NUM_ROWS_NUMBER_GRID = 10;
	public static final int NUM_COLS_NUMBER_GRID = 10;
	
	public static final int NUM_ROWS_COLOR_GRID = 19;
	public static final int NUM_COLS_COLOR_GRID = 19;
	
	//main, where patterns are executed
	public static void main(String[] args)
	{
		drawPattern1(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
		drawPattern2(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern3(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern4(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	}
	

	/**Draws the number of pyramid
	 *@param numRows takes in the current number of rows
	 *@param numCols takes in the current number of columns
	 */
	public static void drawPattern1(int numRows, int numCols)
	{
		BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
		World<Integer> world = new World<Integer>(grid);
		
		for (int col = 0; col < numCols; col++)
		{
			for (int row = 0; row <= col; row++)
			{
				Location myLoc = new Location(col, row);
				world.add(myLoc, row);
				
			}
		}
		
		world.show();
	}
	
	/**Draws a diagonal line with 2 triangles of different colors
	 *@param numRows takes in the current number of rows
	 *@param numCols takes in the current number of columns
	 */
	public static void drawPattern2(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		for (int col = NUM_COLS_COLOR_GRID - 1; col >= 0; col--)
		{
			for (int row = NUM_ROWS_COLOR_GRID - 1; row >= 0; row--)
			{
				Location myLoc = new Location(col, row);
				world.add(myLoc, Color.BLUE);
				
			}
		}
		
		
		for (int col = 0; col < numCols; col++)
		{
			for (int row = 0; row <= col; row++)
			{
				Location myLoc = new Location(col, row);
				world.add(myLoc, Color.GREEN);
				
			}
		}
		
		
		numCols = 0;
		for(numRows = 1; numRows <= NUM_ROWS_COLOR_GRID; numRows++)
		{
			Location loc = new Location(numRows - 1, numCols);
			world.add(loc, Color.black);
			numCols++;
		}
		world.show();
	}
	
	/**Draws columns of colors in a specific pattern
	 *@param numRows takes in the current number of rows
	 *@param numCols takes in the current number of columns
	 */
	public static void drawPattern3(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		for(numCols = 0; numCols <= NUM_COLS_COLOR_GRID; numCols += 3)
		{
			for(numRows = 0; numRows < NUM_ROWS_COLOR_GRID; numRows++)
			{
				Location loc = new Location(numRows, numCols);
				world.add(loc, Color.BLACK);
			}
		}
		
		
		for(numCols = 2; numCols <= NUM_COLS_COLOR_GRID; numCols += 3)
		{
			for(numRows = 0; numRows < NUM_ROWS_COLOR_GRID; numRows++)
			{
				Location loc = new Location(numRows, numCols);
				world.add(loc, Color.GREEN);
			}
		}
		world.show();
	}
	
	/**Draws a pyramid
	 *@param numRows takes in the current number of rows
	 *@param numCols takes in the current number of columns
	 */
	public static void drawPattern4(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		int max = 9;
		int less = 18;
		//top right
		for (int row = max; row >= 0; row--)
		{
			for (int col = max; col <= (row + max); col++)
			{
				Location myLoc = new Location(col, row);
				world.add(myLoc, Color.GREEN);
				
			}
		}
		//bottom left
		for (int row = max; row >= 0; row--)
		{
			for (int col = max; col <= (row + max); col++)
			{
				Location myLoc = new Location(row, col);
				world.add(myLoc, Color.GREEN);
				
			}
		}
		//bottom right
		for (int row = max; row >= 0; row--)
		{
			for (int col = max; col <= (row + max); col++)
			{
				Location myLoc = new Location(0 - row + less, col);
				world.add(myLoc, Color.GREEN);
				
			}
		}
		
		//top left
		for (int row = max; row >= 0; row--)
		{
			for (int col = max; col <= (row + max); col++)
			{
				Location myLoc = new Location(0 - col + less, row);
				world.add(myLoc, Color.GREEN);
				
			}
		}
		
		world.show();
	}
}
