package module5;

public class DataPoint {
	//member variables
	private double x, y, ey;

	/**
	 * Constructor
	 * @param x
	 * @param y
	 * @param ey
	 */
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}

	/**
	 * retrieves the x value
	 * @return
	 */
	public  double getX() {
		return x;
	}

	/**
	 * retrieves the y value
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * retrieves the error in y
	 * @return
	 */
	public double getEY() {
		return ey;
	}


}
