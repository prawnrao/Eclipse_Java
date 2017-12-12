package module9;

import java.awt.*;
import javax.swing.*;

public class SolarSystem extends JPanel {

	/** Create and display a JFrame containing a LinesPanel. */
	private static void createAndDisplayGui() {
		JFrame frame = new JFrame("Swing graphics example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SSmodel model = new SSmodel(400,400);
		Graphics g = new Graphics();
		model.drawSpaceObject(g);
		frame.add(model);       // Add panel to frame
		frame.pack();           // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
		Sun Sun = new Sun(0.0,0.0,0.0,50.0,Color.YELLOW);
//		Planet Mercury = new Planet();
//		Planet Venus = new Planet();
//		Planet Earth = new Planet();
//		Planet Mars = new Planet();
		model.drawSpaceObject(Sun);
	}

	/** Call method to create and display GUI. */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});
	}

}
