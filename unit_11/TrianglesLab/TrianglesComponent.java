/**
* This triangle component draws a triangle in a triangle with recursion
* every time, the length of the triangle is halved compared to the previous one.
* Thus, it results in the Sierpinski Triangle
* @author Danny Chen
* Teacher: Garg
* Period: 3
* Date: 3-21-19
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
	// constant class array to hold progression of colors
	private static final Color LAVENDER = new Color(204, 153, 255);
	private static final Color PURPLE = new Color(153, 0, 255);
	private static final Color[] colors = {LAVENDER, Color.cyan, Color.darkGray, Color.blue, PURPLE, Color.pink, Color.black, Color.lightGray};
	private static final int SIDES = 3;
	private static final int STARTCOLOR = 0;
	private static final int DISTANCEFROMBORDER = 5;
	private static final int HALVED = 2;
	// Graphics object used for drawing
	private Graphics2D gr;
	
	/** Draw the triangles
	 *  @param g the Graphics object for drawing in this component
	 */
	@Override
	public void paintComponent(Graphics g) 
	{
		gr = (Graphics2D) g;
		drawTriangle(getWidth() / HALVED, DISTANCEFROMBORDER, DISTANCEFROMBORDER, getHeight() - DISTANCEFROMBORDER, getWidth() - DISTANCEFROMBORDER, getHeight() - DISTANCEFROMBORDER, STARTCOLOR);	
	}
	
	/**
	 * This method draws triangles and recursively calls on itself, which creates the Sierpinski tirangle
	 * @param x1 left corner
	 * @param y1 left corner
	 * @param x2 center corner
	 * @param y2 center corner
	 * @param x3 right corner
	 * @param y3 right corner
	 * @param colorIndex color based on the index in color array
	 */
	private void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int colorIndex)
	{
		if(colorIndex == colors.length - 1)
			colorIndex = STARTCOLOR;
		
		int[] xValues = {x1,x2,x3};
		int[] yValues = {y1,y2,y3};
		Polygon tri = new Polygon(xValues, yValues, SIDES);
		gr.setColor(colors[colorIndex]);
		gr.fill(tri);
		
		//Draws the center triangle
		if((y1+y2) / HALVED != y1)
			drawTriangle(x1, y1, (x1+x2) / HALVED, (y1 + y2) / HALVED, (x1 + x3) / HALVED, (y1 + y3) / HALVED, colorIndex + 1);
		//Draws the right triangle
		if((x2 + x3) / HALVED != x2)
			drawTriangle((x1 + x2) / HALVED, (y1 + y2) / HALVED, x2, y2, (x2 + x3) / HALVED, (y2 + y3) / HALVED, colorIndex + 1);
		//Draws the left triangle
		if((x2 + x3) / HALVED != x2)
			drawTriangle((x1 + x3) / HALVED, (y1 + y3) / HALVED, (x2 + x3) / HALVED, (y2 + y3) / HALVED, x3, y3, colorIndex + 1);
	}
}
