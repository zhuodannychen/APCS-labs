/** 
 *This is the rectanglecomponent class which draws rectangles layered in
 *each other using a for loop. The colors are random and the screen size
 *can be adjusted.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:11-9-18
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.*;

public class RectangleComponent extends JComponent
{
	@Override
	public void paintComponent(Graphics g)
	{
		//set initial conditions
		Graphics2D g2 = (Graphics2D) g;
		int height = getHeight();
		int width = getWidth();
		int x = 0;
		int y = 0;
		//for loop until condition reached
		//generates rectangles
		for(int i = 0; width >= 10 && height >= 5; i++)
		{
			Rectangle rec = new Rectangle(x, y, width, height);
			g2.setColor(getRandomColor());
			g2.draw(rec);
			g2.fill(rec);
			width -= 40;
			height -= 40;
			x += 20;
			y += 20;
		}			
		
	}
	
	/**genenerates random integers, which is used for the color
	 *@param min is the minimum range of the generator
	 *@param max is the max or limit of the generator
	 *@return rand returns the random integer generated
	 */
	private int getRandomInteger(int min, int max)
	{
		int rand = (int)(Math.random()*(max-min)) + min;
		return rand;
	}
	/**Generates a random color, the type is Color
	 *@return random returns a random color
	 */
	private Color getRandomColor()
	{
		Color random = new Color(getRandomInteger(0, 256), getRandomInteger(0, 256), getRandomInteger(0, 256));
		return random;
	}
}
