/**This lab draws 1000 circles first, then it draws 1000 non intersecting circles.
 *This is done by checking the current circle with the circles in an arraylist.
 *@author Danny Chen
 *Teacher: Garg
 *Period: 3
 *Date: 02-05-19
 */
 
import javax.swing.JFrame;

public class CirclesLab
{
	public static void main(String[] args)
 	{
 		final int FRAME_WIDTH = 800;
 		final int FRAME_HEIGHT = 600;

 		// Instantiate and define JFrame
 		JFrame frame = new JFrame();
 		
 		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		frame.setLocation(5, 5);
 		frame.setTitle("Circles Lab");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		// Draw circles
 		CirclesComponent component = new CirclesComponent();
 		frame.add(component);
 		frame.setVisible(true);
 	}
}
