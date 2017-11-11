package module5;

public class Theory {
	//member variable
	private double n;

	/**
	 * Constructor to set the value of n
	 * @param n
	 */
	public Theory(double n) {
		this.n = n;
	}

	/**
	 * function y=x^n
	 * @param x
	 * @return
	 */
	public double y(double x) {
		double y = Math.pow(x,n);
		return y;
	}
}
