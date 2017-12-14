package module9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * JPanel containing a rotating square
 * that can be stopped and started.
 */
public class AnimationPanel extends JPanel implements ActionListener {
	private Polygon shape;        // shape to be displayed
	private final int delay = 50; // delay in ms between steps
	private final double delta = 0.0;   // angle to rotate in each step
	private double angle = 0.0;   // current angle of shape on screen
	private Timer animationTimer; // timer controlling frame rate
	int x;
	int y;

	/**
	 * Create panel with rotating shape.
	 * @param width width of panel
	 * @param height height of panel
	 * @param rotationTime time for complete rotation [seconds]
	 */
	AnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		int size = Math.min(width, height) / 4;
		int[] xpts = {size,-size,-size,size};
		int[] ypts = {size, size,-size,-size};
		shape = new Polygon(xpts,ypts,4);
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	
	/** Paint shape at appropriate angle. */
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int height = getHeight();
	    int width = getWidth();
	    // Fill in background
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 0, width, height);
	    // Now move origin to centre of panel
	    //g.translate(width/2, height/2);
	    // Rotate and draw shape
	    g.setColor(Color.YELLOW);
	    x=width/2;
	    y=height/2;
	    g.fillOval(x, y, 50, 50);
	  }
	  
	  /**
	   * This is called by the animation Timer object
	   * at regular intervals to rotate the shape and
	   * update the display.
	   */
	  public void actionPerformed(ActionEvent event) {
	    //angle += delta;
		  
	    repaint();
	  }
	  
	  /** Start the animation */
	  public void start() {animationTimer.start();}

	  /** Stop the animation */
	  public void stop() {animationTimer.stop();}
}