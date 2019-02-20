/**This class fills in a 2d grid with specific patterns in specific order.
 *Such as filling all the grids with row major or column major.
 *@author Danny Chen
 *Teacher: Garg
 *Period: 03
 *Date: 1/24/19
 */

import javax.swing.JOptionPane;

public class ArrayPlotter
{
	/** The Array Plotter Graphical User Interface. */
	private ArrayPlotterGUI gui;
	
	/** The Color Array.  The element values indicate how to color a grid cell:
	 *  - true: Color the cell with the Drawing Color.
	 *  - false: Color the cell with the Background Color.
	 */
	private boolean[][] colorArray;
	
	
	/** Constructs an Array Plotter */
	public ArrayPlotter()
	{
		gui = new ArrayPlotterGUI(this);
		colorArray = null;
	}
	
	/** Initialize this's Color Array to a new 2D array of boolean values
	 *  with the given dimensions.
	 *  @param rows the number of rows in the new array.
	 *  @param cols the number of columns in the new array.
	 *  Postcondition: All of the Color Array's elements have the value false.
	 */
	public void initializeColorArray(int rows, int cols)
	{
		colorArray = new boolean[rows][cols];
	}

	/** Removes all objects from the grid. */
	public void onClearGridButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for(int col = 0; col < colorArray[0].length; col++)
			{
				colorArray[row][col] = false;
				
			}
		
		}
		gui.update(colorArray);
	}
	
	/** Fills in all the cells of the grid using a row-major traversal. */
	public void onRowMajorFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for(int col = 0; col < colorArray[0].length; col++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}
	/**Fiils in all the cells of the grid using a column-major traversal. Which is filling up from top to bottom, then left to right.
	 */
	public void onColMajorFillButtonClick()
	{
		for(int col = 0; col < colorArray[0].length; col++)
		{
			for(int row = 0; row < colorArray.length; row++)
			{
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}
	/** This method fills the grid with a diagonal across the grid. This will divide the grid evenly if the grid size is a square.
	 */
	public void onMainDiagonalFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for(int col2 = 0; col2 < colorArray[0].length; col2++)
			{
				if(row == col2)
				{
					colorArray[row][col2] = true;
					gui.update(colorArray);
				}
			}
		}
	}
	/** This private method only focuses on one row at a time, and it fills it from left to right
 	 * @param row, the number of rows in the 2d grid.
	 */
	private void fillRowLeftToRight(boolean[] row)
	{
		for(int row1 = 0; row1 < row.length; row1++)
		{
			row[row1] = true;
			gui.update(colorArray);
		}
	}
	/** This private method only focuses on one row at a time, and it fills it from right to left
 	 * @param row, the number of rows in the 2d grid.
	 */
	private void fillRowRightToLeft(boolean[] row)
	{
		for(int row1 = row.length - 1; row1 >= 0; row1--)
		{
			row[row1] = true;
			gui.update(colorArray);
		}
	}
	/** Calls on both private methods. If the current number i even, then fill it from left to right. Else, *right to left. This ends up with a serpentine look.
	 */
	public void onSerpentineFillButtonClick()
	{
		for(int row1 = 0; row1 < colorArray.length; row1++)
		{
			if(row1 % 2 == 0)
			{
				fillRowLeftToRight(colorArray[row1]);
				//gui.update(colorArray[row]);
			}
				
			else
			{
				fillRowRightToLeft(colorArray[row1]);
				//gui.update(colorArray);
			}
		}
	}
	/**This fills in the grids just like the diagonal in the previous few methods. However, it fills in *everything below it, resulting in a triangle.
	 */
	public void onMainTriangleFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++)
		{
			for(int col2 = 0; col2 < colorArray[0].length; col2++)
			{
				if(row >= col2)
				{
					colorArray[row][col2] = true;
					gui.update(colorArray);
				}
			}
		}
	}
	/**This is basically the column fill, but it fills it from bottom right to top left.
	 */
	public void onReverseColMajorFillButtonClick()
	{
		for(int col = colorArray[0].length - 1; col >= 0; col--)
		{
			for(int row = colorArray.length - 1; row >= 0 ; row--)
			{
					colorArray[row][col] = true;
					gui.update(colorArray);
			}
		}
	}
	/**This fills the grid with a reflected triangle from the previous method. It also fills it in row major *order.
	 */

	public void onOtherTriangleFillButtonClick()
	{
		int index = colorArray[0].length - 2;
		for(int row = 0; row < colorArray.length; row++)
		{
			for(int col = colorArray[0].length - 1; col > index; col--)
			{
					colorArray[row][col] = true;
					gui.update(colorArray);
			}
			if(index == 0 || index == -1)
				index = -1;
			else
				index--;
		}
	}
	
	
	/** main method that creates the grid plotter application. */
	public static void main(String[] args)
	{
		ArrayPlotter plot = new ArrayPlotter();
	}
}
