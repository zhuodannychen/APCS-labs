/** 
 *This is graphics lab where rectangles and circles are being generated
 *using the RectangleComponent class and the CircleComponent class. It shows
 *using JFrame
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:11-9-18
 */
import javax.swing.JFrame;
 
public class GraphicsLab
{
	public static void main(String[] args)
 	{
 		//initial frame size, which can change
 		final int FRAME_WIDTH = 550;
 		final int FRAME_HEIGHT = 350;

 		// Instantiate and define JFrame
 		JFrame frame = new JFrame();
 		
 		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		frame.setLocation(5, 5);
 		frame.setTitle("Graphics Lab");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		// Draw circles
 		CircleComponent component = new CircleComponent();
 		frame.add(component);
 		// Show frame
 		frame.setVisible(true);
		// Show the rectangles
  		JFrame bonusFrame = new JFrame();
  		bonusFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		bonusFrame.setLocation(5, FRAME_HEIGHT + 10);
 		bonusFrame.setTitle("Rectangles");
 		bonusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		bonusFrame.add(new RectangleComponent());
 		bonusFrame.setVisible(true);
	}
}
