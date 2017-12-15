package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GraphicsPanel extends JPanel implements ActionListener {

	// coordinates of Sun
	static int xSun;
	static int ySun;
	// coordinates of Mercury
	int xMerc = 623;
	int yMerc = 325;
	int radMerc = 58;
	// coordinates of Venus
	int xVenus = 673;
	int yVenus = 325;
	int radVenus = 108;
	// coordinates of Earth
	static int xEarth = 300;
	static int yEarth = 325;
	int radEarth = 150;
	// coordinates of Mars
	int xMars;
	int yMars;
	int radMars = 228;

	private Timer animationTimer; // timer controlling frame rate
	private final int delay = 10; // delay in ms between steps
	private final double delta = 0.005;   // angle to rotate in each step
	private double angleMerc = 0.0;   // current angle of shape on screen
	private double angleVenus = 0.0;   // current angle of shape on screen
	private double angleEarth = 0.0;   // current angle of shape on screen
	private double angleMars = 0.0;   // current angle of shape on screen
	boolean cyc = true;
	private static final int NUM_STARS = 100;
    private static final int MAX_STAR_RADIUS = 3;
    private int[] starX;
    private int[] starY;
    private int[] starRadius;

	/**
	 * Create panel with rotating shape.
	 * @param width width of panel
	 * @param height height of panel
	 * @param rotationTime time for complete rotation [seconds]
	 */
	GraphicsPanel(int width, int height, double Time) {
		setPreferredSize(new Dimension(width,height));
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}

	/* Must override this method, which is called
	 * by the Swing framework whenever the display
	 * needs updating.
	 */
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2); // call superclass method first
		int width = getWidth();
		int height = getHeight();

		// BACKGROUND SPACE
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		// SUN
		GradientPaint sunColor = new GradientPaint(xSun, ySun-35, Color.RED, xSun, ySun+35, Color.YELLOW, cyc);
		g2.setPaint(sunColor);
		xSun = 600;
		ySun = 360;
		g2.fillOval(xSun-35/2, ySun-35/2, 35, 35);

		// MERCURY
		g.setColor(Color.GRAY);
		g.fillOval(xMerc, yMerc, 6, 6);

		// VENUS
		g.setColor(Color.ORANGE);
		g.fillOval(xVenus, yVenus, 14, 14);

		// EARTH
		GradientPaint earthColor = new GradientPaint(xSun+20, ySun+20, Color.GREEN, xSun-20, ySun-20, Color.BLUE, cyc);
		g2.setPaint(earthColor);
		g2.fillOval(xEarth, yEarth, 15, 15);

		// MARS
		g.setColor(Color.RED);
		g.fillOval(xMars, yMars, 8, 8);


		Font f = new Font("TimesRoman",Font.BOLD,28);
		g.setFont(f);
	}

	/**
	 * This is called by the animation Timer object
	 * at regular intervals to rotate the shape and
	 * update the display.
	 */
	public void actionPerformed(ActionEvent event) {
		
		xMerc = (int) (xSun + radMerc*Math.cos(angleMerc));
		yMerc = (int) (ySun + radMerc*Math.sin(angleMerc));
		angleMerc +=4.15*delta;
		
		xVenus = (int) (xSun + radVenus*Math.cos(angleVenus));
		yVenus = (int) (ySun + radVenus*Math.sin(angleVenus));
		angleVenus += 1.63*delta;
		
		xEarth = (int) (xSun + radEarth*Math.cos(angleEarth));
		yEarth = (int) (ySun + radEarth*Math.sin(angleEarth));
		angleEarth += delta;
		
		xMars = (int) (xSun + radMars*Math.cos(angleMars));
		yMars = (int) (ySun + radMars*Math.sin(angleMars));
		angleMars += 0.53*delta;
		
		repaint();
	}
	
    private void createStarField(int width, int height, int maxRadius) {
        // Create the arrays
    		Random rand = new Random();
        starX = new int[NUM_STARS];
        starY = new int[NUM_STARS];
        starRadius = new int[NUM_STARS];
        // Fill them in with random values
        for (int i = 0; i < NUM_STARS; i++) {
            starX[i] = rand.nextInt(width);
            starY[i] = rand.nextInt(height);
            starRadius[i] = rand.nextInt(maxRadius);
        }
        
    }

	/** Start the animation */
	public void start() {animationTimer.start();}

	/** Stop the animation */
	public void stop() {animationTimer.stop();}
}