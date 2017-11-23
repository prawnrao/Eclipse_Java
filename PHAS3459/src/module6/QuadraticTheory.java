package module6;

public class QuadraticTheory implements Theory{
	
	//member variables of the quadractic equation
	private double a,b,c;

	//constructor
	QuadraticTheory(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * calculates a single point of the quadratic curve
	 */
	public double y(double x) {
		return a*Math.pow(x, 2) + b*x + c;
	}
	
	/**
	 * defines the toString method, to print out a QuadraticTheory object
	 */
	public String toString() {
		return a+"x^2 + "+b+"x + "+c;

	}
}
