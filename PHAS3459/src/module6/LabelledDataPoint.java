package module6;

public class LabelledDataPoint extends DataPoint{
	
	public String label;

	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param ey
	 * @param label
	 */
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label = label;
	}

	/**
	 * defines the toString method, to print out a LabelledDataPoint
	 */
	public String toString() {
		return label +": x = "+ x + ", y = "+ y + " +- "+ ey;

	}
}
