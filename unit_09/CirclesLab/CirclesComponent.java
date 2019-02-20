/**This class actually generates the circles and checks whether it intersects or not.
 *  @author Danny Chen
 *	Teacher: Garg
 *	Period: 3
 *  Date: 02-05-19
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class CirclesComponent extends JComponent
{
	//arraylist of circles
	private ArrayList<Ellipse2D.Double> arr;
	public CirclesComponent()
	{
		arr = new ArrayList<Ellipse2D.Double>();
	}
	
	/**
	 *  Generate and draw all of the circles
	 *  @param g the graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		generateCircles();
		drawCircles(g2);
	}
	/**Generates 1000 circles, only adds it if it doesn't intersect with any other current circle.
	 */
	private void generateCircles()
	{
		arr = new ArrayList<Ellipse2D.Double>();
		while(arr.size() != 1000)
		{
			double diameter = Math.random()*60 + 1;
			Ellipse2D.Double cir = new Ellipse2D.Double(Math.random()*(getWidth() - diameter), Math.random()*(getHeight() - diameter), diameter, diameter);
			//checks if intersects with other circles
			if(!circleIntersects(cir))
				arr.add(cir);
			
		}
		//System.out.println(arr.size());
		
	}
	/**
	 *  Generates random colored circles
	 *  @param g2 the graphics object for drawing
	 */
	private void drawCircles(Graphics2D g2)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			Ellipse2D.Double circles= arr.get(i);
			Color random = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
			g2.setColor(random);
			g2.draw(circles);
		}
	}
	/**
	 *  checks whether the circle intersects or not with any other circle.
	 *  @param circle, the current circle
	 *	@return whether the circle intersects or not with other circles in the arraylist
	 */
	private boolean circleIntersects(Ellipse2D.Double circle)
	{
		
		for(int i = 0; i < arr.size(); i++)
		{
			Ellipse2D.Double current = arr.get(i);
			double centerDistance = Math.sqrt(Math.pow(current.getCenterX() - circle.getCenterX(), 2) + Math.pow(current.getCenterY() - circle.getCenterY(), 2));
			double radiDistance = (circle.getWidth() / 2) + (current.getWidth() / 2);
			//System.out.println(centerDistance);
			//System.out.println(radiDistance);
			//System.out.println(centerDistance >= radiDistance);
			
			if(centerDistance < radiDistance)
			{
				return true;
			}
		}
		
		return false;
		
	}
}