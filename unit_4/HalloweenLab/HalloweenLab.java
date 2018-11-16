/** 
 *This is the main client class of the HalloweenDrawing, and
 *its purpose is to set up the frame and setting it up visible.
 * @author Zhuo Chen
 * Collaborators: None
 * Teacher Name: Garg
 * Period:3
 * Due Date:10-5-18
 */

import javax.swing.JFrame;

public class HalloweenLab
{
	//frame dimensions
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 400;

	public static void main(String[] args)
	{
		//frame with my name
		JFrame frame = new JFrame("ZhuoChen3");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(10, 10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Draw shapes
		HalloweenDrawing drawing = new HalloweenDrawing();
		frame.add(drawing);
		
		// Show the frame
		frame.setVisible(true);
	}
}
