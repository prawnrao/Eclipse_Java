package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GraphicsPanel extends JPanel implements ActionListener {

	// coordinates of Sun
	static int xSun;
	static int ySun;

	// coordinates of Mercury
	int xMerc = 623;
	int yMerc = 540;
	int radMerc = 120;

	// coordinates of Venus
	int xVenus = 673;
	int yVenus = 540;
	int radVenus = 200;

	// coordinates of Earth and moon
	static int xEarth = 300;
	static int yEarth = 540;
	static int xMoon = 320;
	static int yMoon = 540;
	int radEarth = 300;
	int radMoon = 30;

	// coordinates of Mars
	int xMars;
	int yMars;
	int radMars = 450;

	private Timer animationTimer; // timer controlling frame rate
	private final int delay = 10; // delay in ms between steps
	private final double delta = 0.005;   // angle to rotate in each step
	private double angleMerc = 0.0;   // current angle of mercury on screen
	private double angleVenus = 0.0;   // current angle of venus on screen
	private double angleEarth = 0.0;   // current angle of earth on screen
	private double angleMars = 0.0;   // current angle of mars on screen
	private double angleMoon = 0.0;// current angle of moon on screen
	boolean cyc = true;

	private static final int NUM_STARS = 500; //number of stars in the star field
	private static final int MAX_STAR_RADIUS = 3;//maximum radius of the stars
	private int[] starX;	//array of x coordinates of the stars
	private int[] starY;//array of y coordinates of the stars
	private int[] starRadius;//array of radii of the stars

	private static final int NUM_AST = 3000; //total number of asteroids 
	private static final int MAX_AST_RADIUS = 5;//maximum radius of the asteroids
	private int[] astX; //array of x coordinates of the asteroids
	private int[] astY; //array of y coordinates of the asteroids
	private int[] astRadius;//array of radii of the asteroids

	/**
	 * Create panel 
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
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);

		//Filling in the stars of the star field
		g.setColor(Color.WHITE);
		for (int i = 0; i < NUM_STARS; i++) {
			g2.fillOval(starX[i], starY[i], starRadius[i], starRadius[i]);
		}

		//Filling in the asteroids of the asteroid field
		g.setColor(Color.ORANGE);
		for (int i = 0; i < NUM_AST; i++) {
			if(Math.sqrt(Math.pow((astX[i] - xSun),2) + Math.pow((astY[i] - ySun),2))>500 && Math.sqrt(Math.pow((astX[i] - xSun),2) + Math.pow((astY[i] - ySun),2))<600) {
				g2.fillOval(astX[i], astY[i], astRadius[i], astRadius[i]);
			}
		}

		// SUN
		GradientPaint sunColor = new GradientPaint(xSun, ySun-35, Color.RED, xSun, ySun+35, Color.YELLOW, cyc);
		g2.setPaint(sunColor);
		xSun = 950;
		ySun = 540;
		g2.fillOval(xSun-70/2, ySun-70/2, 70, 70);

		// MERCURY
		g.setColor(Color.GRAY);
		g.fillOval(xMerc, yMerc, 12, 12);

		// VENUS
		g.setColor(Color.ORANGE);
		g.fillOval(xVenus, yVenus, 28, 28);

		// EARTH
		GradientPaint earthColor = new GradientPaint(xSun+20, ySun+20, Color.GREEN, xSun-20, ySun-20, Color.BLUE, cyc);
		g2.setPaint(earthColor);
		g2.fillOval(xEarth, yEarth, 30, 30);

		// MARS
		g.setColor(Color.RED);
		g.fillOval(xMars, yMars, 16, 16);

		//MOON
		g.setColor(Color.GRAY);
		g.fillOval(xMoon, yMoon, 4, 4);

		Font f = new Font("TimesRoman",Font.BOLD,28);
		g.setFont(f);
	}

	/**
	 * This is called by the animation Timer object
	 * at regular intervals to rotate the shape and
	 * update the display.
	 */
	public void actionPerformed(ActionEvent event) {
		//changes the coordinates of mercury
		xMerc = (int) (xSun + radMerc*Math.cos(angleMerc));
		yMerc = (int) (ySun + radMerc*Math.sin(angleMerc));
		//changes the angle of mercury, 4.15 times faster than the angle of earth
		angleMerc +=4.15*delta;

		//changes the coordinates of venus
		xVenus = (int) (xSun + radVenus*Math.cos(angleVenus));
		yVenus = (int) (ySun + radVenus*Math.sin(angleVenus));
		//changes the angle of venus, 1.63 times faster than the angle of earth
		angleVenus += 1.63*delta;

		//changes the coordinates of earth
		xEarth = (int) (xSun + radEarth*Math.cos(angleEarth));
		yEarth = (int) (ySun + radEarth*Math.sin(angleEarth));
		//changes the angle of earth
		angleEarth += delta;

		//changes the coordinates of the moon
		xMoon = (int)(xEarth+15 + radMoon*Math.cos(angleMoon));
		yMoon = (int)(yEarth+15 + radMoon*Math.sin(angleMoon));
		//changes the angle of moon, 12 times faster than the angle of earth
		angleMoon += 12*delta;

		//changes the coordinates of mars
		xMars = (int) (xSun + radMars*Math.cos(angleMars));
		yMars = (int) (ySun + radMars*Math.sin(angleMars));
		//changes the angle of mars, 0.53 times slower than the angle of earth
		angleMars += 0.53*delta;

		repaint();//repaints all the graphics components
	}

	/**
	 * Method that creates stars with random coordinates and radii
	 * @param width
	 * @param height
	 * @param maxRadius
	 */
	public void createStarField(int width, int height, int maxRadius) {
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

	/**
	 * Method that creates asteroids with random coordinates and radii
	 * @param width
	 * @param height
	 * @param maxRadius
	 */
	public void createAstroidField(int width, int height, int maxRadius) {
		// Create the arrays
		Random rand = new Random();
		astX = new int[NUM_AST];
		astY = new int[NUM_AST];
		astRadius = new int[NUM_AST];
		// Fill them in with random values
		for (int i = 0; i < NUM_AST; i++) {
			astX[i] = rand.nextInt(width);
			astY[i] = rand.nextInt(height);
			astRadius[i] = rand.nextInt(maxRadius);
		}

	}

	/** Start the animation */
	public void start() {animationTimer.start();}

	/** Stop the animation */
	public void stop() {animationTimer.stop();}
}