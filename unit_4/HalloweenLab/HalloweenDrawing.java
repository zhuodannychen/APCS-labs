/** 
 *This is the class that doesnt contain the main method.
 *It contains all the methods and commands for drawing a
 *specific shape. In this case, it drew a house and pumpkin
 *to prepare for Halloween.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-5-18
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class HalloweenDrawing extends JComponent
{
	private Graphics2D g2;
	private int width;
	private int height;
	
	/** Draw a house, a pumpkin, and a greeting
	 *  @param g the Graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Convert g back to its Graphics2D self
		g2 = (Graphics2D)g;
		
		// Get size of component window
		width = getWidth();
		height = getHeight();
		
		// Draw house 
		drawHouse();
		
		// Draw pumpkin
		drawPumpkin();
		
		// Draw greeting
		g2.setColor(Color.black);
		g2.drawString("HAPPY HALLOWEEN!! Trick or Treat!!",100,50);
		// Draw extra stuff
		drawExtra();
	}
	
	/** 
	 *Void method that draws a house, which is made up of a rectangle and two lines.
	 */
	public void drawHouse()
	{
		//rectangle part
		int houseX = 50;
		int houseY = 150;
		int houseWidth = 300;
		int houseHeight = 190;
		Color lightBlue = new Color(0,100,250);
		g2.setColor(lightBlue);
		Rectangle house = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		house = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		g2.fill(house);
		//roof
		double x1 = 50;
		double y1 = 150;
		double x2 = 200;
		double y2 = 100;
		g2.setColor(Color.black);
		
		Line2D.Double left = new Line2D.Double(x1, y1, x2, y2);
		g2.draw(left);
		Line2D.Double right = new Line2D.Double(350, 150, 200, 100);
		g2.draw(right);
		drawHouseFeatures(houseX, houseY, houseWidth, houseHeight);
	}
	
	/** 
	 *This draws the features of a house, such as the door and the two windows.
	 *@param houseX gives the X (horizontal) position of the house relative to the frame
	 *@param houseY gives the Y (vertical) position of the house relative to the frame
	 *@param houseWidth gives the width of the house
	 *@param houseHeight gives the height of the house
	 */
	public void drawHouseFeatures(int houseX, int houseY, int houseWidth, int houseHeight)
	{
		//door
		g2.setColor(Color.red);
		Rectangle door = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		door = new Rectangle(houseX + 120, houseY + 89, 50, 100);
		g2.draw(door);
		g2.fill(door);
		//windows
		g2.setColor(Color.magenta);
		Rectangle window1 = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		window1 = new Rectangle(houseX + 50, houseY + 89, 40, 50);
		g2.draw(window1);
		g2.fill(window1);
		
		Rectangle window2 = new Rectangle(houseX, houseY, houseWidth, houseHeight);
		window2 = new Rectangle(houseX + 200, houseY + 89, 40, 50);
		g2.draw(window2);
		g2.fill(window2);
	}
	
	/** 
	 *This draws the pumpkin, which is a body and a stem.
	 */
	public void drawPumpkin()
	{
		//draws pumpkin
		Color orange1 = new Color(234,148,0);
		g2.setColor(orange1);
		int pumpkinX = 420;
		int pumpkinY = 150;
		int pumpkinWidth = 300;
		int pumpkinHeight = 200;
		Ellipse2D.Double head = new Ellipse2D.Double(pumpkinX,pumpkinY,pumpkinWidth,pumpkinHeight);
		g2.draw(head);
		g2.fill(head);
		//draws stem
		Color green1 = new Color(39,99,61);
		g2.setColor(green1);
		int stemX = 560;
		int stemY = 135;
		int stemWidth = 20;
		int stemHeight = 40;
		Rectangle stem = new Rectangle(stemX, stemY, stemWidth, stemHeight);
		stem = new Rectangle(stemX, stemY, stemWidth, stemHeight);
		g2.draw(stem);
		g2.fill(stem);
		drawPumpkinFace(pumpkinX, pumpkinY, pumpkinWidth, pumpkinHeight);
	}
	
	/** 
	 *This draws the features of a pumpkin, which includes 2 eyes and the mouth
	 *@param pumpkinX gives the x position (horizontal) of the pumpkin relative to the frame
	 *@param pumpkinY gives the Y position (vertical) of the pumpkin relative to the frame
	 *@param pumpkinWidth gives the pumpkin's width
	 *@param pumpkinHeight gives the pumpkin's height
	 */
	public void drawPumpkinFace(int pumpkinX, int pumpkinY, int pumpkinWidth, int pumpkinHeight)
	{
		//eyes
		g2.setColor(Color.black);
		Ellipse2D.Double eyes1 = new Ellipse2D.Double(pumpkinX + 60,pumpkinY + 60,pumpkinWidth - 250,pumpkinHeight - 150);
		g2.draw(eyes1);
		g2.fill(eyes1);
		Ellipse2D.Double eyes2 = new Ellipse2D.Double(pumpkinX + 200,pumpkinY + 60,pumpkinWidth - 250,pumpkinHeight - 150);
		g2.draw(eyes2);
		g2.fill(eyes2);
		//mouth
		Ellipse2D.Double mouth = new Ellipse2D.Double(pumpkinX + 90,pumpkinY + 120,pumpkinWidth - 170,pumpkinHeight - 150);
		g2.draw(mouth);
		g2.fill(mouth);
	}
	/**
		
	 *This draws extra features of the frame.
	 */
	public void drawExtra()
	{
		//sun
		g2.setColor(Color.yellow);
		int sunX = 500;
		int sunY = 20;
		int sunWidth = 60;
		int sunHeight = 60;
		
		Ellipse2D.Double sun = new Ellipse2D.Double(sunX,sunY,sunWidth,sunHeight);
		g2.draw(sun);
		g2.fill(sun);

	}
}
