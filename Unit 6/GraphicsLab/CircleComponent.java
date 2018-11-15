/** 
 *This is the CircleComponent class where random colored circles with random size are
 *being generated. The circles are also perfectly fitting on the screen.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:11-9-18
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.*;

public class CircleComponent extends JComponent
{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		//generating circles
		for(int i = 0; i < 100; i++)
		{
			Ellipse2D.Double circles = generateCircle();			
			g2.setColor(getRandomColor());
			g2.fill(circles);
			g2.draw(circles);
		}

	}
	/**This method generates the cirlces with random size
	 *@return the circle
	 */
	private Ellipse2D.Double generateCircle()
	{
		int h = getRandomInteger(20,51);
		
		Ellipse2D.Double circle = new Ellipse2D.Double(getRandomInteger(h, getWidth() - h), getRandomInteger(h, getHeight() - h), h, h);
		return circle;
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