package module9;

import javax.swing.*;

public class SolarSystem {

	public static void main(String[] args) {
		// call method to create and display GUI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});

	}

	public static void createAndDisplayGui() {
		JFrame frame = new JFrame("Solar System");

		// exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsPanel panel = new GraphicsPanel(1920,1080,1);
		panel.createStarField(1920,1080,3);
		panel.createAstroidField(1920, 1080, 3);
		frame.add(panel); // add label to frame
		frame.pack(); // set component sizes and layout
		frame.setVisible(true); // display resulting frame
	}

}