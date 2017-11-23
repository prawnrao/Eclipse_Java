package module6;

public class PowerLawTheory implements Theory {

	//member variables of the equation
	private double n, x;

	//constructor
	PowerLawTheory(double n){
		this.n = n;
	}

	/**
	 * calculates a single point of the power curve
	 */
	public double y(double x) {
		return Math.pow(x,n);
	}

	/**
	 * defines the toString method, to print out a PowerLawTheory object
	 */
	public String toString() {
		return "y = x^"+n;

	}
}
