package module9;

import javax.swing.*;
import java.awt.*;

public class SSmodel extends JPanel {

	/**
	 * Constructor which sets the size of the panel
	 * @param width
	 * @param height
	 */
	public SSmodel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
	}


	protected void drawSpaceObject(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
	}
}
