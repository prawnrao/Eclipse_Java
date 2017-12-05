package module8;

import java.util.Random;
import java.util.concurrent.Callable;

public class MonteCarloPiCalculatorTask implements Callable <Double> {
	
	private final long n_points;//Member variable
	
	/**
	 * Constructor with the input of the number of points in the MonteCarlo simulation.
	 * @param nPoints
	 */
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}


	@Override
	public Double call() {
		
		Random rand = new Random();//Instantiates a new random object
		long n_in  = 0;//Initialises a long to 0
		
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {//loops over the entire length of the input long
			
			double x = rand.nextDouble();//creates a new random double between 0 and 1
			double y = rand.nextDouble();//creates another random double between 0 and 1
			
			double r2 = x*x + y*y;//calculates the magnitude from the origin
			
			if (r2 < 1.0) ++n_in;//checks if the magnitude from the origin is less than 1, and increments n_in
		}
		
		return 4.0 * n_in / n_points;//returns the approximated value of pi
	}
}

